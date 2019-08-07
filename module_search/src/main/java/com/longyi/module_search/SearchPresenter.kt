package com.longyi.module_search

import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.http.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.model.Hotkey
import com.example.lib_common.model.SearchHistory
import com.example.lib_common.utils.DateUtils

/**
 * 搜索
 */
class SearchPresenter : BasePresenter<SearchContract.View>(),SearchContract.Presenter{

    val searchDao = AppDataBase.instance(BaseApplication.context).getSearchHistoryDao()
    val hotKeyDao = AppDataBase.instance(BaseApplication.context).getHotKeyDao()

    override fun saveSearchHistory(keyword: String) {
        val searchHistory = SearchHistory(sId = DateUtils.getCurrentSystemTime(),keyWord = keyword)
        searchDao.insert(searchHistory)
    }

    override fun getHotKeys() {
        // 首页传递过来
        if (hotKeyDao.getAllHotKey().isNotEmpty()){
            mRootView?.showHotkeys(hotKeyDao.getAllHotKey())
        }else{
            mRootView?.hideHotkeys()
        }
    }

    override fun getHistorys() {
        // 从数据库中获取
        if (searchDao.getAllSearchHistory().isNotEmpty()){
            mRootView?.showHistorys(searchDao.getAllSearchHistory())
        }else{
            mRootView?.hideHistorys()
        }
    }

    override fun getSearchResult(page:Int,key_word:String) {
        // 从服务器获取
        val disposable = RetrofitManager.service.getSearchs(page,key_word)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                if (res.data != null){
                    // 获取到结果
                    if (res.data.datas.isEmpty()){
                        // 显示空页面
                        mRootView?.showSearchEmptyResult()
                    }else{
                        mRootView?.showSearchResult(res.data.datas)
                    }
                }else{
                    // 显示空页面
                    mRootView?.showSearchEmptyResult()
                }

            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)
    }
}