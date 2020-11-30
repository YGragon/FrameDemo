package com.longyi.module_home

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.event.CollectEvent
import com.example.lib_common.http.UrlConstant
import com.example.lib_common.model.Article
import com.example.lib_common.model.Hotkey
import com.example.lib_common.model.ImageData
import com.example.lib_common.service.gank.IGankPhotoCallBack
import com.example.lib_common.service.gank.IGankService
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.utils.WXHelper
import com.example.lib_common.utils.imageloader.GlideImageLoader
import com.king.zxing.CaptureActivity
import com.king.zxing.Intents
import com.longyi.module_home.contract.HomeContract
import com.longyi.module_home.data.HomeDataSource
import com.longyi.module_home.data.MultipleItem
import com.longyi.module_home.presenter.HomePresenter
import com.longyi.module_home.ui.ScanPopup
import com.longyi.module_home.ui.ScanPopupCallBack
import com.permissionx.guolindev.PermissionX
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.menu_action_scan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import razerdp.basepopup.BasePopupWindow


/**
 * 首页 fragment
 *
 */
@Route(path = RouterPath.Home.HOME, name = "首页")
class HomeFragment : BaseFragment(), HomeContract.View {


    private var mPage = 0
    private var isShowToUser = true

    private lateinit var mAdapter: MultipleItemQuickAdapter
    private lateinit var banner: Banner
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
        // 放在子线程处理
        CoroutineScope(Dispatchers.IO).launch {
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
    }


    override fun initView() {
        EventBus.getDefault().register(this)

        val linearLayoutManager = LinearLayoutManager(requireActivity())
        rv_home_list.layoutManager = linearLayoutManager

        // 显示多布局
        mAdapter = MultipleItemQuickAdapter(list)
        // 显示单布局
        val headBanner = LayoutInflater.from(activity).inflate(R.layout.head_home_banner, null)
        banner = headBanner.findViewById(R.id.banner)
        mAdapter.addHeaderView(headBanner)
        // 优化notifyDataChange 闪烁问题
        mAdapter.setHasStableIds(true)
        rv_home_list.adapter = mAdapter
        mAdapter.setPresenter(mPresenter)

        initListener(linearLayoutManager)
    }

    private fun initListener(linearLayoutManager: LinearLayoutManager) {
        banner.setOnBannerListener {
            mPresenter.toWebDetail(-1,mPresenter.getBannerUrl(it),-1,false)
        }

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getArticles(mPage)
        }, rv_home_list)

        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            val article = list[position].article
            when (view.id) {
                R.id.tv_super_chapter_name -> {
                    if (list[position].article.tags.isNotEmpty()) {
                        val url = UrlConstant.BASE_URL + article.tags[0].url
                        mPresenter.toWebDetail(position,url, article.id, article.collect)
                    }
                }
                R.id.layout_card -> mPresenter.toWebDetail(
                    position,
                    article.link,
                    article.id,
                    article.collect
                )
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
        // 下拉刷新
        smart_refresh_layout.setOnRefreshListener {
            mPage = 0
            list.clear()
            mPresenter.getArticles(mPage)
        }

        // 扫码
        layout_scan.setOnClickListener {
            checkCameraPermission()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onGetMessage(message: CollectEvent) {
        val position = message.position
        val collect = message.collect

        list[position].article.collect = collect
        mAdapter.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = data?.getStringExtra(Intents.Scan.RESULT)
        // TODO 可以获取到，但是不优雅，可以考虑把库源码获取到，通过 callback 返回
        if (result != null && result.isNotEmpty() && (result.startsWith("http") || result.startsWith(
                "https"
            ))
        ) {
            mPresenter.toWebDetail(-1,result, -1, false)
        }
    }

    private fun checkCameraPermission() {

        PermissionX.init(this)
            .permissions(Manifest.permission.CAMERA)
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    // 拥有权限
                    showScanSelectPopup()
                } else {
                    Toast.makeText(
                        requireActivity(),
                        "These permissions are denied: $deniedList",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    private fun showScanSelectPopup() {
        ScanPopup(requireActivity(), object : ScanPopupCallBack {
            override fun clickCustom() {
                requireActivity().startActivityForResult(
                    Intent(
                        requireActivity(),
                        CaptureActivity::class.java
                    ), 100
                )
            }

            override fun clickWeChat() {
                WXHelper.openScanner(requireActivity())
            }
        }).setPopupGravity(
            BasePopupWindow.GravityMode.RELATIVE_TO_ANCHOR,
            Gravity.BOTTOM
        ).showPopupWindow(layout_right_menu)
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
            fake_status_bar.setBackgroundColor(resources.getColor(R.color.color_30000000))
        } else {
            layout_status_bar.setBackgroundColor(resources.getColor(R.color.colorAccent))
            fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorAccent))
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
        smart_refresh_layout.finishRefresh()
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

    override fun showLoadCompleteArticles(listArticle: MutableList<Article>) {
        smart_refresh_layout.finishRefresh()
        mAdapter.loadMoreComplete()
        addData(listArticle)
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoadEndArticles(listArticle: MutableList<Article>) {
        smart_refresh_layout.finishRefresh()
        mAdapter.loadMoreEnd()
        addData(listArticle)
        mAdapter.notifyDataSetChanged()
    }

    private fun addData(listArticle: MutableList<Article>) {
        for (i in listArticle.indices) {
            if (i % 10 == 0) {
                val imageList = HomeDataSource.getImageDatas()
                if (imageList.isNotEmpty()) {
                    val randomIndex = (1 + Math.random() * (imageList.size - 1)).toInt()
                    val imageData = imageList[randomIndex]
                    list.add(MultipleItem(MultipleItem.IMG, listArticle[i], imageData))
                } else {
                    val imageData = ImageData(
                        "", "", "", "", "",
                        mutableListOf(), 1, "", 1, "", "", "", 1
                    )
                    list.add(MultipleItem(MultipleItem.TEXT, listArticle[i], imageData))
                }

            } else {
                val imageData = ImageData(
                    "", "", "", "", "",
                    mutableListOf(), 1, "", 1, "", "", "", 1
                )
                list.add(MultipleItem(MultipleItem.TEXT, listArticle[i], imageData))
            }
        }
    }

    override fun showBindLikeSuccess(msg: String) {
        ToastUtils.show(requireActivity(), msg)
    }

    override fun showBindLikeFail(msg: String) {
        ToastUtils.show(requireActivity(), msg)
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }
}
