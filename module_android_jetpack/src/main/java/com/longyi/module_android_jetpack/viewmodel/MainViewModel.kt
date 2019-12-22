package com.example.uitestdemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.uitestdemo.data.db.StudentDb

class MainViewModel(app: Application) : AndroidViewModel(app)  {
    val dao = StudentDb.get(app).studentDao()

    val allStudents = LivePagedListBuilder(dao.getAllStudent(), PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
        .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
        .build()).build()

    companion object {
        private const val PAGE_SIZE = 15

        private const val ENABLE_PLACEHOLDERS = false
    }
}