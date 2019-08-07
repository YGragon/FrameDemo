package com.longyi.module_gank.big_image

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.model.GankPhoto
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_big_image.*
import androidx.recyclerview.widget.PagerSnapHelper
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.constant.RouterPath
import com.longyi.module_gank.R

@Route(path = RouterPath.Gank.GANK_PHOTO_DETAIL,name = "上下翻页的图片详情")
class BigImageActivity : BaseActivity(), BigImageContract.View {

    private lateinit var mBigImageAdapter: BigImageAdapter
    private var mPhotoList = mutableListOf<GankPhoto>()

    private var mCount = 10
    private var mPage = 0
    private var mPosition = 0
    private var isInit = false

    private val mPresenter by lazy { BigImagePresenter() }

    init {
        mPresenter.attachView(this)
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_big_image
    }

    override fun initView() {

        mCount = intent.getIntExtra(ParameterConstant.GankPhoto.count,0)
        mPage = intent.getIntExtra(ParameterConstant.GankPhoto.page,0)
        mPosition = intent.getIntExtra(ParameterConstant.GankPhoto.position,0)

        rv_gank_photo_detail.layoutManager = LinearLayoutManager(this)
        mBigImageAdapter = BigImageAdapter(mPhotoList)
        rv_gank_photo_detail.adapter = mBigImageAdapter
        // 垂直翻页
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv_gank_photo_detail)

        mBigImageAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getGankPhoto(mCount,mPage)
        },rv_gank_photo_detail)
    }

    override fun initData() {
        mPresenter.getGankPhoto(mCount,mPage)
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context, errorMsg)
    }

    override fun showGankPhotoResult(list: MutableList<GankPhoto>) {
        if (list.isEmpty()) {
            mBigImageAdapter.loadMoreEnd()
        } else {
            mPhotoList.addAll(list)
            mBigImageAdapter.loadMoreComplete()
        }
        if (isInit){
            isInit = false
            rv_gank_photo_detail.scrollToPosition(mPosition)
        }

        mBigImageAdapter.notifyDataSetChanged()

    }

    override fun showGankEmptyResult() {  val emptyLayout = LayoutInflater.from(this).inflate(R.layout.layout_empty, null)
        mBigImageAdapter.emptyView = emptyLayout
        mBigImageAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onResume() {
        super.onResume()
        isInit = true
    }

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }

}
