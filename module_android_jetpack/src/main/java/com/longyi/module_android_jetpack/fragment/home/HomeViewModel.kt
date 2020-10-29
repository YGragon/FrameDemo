package com.longyi.module_android_jetpack.fragment.home

import androidx.lifecycle.LifecycleOwner
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseViewModel
import com.example.lib_common.db.AppDataBase

/**
 * Created by Aller on 2020/6/6.
 */
class HomeViewModel(val view:LifecycleOwner): BaseViewModel() {

    companion object {
        private const val PAGE_SIZE = 15
        private const val ENABLE_PLACEHOLDERS = false
    }

//    val mContext = context
//    val dao = StudentDb.get(mContext).studentDao()

    val dao = AppDataBase.instance(BaseApplication.context).getStudentDao()

    val allStudents = LivePagedListBuilder(dao.getAllStudent(), PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
        .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
        .build()).build()
}