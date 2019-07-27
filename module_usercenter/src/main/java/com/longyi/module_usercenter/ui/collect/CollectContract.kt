package com.longyi.module_usercenter.ui.collect

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter
import com.example.lib_common.model.Collect

/**
 * 注册
 */
interface CollectContract {
    interface View:IBaseView{
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 收藏结果
         */
        fun showLoadComplete(collects:MutableList<Collect>)

        /**
         * 全部加载完成
         */
        fun showLoadEnd(collects:MutableList<Collect>)
    }

    interface Presenter: IPresenter<View> {
        /**
         * 获取收藏列表
         */
        fun getCollects(page:Int)
    }
}