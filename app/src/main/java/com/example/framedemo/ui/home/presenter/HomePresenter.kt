package com.example.framedemo.ui.home.presenter

import com.example.framedemo.ui.home.contract.HomeContract
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.db.dao.HotKeyDao
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.utils.LogUtils

/**
 * 首页 Presenter
 */
class HomePresenter : BasePresenter<HomeContract.View>(),HomeContract.Presenter{

    override fun getHotkey() {
        val disposable = RetrofitManager.service.getHotkey()
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                // 保存到数据库
                val hotkeyDao: HotKeyDao = AppDataBase.instance(BaseApplication.context).getHotKeyDao()
                hotkeyDao.getAllHotKey().clear()
                hotkeyDao.insertAll(res.data)

                mRootView?.showHotkeys(res.data)
            }, { throwable ->
                mRootView?.showError(throwable.message.toString())
            })
        addSubscription(disposable)
    }


    override fun getBanners() {
        val disposable = RetrofitManager.service.getBanners()
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showBanners(res.data)
            }, { throwable ->
                mRootView?.showError(throwable.message.toString())
            })
        addSubscription(disposable)
    }

    override fun getArticles(page:Int) {
        val disposable = RetrofitManager.service.getArticles(page)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                if (res.data != null){
                    if (res.data.curPage == res.data.pageCount) {
                        mRootView?.showLoadEndArticles(res.data.datas)
                    } else {
                        mRootView?.showLoadCompleteArticles(res.data.datas)
                    }
                }
            }, { throwable ->
                mRootView?.showError(throwable.message.toString())
            })
        addSubscription(disposable)
    }

}