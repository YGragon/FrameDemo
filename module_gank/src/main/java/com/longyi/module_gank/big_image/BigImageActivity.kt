package com.longyi.module_gank.big_image

import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
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
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.numberprogressbar.OnProgressBarListener
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.constant.ShareContentType
import com.example.lib_common.http.UrlConstant
import com.example.lib_common.model.ImageData
import com.example.lib_common.utils.FileUtil
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.rxbus.bus.RxBus
import com.example.lib_common.utils.rxbus.bus.RxBusReceiver
import com.longyi.lib_download.file_download.DownloadHelper
import com.longyi.lib_download.file_download.DownloadListener
import com.longyi.module_gank.R
import com.longyi.module_gank.event.ImageEvent
import com.example.lib_common.utils.ShareUtil
import java.io.File


@Route(path = RouterPath.Gank.GANK_PHOTO_DETAIL,name = "上下翻页的图片详情")
class BigImageActivity : BaseActivity(), BigImageContract.View, OnProgressBarListener {


    private lateinit var mBigImageAdapter: BigImageAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private var mPhotoList = mutableListOf<ImageData>()

    private var currentIndex = 0

    private var mCount = 10
    private var mPage = 0
    private var mPosition = 0

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
        val snapHelper = object :PagerSnapHelper(){
            override fun findTargetSnapPosition(
                layoutManager: RecyclerView.LayoutManager?,
                velocityX: Int,
                velocityY: Int
            ): Int {
                val targetPos = super.findTargetSnapPosition(layoutManager, velocityX, velocityY)
                currentIndex = targetPos
                Toast.makeText(this@BigImageActivity, "滑到到 " + targetPos + "位置", Toast.LENGTH_SHORT).show()
                return targetPos
            }
        }
        snapHelper.attachToRecyclerView(rv_gank_photo_detail)

        mBigImageAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getGankPhoto(mCount,mPage)
        },rv_gank_photo_detail)

        RxBus.receiveSticky(this,"imagesInfo",object :RxBusReceiver<Any>(){
            override fun receive(data: Any) {
                val imageInfo = data as ImageEvent
                mCount = imageInfo.count
                mPage = imageInfo.page
                mPosition = imageInfo.position
                mPhotoList.clear()
                mPhotoList.addAll(imageInfo.list)

                rv_gank_photo_detail.scrollToPosition(mPosition)
                mLinearLayoutManager.scrollToPositionWithOffset(mPosition,0)

                mBigImageAdapter.notifyDataSetChanged()

            }

        })

    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(com.longyi.module_gank.R.id.toolbar)
        toolbar.title = "图片预览"
        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }

    override fun initData() {
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(com.longyi.module_gank.R.menu.menu_toolbar, menu)
        return true
    }

    /**
     * 显示menu的icon,通过反射,设置Menu的icon显示.
     * @param view
     * @param menu
     * @return
     */
    @SuppressLint("RestrictedApi")
    override fun onPrepareOptionsPanel(view: View?, menu: Menu): Boolean {
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
            com.longyi.module_gank.R.id.toolbar_collect ->{
                ToastUtils.show(this,"收藏")
                return true
            }
            com.longyi.module_gank.R.id.toolbar_download ->{
                startDownLoad()
                return true
            }
            com.longyi.module_gank.R.id.toolbar_share ->{
                startShare()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
    private fun startShare(){
        val imageData = mPhotoList[currentIndex]

        Log.e("222","image:${imageData}")
        ShareUtil.Builder(this)
            .setContentType(ShareContentType.TEXT)
            .setTextContent(imageData.toString())
//            .setShareFileUri(Uri.parse(imageData.url))
            .setTitle("分享至")
            .build()
            .shareBySystem()
    }

    private fun startDownLoad() {

        mBigImageAdapter.getItem(mLinearLayoutManager.findFirstCompletelyVisibleItemPosition())?.url?.let {
            DownloadHelper(UrlConstant.GANK_URL, object : DownloadListener {
                override fun onStartDownload() {
                    showNumberProgressBar()
                    LogUtils.d( "开始下载")
                }

                override fun onProgress(progress: Int) {
                    number_progress_bar.progress = progress
                    LogUtils.d("下载进度：$progress")
                }

                override fun onFinishDownload(file: File) {
                    hideNumberProgressBar()
                    LogUtils.d("下载结束：" + file.name)
                    LogUtils.d("下载结束：" + file.absolutePath)
                }

                override fun onFail(ex: Throwable) {
                    LogUtils.d("下载失败：" + ex.message)
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
        fake_status_bar.setBackgroundColor(resources.getColor(com.longyi.module_gank.R.color.colorAccent))
        StatusBarUtil.setTranslucentForImageView(this,null)
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context, errorMsg)
    }

    override fun showGankPhotoResult(list: MutableList<ImageData>) {
        if (list.isEmpty()) {
            mBigImageAdapter.loadMoreEnd()
        } else {
            mPhotoList.addAll(list)
            mBigImageAdapter.loadMoreComplete()
        }
        rv_gank_photo_detail.scrollToPosition(mPosition)

        mBigImageAdapter.notifyDataSetChanged()

    }

    override fun showGankEmptyResult() {  val emptyLayout = LayoutInflater.from(this).inflate(com.longyi.module_gank.R.layout.layout_empty, null)
        mBigImageAdapter.emptyView = emptyLayout
        mBigImageAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }

}
