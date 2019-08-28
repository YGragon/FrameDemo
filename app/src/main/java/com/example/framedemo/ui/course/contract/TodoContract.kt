package com.example.framedemo.ui.mine.contract

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter
import com.example.lib_common.model.Banner
import com.example.lib_common.model.Todo

/**
 * TD
 */
interface TodoContract {
    interface View:IBaseView{
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 未完成列表
         */
        fun showUnFinishList(list: MutableList<Todo>)

    }

    interface Presenter:IPresenter<View>{
        /**
         * 获取 未完成列表
         */
        fun getUnFinishList(page:Int,status:Int = 0,type:Int,priority:Int,orderby:Int = 4)

        /**
         * 获取完成列表
         */
        fun getFinishList(page:Int,status:Int = 1,type:Int,priority:Int,orderby:Int = 4)


    }
}