package com.longyi.module_gank

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter
import com.example.lib_common.model.*

/**
 * 干货福利
 */
interface GankPhotoContract {
    interface View: IBaseView {
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 干货图片 列表
         */
        fun showGankPhotoResult(list:MutableList<GankPhoto>)

        /**
         * 显示 搜索 空列表
         */
        fun showGankEmptyResult()
    }

    interface Presenter: IPresenter<View> {

        /**
         * 获取干货图片结果
         */
        fun getGankPhoto(count:Int,page:Int)


    }
}