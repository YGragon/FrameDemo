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
         * 显示列表
         */
        fun showList(curPage:Int, totalPage:Int, list: MutableList<Todo>)

    }

    interface Presenter:IPresenter<View>{
        /**
         * 获取列表
         */
        fun getList(page:Int,status:Int,type:Int,priority:Int,orderby:Int = 4)


    }
}