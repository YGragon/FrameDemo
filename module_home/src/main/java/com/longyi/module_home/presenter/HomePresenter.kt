package com.longyi.module_home.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.longyi.module_home.contract.HomeContract
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.db.dao.HotKeyDao
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.UrlConstant
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.runRxLambdaViewModel
import com.example.lib_common.model.Article
import com.example.lib_common.model.Banner
import com.longyi.module_home.data.HomeDataSource

/**
 * 首页 Presenter
 */
class HomePresenter(private val view:LifecycleOwner) : BasePresenter<HomeContract.View>(), HomeContract.Presenter{



    override fun getBannerUrl(position:Int): String {
        return HomeDataSource.mBanners[position].url
    }

    override fun getArticleUrl(position:Int): String {
        return  HomeDataSource.mArticles[position].link
    }

    override fun getArticleChapterUrl(position:Int): String {
        val article = HomeDataSource.mArticles[position]
        return if (article.tags.isNotEmpty()){
            UrlConstant.BASE_URL+HomeDataSource.mArticles[position].tags[0].url
        }else{
            ""
        }
    }

    override fun toWebDetail(url:String) {
        ARouter.getInstance()
            .build(RouterPath.Web.WEB_DETAIL)
            .withString(ParameterConstant.Web.webUrl,url)
            .navigation()
    }

    override fun getHotkey() {
        // runRxLambda 网络请求工具使用
        runRxLambdaViewModel(AndroidLifecycleScopeProvider.from(view),RetrofitManager.service.getHotkey(),{
            // 保存到数据库
            val hotkeyDao: HotKeyDao = AppDataBase.instance(BaseApplication.context).getHotKeyDao()
            hotkeyDao.getAllHotKey().clear()
            hotkeyDao.insertAll(it.data)
            mRootView?.showHotkeys(it.data)
        })
    }


    override fun getBanners() {
        runRxLambdaViewModel(AndroidLifecycleScopeProvider.from(view),RetrofitManager.service.getBanners(),{
            HomeDataSource.setBanners(it.data)

            val imageUrls = mutableListOf<String>()
            val titles = mutableListOf<String>()
            for (i in it.data){
                imageUrls.add(i.imagePath)
                titles.add(i.desc)

            }
            mRootView?.showBanners(imageUrls,titles)
        })
    }

    override fun getArticles(page:Int) {
        runRxLambdaViewModel(AndroidLifecycleScopeProvider.from(view),RetrofitManager.service.getArticles(page),{
            if (it.data.curPage == it.data.pageCount) {
                HomeDataSource.setArticles(it.data.datas)
                mRootView?.showLoadEndArticles()
            } else {
                HomeDataSource.setArticles(it.data.datas)
                mRootView?.showLoadCompleteArticles()
            }
        },{
            mRootView?.showError(ExceptionHandle.handleException(it))
        })

    }

}