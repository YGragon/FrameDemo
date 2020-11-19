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
import com.example.lib_common.model.ImageData
import com.example.lib_common.service.gank.IGankPhotoCallBack
import com.example.lib_common.service.gank.IGankService
import com.example.lib_common.utils.GlideUtils
import com.example.lib_common.utils.PreferenceUtils
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.utils.imageloader.GlideImageLoader
import com.longyi.module_home.data.HomeDataSource
import com.longyi.module_home.data.MultipleItem
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.home_fragment.*
import javax.sql.DataSource

/**
 * 首页 fragment
 *
 */
@Route(path = RouterPath.Home.HOME, name = "首页")
class HomeFragment : BaseFragment(), HomeContract.View {


    private var mPage = 0
    private var isShowToUser = true

    //    private lateinit var mAdapter: HomeAdapter
    private lateinit var mAdapter: MultipleItemQuickAdapter
    private lateinit var banner: com.youth.banner.Banner
    private val list = mutableListOf<MultipleItem>()

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { HomePresenter(this) }

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
        val gankService =
            ARouter.getInstance().build("/gank/IGankService").navigation() as IGankService
        gankService.getHeaderPhoto(object : IGankPhotoCallBack {

            override fun successByList(images: MutableList<ImageData>) {
                HomeDataSource.setImageDatas(images)
            }

            override fun fail(msg: String) {
                ToastUtils.show(BaseApplication.context, msg)
            }
        })
    }


    override fun initView() {
        val linearLayoutManager = LinearLayoutManager(requireActivity())
        rv_home_list.layoutManager = linearLayoutManager

        // 显示多布局
        mAdapter = MultipleItemQuickAdapter(list)
        // 显示单布局
//        mAdapter = HomeAdapter(mArticles)
        val headBanner = LayoutInflater.from(activity).inflate(R.layout.head_home_banner, null)
        banner = headBanner.findViewById(R.id.banner)
        mAdapter.addHeaderView(headBanner)
        rv_home_list.adapter = mAdapter
        mAdapter.setPresenter(mPresenter)

        initListener(linearLayoutManager)
    }

    private fun initListener(linearLayoutManager: LinearLayoutManager) {
        banner.setOnBannerListener { mPresenter.toWebDetail(mPresenter.getBannerUrl(it)) }

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getArticles(mPage)
        }, rv_home_list)

        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.tv_super_chapter_name -> {
                    val articleChapterUrl = mPresenter.getArticleChapterUrl(position)
                    if (articleChapterUrl.isNotEmpty()) {
                        mPresenter.toWebDetail(articleChapterUrl)
                    }
                }
                R.id.layout_card -> mPresenter.toWebDetail(mPresenter.getArticleUrl(position))
//                R.id.iv_like -> mPresenter.bindLike(HomeDataSource.mArticles[position])
            }
        }

        // 滑动监听
        rv_home_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val scrolledYDistance = getScrolledYDistance(linearLayoutManager)
                val alpha = scrolledYDistance / (250 * 1.0f)
                changeStatusBarColor(alpha)

            }
        })
    }

    // LinearLayoutManager 获取滑动的高度
    private fun getScrolledYDistance(layoutManager: LinearLayoutManager): Int {
        val position = layoutManager.findFirstVisibleItemPosition()
        val firstVisibleChildView = layoutManager.findViewByPosition(position)
        val itemHeight = firstVisibleChildView!!.height
        return position * itemHeight - firstVisibleChildView.top
    }

    private fun changeStatusBarColor(alpha: Float) {
        if (alpha < 0.5f) {
            layout_status_bar.setBackgroundColor(resources.getColor(R.color.color_30000000))
        } else {
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
        if (isShowToUser) {
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
        ToastUtils.show(BaseApplication.context, errorMsg)
    }

    override fun showHotkeys(hotkeys: MutableList<Hotkey>) {
        // 数据库保存 热搜词
        val hotkeyList = mutableListOf<String>()
        for (i in hotkeys) {
            hotkeyList.add("热搜 | " + i.name)
        }
        setData(hotkeyList)

    }

    /**
     * 设置热搜数据
     */
    private fun setData(data: MutableList<String>) {
        for (text in data) {
            val itemFlipper =
                LayoutInflater.from(activity).inflate(R.layout.item_flipper_view, null)
            itemFlipper.findViewById<TextView>(R.id.tv_flipper_text).text = text
            mFlipperView.addView(itemFlipper)
        }
        mFlipperView.startFlipping()
        mFlipperView.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Search.SEARCH_HOME).navigation()
        }
    }

    override fun showBanners(images: MutableList<String>, titles: MutableList<String>) {

        banner.setImages(images)
            .setBannerTitles(titles)
            .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
            .setBannerAnimation(Transformer.DepthPage)
            .setImageLoader(GlideImageLoader())
            .start()
    }

    override fun showLoadCompleteArticles() {
        mAdapter.loadMoreComplete()
        addData()
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoadEndArticles() {
        mAdapter.loadMoreEnd()
        addData()
        mAdapter.notifyDataSetChanged()
    }

    private fun addData(){
        val artList = HomeDataSource.mArticles
        for (i in artList.indices) {
            if (i % 10 == 0) {
                val imageList = HomeDataSource.getImageDatas()
                if (imageList.isNotEmpty()){
                    val randomIndex = (1+Math.random()*(imageList.size-1)).toInt()
                    val imageData = imageList[randomIndex]
                    list.add(MultipleItem(MultipleItem.IMG, artList[i],imageData))
                }else{
                    val imageData = ImageData("","","","","",
                        mutableListOf(),1,"",1,"","","",1)
                    list.add(MultipleItem(MultipleItem.TEXT, artList[i],imageData))
                }

            } else {
                val imageData = ImageData("","","","","",
                    mutableListOf(),1,"",1,"","","",1)
                list.add(MultipleItem(MultipleItem.TEXT, artList[i],imageData))
            }
        }
    }

    override fun showBindLikeSuccess(msg: String, isLike: Boolean, article: Article) {
        ToastUtils.show(requireActivity(), msg)
        article.collect = isLike
        mAdapter.notifyDataSetChanged()
    }

    override fun showBindLikeFail(msg: String, article: Article) {
        ToastUtils.show(requireActivity(), msg)
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
