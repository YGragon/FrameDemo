package com.longyi.module_home.data

import com.example.lib_common.model.Article
import com.example.lib_common.model.Banner

/**
 * Created by Aller on 2020/10/22.
 */
object HomeDataSource {

    var mArticles = mutableListOf<Article>()
    var mBanners = mutableListOf<Banner>()


    fun setBanners(banners:MutableList<Banner>){
       this.mBanners = banners
    }


    fun setArticles(articles:MutableList<Article>){
        this.mArticles.addAll(articles)
    }
}