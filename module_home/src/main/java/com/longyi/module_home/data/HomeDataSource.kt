package com.longyi.module_home.data

import com.example.lib_common.model.Article
import com.example.lib_common.model.Banner
import com.example.lib_common.model.ImageData

/**
 * Created by Aller on 2020/10/22.
 */
object HomeDataSource {

    var mArticles = mutableListOf<Article>()
    var mBanners = mutableListOf<Banner>()
    var mImageDatas = mutableListOf<ImageData>()


    fun setBanners(banners:MutableList<Banner>){
       this.mBanners = banners
    }
    fun getBanners():MutableList<Banner>{
        return this.mBanners
    }


    fun setArticles(articles:MutableList<Article>){
        this.mArticles.addAll(articles)
    }

    fun getArticles():MutableList<Article>{
        return this.mArticles
    }

    fun setImageDatas(images:MutableList<ImageData>){
        this.mImageDatas = images
    }
    fun getImageDatas():MutableList<ImageData>{
        return this.mImageDatas
    }
}