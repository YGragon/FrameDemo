package com.longyi.module_android_jetpack.fragment.home

import android.content.Context
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.uitestdemo.data.db.StudentDb
import com.example.lib_common.base.BaseViewModel

/**
 * Created by Aller on 2020/6/6.
 */
class HomeViewModel(context: Context): BaseViewModel() {

    companion object {
        private const val PAGE_SIZE = 15
        private const val ENABLE_PLACEHOLDERS = false
    }

//    val mContext = context
//    val dao = StudentDb.get(mContext).studentDao()

    val dao = StudentDb.get().studentDao()

    val allStudents = LivePagedListBuilder(dao.getAllStudent(), PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
        .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
        .build()).build()
}