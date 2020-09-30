package com.example.framedemo.ui.home.presenter

import com.example.framedemo.ui.home.contract.HomeContract
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.db.dao.HotKeyDao
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.utils.LogUtils
import org.xml.sax.ErrorHandler

/**
 * 首页 Presenter
 */
class HomePresenter : BasePresenter<HomeContract.View>(),HomeContract.Presenter{

    override fun getHotkey() {
        // runRxLambda 网络请求工具使用
        runRxLambda(RetrofitManager.service.getHotkey(),{
            // 保存到数据库
            val hotkeyDao: HotKeyDao = AppDataBase.instance(BaseApplication.context).getHotKeyDao()
            hotkeyDao.getAllHotKey().clear()
            hotkeyDao.insertAll(it.data)
            mRootView?.showHotkeys(it.data)
        },{
            mRootView?.showError(ExceptionHandle.handleException(it))
        },{
            addSubscription(it)
        })
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