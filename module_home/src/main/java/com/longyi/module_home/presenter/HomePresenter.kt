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
import com.example.lib_common.http.runRxLambdaViewModel
import com.example.lib_common.model.Article
import com.longyi.module_home.data.HomeDataSource
import com.example.lib_common.service.user_center.ILoginService
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils


/**
 * 首页 Presenter
 */
class HomePresenter(private val view:LifecycleOwner) : BasePresenter<HomeContract.View>(), HomeContract.Presenter{

    override fun bindLike(article: Article) {
        // 是否登录，未登录不可收藏
        val loginService = ARouter.getInstance().build("/provider/ILoginService").navigation() as ILoginService
        val login = loginService.isLogin()
        Log.e("222", "bindLike login:$login")
        if (login){
            if (article.collect){
                unLike(article)
            }else{
                like(article)
            }
        }else{
            mRootView?.showError("你还未登录哟")
        }


    }

    private fun unLike(article: Article){
        // runRxLambda 网络请求工具使用
        runRxLambdaViewModel(AndroidLifecycleScopeProvider.from(view),RetrofitManager.service.regionUnCollect(article.id),{
            if (it.errorCode == 0){
                // 成功
                mRootView?.showBindLikeSuccess("取消收藏成功",false, article)
            }else{
                // 失败
                mRootView?.showBindLikeFail("取消收藏失败：${it.errorMsg}",article)
            }
        })
    }
    private fun like(article: Article){
        // runRxLambda 网络请求工具使用
        runRxLambdaViewModel(AndroidLifecycleScopeProvider.from(view),RetrofitManager.service.regionCollect(article.id),{
            if (it.errorCode == 0){
                // 成功
                mRootView?.showBindLikeSuccess("收藏成功",true, article)
            }else{
                // 失败
                mRootView?.showBindLikeFail("收藏失败：${it.errorMsg}",article)
            }
        })
    }


    override fun getBannerUrl(position:Int): String {
        return HomeDataSource.mBanners[position].url
    }

    override fun toWebDetail(url:String) {
        LogUtils.e("url:$url")
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
                mRootView?.showLoadEndArticles(it.data.datas)
            } else {
                // 用于给 app 传递当前最新的数量值
                HomeDataSource.setArticles(it.data.datas)
                mRootView?.showLoadCompleteArticles(it.data.datas)
            }
        },{
            mRootView?.showError(ExceptionHandle.handleException(it))
        })

    }

}