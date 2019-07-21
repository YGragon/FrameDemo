package com.example.framedemo.ui.home.contract

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter
import com.example.lib_common.model.Banner

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
    }

    interface Presenter: IPresenter<View> {
        /**
         * 获取 banner
         */
        fun getBanners()
    }
}