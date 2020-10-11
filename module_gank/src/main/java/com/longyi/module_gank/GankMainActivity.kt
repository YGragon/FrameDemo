package com.longyi.module_gank

import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.ImageData
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.utils.rxbus.bus.RxBus
import com.longyi.module_gank.event.ImageEvent
import kotlinx.android.synthetic.main.activity_gank_main.*
import org.greenrobot.eventbus.EventBus

@Route(path = RouterPath.Gank.GANK_PHOTO, name = "干货福利")
class GankMainActivity : BaseActivity(), GankPhotoContract.View {

    private lateinit var mAdapter: GankPhotoAdapter
    private val mList = mutableListOf<ImageData>()
    private var mCount = 10
    private var mPage = 1

    private val mPresenter by lazy { GankPhotoPresenter() }

    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_gank_main
    }

    override fun initView() {

        initToolbar()

        rv_gank_photo.layoutManager = GridLayoutManager(this, 2)
        mAdapter = GankPhotoAdapter(mList)
        rv_gank_photo.adapter = mAdapter

        mAdapter.setOnItemClickListener { _, _, position ->
            // 传递数据
            RxBus.postSticky("imagesInfo",ImageEvent(position,mPage,mCount,mList))
            ARouter.getInstance()
                .build(RouterPath.Gank.GANK_PHOTO_DETAIL)
                .navigation()
        }

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getGankPhoto(mCount, mPage)
        }, rv_gank_photo)
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "GankIO 图片"
        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }

    override fun initData() {
        mPresenter.getGankPhoto(mCount, mPage)
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context, errorMsg)
    }

    override fun showGankPhotoResult(list: MutableList<ImageData>) {
        if (list.isEmpty()) {
            mAdapter.loadMoreEnd()
        } else {
            mList.addAll(list)
            mAdapter.loadMoreComplete()
        }
        mAdapter.notifyDataSetChanged()
    }

    override fun showGankEmptyResult() {
        val emptyLayout = LayoutInflater.from(this).inflate(R.layout.layout_empty, null)
        mAdapter.emptyView = emptyLayout
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {}

    override fun hideLoading() {}


    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }

}
