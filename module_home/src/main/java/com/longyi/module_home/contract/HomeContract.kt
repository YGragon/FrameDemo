package com.longyi.module_home.contract

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter
import com.example.lib_common.model.Article
import com.example.lib_common.model.Banner
import com.example.lib_common.model.Hotkey

/**
 * 首页 Contract
 */
interface HomeContract {
    interface View : IBaseView {
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 banner
         */
        fun showBanners(banners: MutableList<Banner>)

        /**
         * 显示 hotkey
         */
        fun showHotkeys(hotkeys: MutableList<Hotkey>)

        /**
         * 加载完成显示 article
         */
        fun showLoadCompleteArticles(articles: MutableList<Article>)

        /**
         * 全部显示 article
         */
        fun showLoadEndArticles(articles: MutableList<Article>)
    }

    interface Presenter: IPresenter<View> {

        /**
         * 获取 搜索热词
         */
        fun getHotkey()

        /**
         * 获取 banner
         */
        fun getBanners()

        /**
         * 获取首页文章列表
         */
        fun getArticles(page:Int)
    }
}