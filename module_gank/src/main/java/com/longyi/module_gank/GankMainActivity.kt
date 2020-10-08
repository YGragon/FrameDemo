package com.longyi.module_gank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.GankPhoto
import com.example.lib_common.model.ImageData
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_gank_main.*

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
        rv_gank_photo.layoutManager = GridLayoutManager(this, 2)
        mAdapter = GankPhotoAdapter(mList)
        rv_gank_photo.adapter = mAdapter

        mAdapter.setOnItemClickListener { _, _, position ->
            ARouter.getInstance()
                .build(RouterPath.Gank.GANK_PHOTO_DETAIL)
                .withInt(ParameterConstant.GankPhoto.position, position % mCount)
                .withInt(ParameterConstant.GankPhoto.count, mCount)
                .withInt(ParameterConstant.GankPhoto.page, mPage)
                .withString(ParameterConstant.GankPhoto.imageUrl, mList[position].url)
                .navigation()
        }

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getGankPhoto(mCount, mPage)
        }, rv_gank_photo)
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
