package com.longyi.module_home

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.longyi.module_home.contract.HomeContract
import com.longyi.module_home.presenter.HomePresenter
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Article
import com.example.lib_common.model.Banner
import com.example.lib_common.model.Hotkey
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.utils.imageloader.GlideImageLoader
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * 首页 fragment
 *
 */
@Route(path =  RouterPath.Home.HOME,name = "首页")
class HomeFragment : BaseFragment(), HomeContract.View {

    private var mArticles = mutableListOf<Article>()
    private var mBanners = mutableListOf<Banner>()
    private var mPage = 0

    private var isShowToUser = true

    private lateinit var mAdapter:HomeAdapter
    private lateinit var banner:com.youth.banner.Banner

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { HomePresenter() }
    init {
        mPresenter.attachView(this)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun initData() {
    }


    override fun initView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        rv_home_list.layoutManager = linearLayoutManager
        mAdapter = HomeAdapter(mArticles)
        val headBanner = LayoutInflater.from(activity).inflate(R.layout.head_home_banner,null)
        banner = headBanner.findViewById(R.id.banner)
        mAdapter.addHeaderView(headBanner)
        rv_home_list.adapter = mAdapter

        banner.setOnBannerListener {
            ARouter.getInstance()
                .build(RouterPath.Web.WEB_DETAIL)
                .withString(ParameterConstant.Web.webUrl,mBanners[it].url)
                .navigation()
        }

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getArticles(mPage)
        },rv_home_list)

        mAdapter.setOnItemClickListener { _, _, position ->
            ARouter.getInstance()
                .build(RouterPath.Web.WEB_DETAIL)
                .withString(ParameterConstant.Web.webUrl,mArticles[position].link)
                .navigation()
        }

        // 滑动监听
        rv_home_list.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val scrolledYDistance = getScrolledYDistance(linearLayoutManager)
                val alpha = scrolledYDistance / (250*1.0f)
                changeStatusBarColor(alpha)

            }
        })

    }
    // LinearLayoutManager 获取滑动的高度
    fun getScrolledYDistance(layoutManager: LinearLayoutManager): Int {
        val position = layoutManager.findFirstVisibleItemPosition()
        val firstVisibleChildView = layoutManager.findViewByPosition(position)
        val itemHeight = firstVisibleChildView!!.height
        return position * itemHeight - firstVisibleChildView.top
    }

    private fun changeStatusBarColor(alpha:Float){
        if(alpha < 0.5f){
            layout_status_bar.setBackgroundColor(resources.getColor(R.color.color_30000000))
        }else{
            layout_status_bar.setBackgroundColor(resources.getColor(R.color.colorAccent))
            layout_status_bar.alpha = alpha
        }
    }

    override fun setTvTitleBackgroundColor() {
//        tv_title.setBackgroundColor(resources.getColor(R.color.colorAccent))
//        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorAccent))
    }

    override fun fragmentShowToUser() {
        mPresenter.getHotkey()
        mPresenter.getBanners()
        if (isShowToUser){
            mPresenter.getArticles(mPage)
            isShowToUser = false
        }

    }

    override fun fragmentHideToUser() {}

    override fun onStart() {
        super.onStart()
        banner.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        banner.stopAutoPlay()
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showHotkeys(hotkeys: MutableList<Hotkey>) {
        // 数据库保存 热搜词
        val hotkeyList = mutableListOf<String>()
        for (i in hotkeys){
            hotkeyList.add( "热搜 | "+i.name)
        }
        setData(hotkeyList)

    }

    /**
     * 设置热搜数据
     */
    private fun setData(data: MutableList<String>) {
        for (text in data) {
            val itemFlipper = LayoutInflater.from(activity).inflate(R.layout.item_flipper_view,null)
            itemFlipper.findViewById<TextView>(R.id.tv_flipper_text).text =text
            mFlipperView.addView(itemFlipper)
        }
        mFlipperView.startFlipping()
        mFlipperView.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Search.SEARCH_HOME).navigation()
        }
    }

    override fun showBanners(banners: MutableList<Banner>) {
        mBanners.clear()
        mBanners.addAll(banners)
        val imageUrls = mutableListOf<String>()
        val titles = mutableListOf<String>()
        for (i in banners){
            imageUrls.add(i.imagePath)
        }
        for (i in banners){
            titles.add(i.desc)
        }
        banner.setImages(imageUrls)
            .setBannerTitles(titles)
            .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
            .setBannerAnimation(Transformer.DepthPage)
            .setImageLoader(GlideImageLoader())
            .start()
    }
    override fun showLoadCompleteArticles(articles: MutableList<Article>) {
        mArticles.addAll(articles)
        mAdapter.loadMoreComplete()
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoadEndArticles(articles: MutableList<Article>) {
        mArticles.addAll(articles)
        mAdapter.loadMoreEnd()
        mAdapter.notifyDataSetChanged()
    }


    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
