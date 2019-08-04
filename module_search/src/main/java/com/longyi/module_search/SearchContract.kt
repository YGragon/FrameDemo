package com.longyi.module_search

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter
import com.example.lib_common.model.Hotkey
import com.example.lib_common.model.SearchBean
import com.example.lib_common.model.SearchHistory
import com.example.lib_common.model.SearchList

/**
 * 搜索
 */
interface SearchContract {
    interface View: IBaseView {
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 热搜
         */
        fun showHotkeys(hotkeys:MutableList<Hotkey>)
        /**
         * 隐藏 热搜
         */
        fun hideHotkeys()

        /**
         * 显示 历史记录
         */
        fun showHistorys(searchHistory:MutableList<SearchHistory>)

        /**
         * 隐藏 历史记录
         */
        fun hideHistorys()

        /**
         * 显示 搜索 列表
         */
        fun showSearchResult(list:MutableList<SearchBean>)
    }

    interface Presenter: IPresenter<View> {
        /**
         * 获取首页传递过来的热搜
         */
        fun getHotKeys()

        /**
         * 获取搜索历史
         */
        fun getHistorys()

        /**
         * 保存搜索历史记录
         */
        fun saveSearchHistory(keyword: String)

        /**
         * 获取搜索结果
         */
        fun getSearchResult(page:Int,key_word:String)


    }
}