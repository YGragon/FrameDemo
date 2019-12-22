package com.example.framedemo.ui.mine.contract

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter
import com.example.lib_common.model.Banner

/**
 * 用户中心
 */
interface MineContract {
    interface View:IBaseView{
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 用户名
         */
        fun showUserInfo()

        /**
         * 显示 退出成功
         */
        fun showLoginOutSuccess()
    }

    interface Presenter:IPresenter<View>{
        /**
         * 获取 用户信息
         */
        fun getUserInfo()

        /**
         * 上传文件
         */
        fun uploadFile(path: String)

        /**
         * 退出登录
         */
        fun loginOut()
    }
}