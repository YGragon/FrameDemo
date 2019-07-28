package com.example.framedemo.ui.home



import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.launcher.ARouter
import com.example.framedemo.R
import com.example.framedemo.ui.home.contract.HomeContract
import com.example.framedemo.ui.home.presenter.HomePresenter
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Article
import com.example.lib_common.model.Banner
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.fragment_home.*
import com.example.lib_common.utils.imageloader.GlideImageLoader
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer


/**
 * 首页 fragment
 *
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    private var mArticles = mutableListOf<Article>()
    private var mBanners = mutableListOf<Banner>()
    private var mPage = 0
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
        return R.layout.fragment_home
    }

    override fun initData() {
        mPresenter.getBanners()
        mPresenter.getArticles(mPage)
    }


    override fun initView() {
        rv_home_list.layoutManager = LinearLayoutManager(activity)
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

    }

    override fun setTvTitleBackgroundColor() {
        tv_title.setBackgroundColor(resources.getColor(R.color.colorAccent))
        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorAccent))
    }

    override fun fragmentShowToUser() {
        LogUtils.ee("222","fragmentShowToUser")
    }

    override fun fragmentHideToUser() {
        LogUtils.ee("222","fragmentHideToUser")
    }

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
