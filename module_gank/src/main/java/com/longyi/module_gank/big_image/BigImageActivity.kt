package com.longyi.module_gank.big_image

import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
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
import com.jaeger.library.StatusBarUtil
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import com.daimajia.numberprogressbar.OnProgressBarListener
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.http.UrlConstant
import com.example.lib_common.utils.LogUtils
import com.longyi.lib_download.file_download.DownloadHelper
import com.longyi.lib_download.file_download.DownloadListener
import com.longyi.module_gank.R
import java.io.File
import java.util.*




@Route(path = RouterPath.Gank.GANK_PHOTO_DETAIL,name = "上下翻页的图片详情")
class BigImageActivity : BaseActivity(), BigImageContract.View, OnProgressBarListener {


    private lateinit var mBigImageAdapter: BigImageAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var timer: Timer
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
        return com.longyi.module_gank.R.layout.activity_big_image
    }

    override fun initView() {

        initToolbar()

        mLinearLayoutManager = LinearLayoutManager(this)
        rv_gank_photo_detail.layoutManager = mLinearLayoutManager
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

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "图片详情"
        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }

    override fun initData() {
        mCount = intent.getIntExtra(ParameterConstant.GankPhoto.count,0)
        mPage = intent.getIntExtra(ParameterConstant.GankPhoto.page,0)
        mPosition = intent.getIntExtra(ParameterConstant.GankPhoto.position,0)

        mPresenter.getGankPhoto(mCount,mPage)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    /**
     * 显示menu的icon,通过反射,设置Menu的icon显示.
     * @param view
     * @param menu
     * @return
     */
    @SuppressLint("RestrictedApi")
    override fun onPrepareOptionsPanel(view: View?, menu: Menu?): Boolean {
        if (menu != null) {
            if (menu.javaClass.simpleName == "MenuBuilder") {
                try {
                    val m = menu.javaClass.getDeclaredMethod("setOptionalIconsVisible", java.lang.Boolean.TYPE)
                    m.isAccessible = true
                    m.invoke(menu, true)
                } catch (e: Exception) {
                    Log.e(javaClass.simpleName, "onMenuOpened...unable to set icons for overflow menu", e)
                }

            }
        }
        return super.onPrepareOptionsPanel(view, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toolbar_collect ->{
                ToastUtils.show(this,"收藏")
                return true
            }
            R.id.toolbar_download ->{
                startDownLoad()
                return true
            }
            R.id.toolbar_share ->{
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun startDownLoad() {

        mBigImageAdapter.getItem(mLinearLayoutManager.findFirstCompletelyVisibleItemPosition())?.url?.let {
            DownloadHelper(UrlConstant.GANK_URL, object : DownloadListener {
                override fun onStartDownload() {
                    showNumberProgressBar()
                    LogUtils.ee("222", "开始下载")
                }

                override fun onProgress(progress: Int) {
                    number_progress_bar.progress = progress
                    LogUtils.ee("222", "下载进度：" + progress)
                }

                override fun onFinishDownload(file: File) {
                    hideNumberProgressBar()
                    LogUtils.ee("222", "下载结束：" + file.name)
                    LogUtils.ee("222", "下载结束：" + file.absolutePath)
                }

                override fun onFail(ex: Throwable) {
                    LogUtils.ee("222", "下载失败：" + ex.message)
                }
            }).downloadFile(
                it,
                BaseConstant.filePath, "${ mBigImageAdapter.getItem(mLinearLayoutManager.findFirstCompletelyVisibleItemPosition())?.desc}.png"
            )
        }
    }

    override fun onProgressChange(current: Int, max: Int) {
        if(current == max) {
            hideNumberProgressBar()
        }

    }

    private fun showNumberProgressBar() {
        ToastUtils.show(this, "开始下载")
        number_progress_bar.visibility = View.VISIBLE
    }

    private fun hideNumberProgressBar() {
        ToastUtils.show(this, "下载完成")
        number_progress_bar.visibility = View.GONE
    }


    override fun setStatusBar() {
        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorAccent))
        StatusBarUtil.setTranslucentForImageView(this,null)
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
