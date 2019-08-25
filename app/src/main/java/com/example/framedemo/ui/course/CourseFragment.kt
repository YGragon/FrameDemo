package com.example.framedemo.ui.course


import android.app.ProgressDialog
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

import com.example.framedemo.R
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.db.dao.HotKeyDao
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import com.longyi.lib_download.app_upgrade.UpdateFragment
import com.longyi.lib_download.file_download.DownloadHelper
import com.longyi.lib_download.file_download.DownloadListener
import com.longyi.lib_download.file_upload.ProgressRequestBody
import com.longyi.lib_download.file_upload.UploadCallbacks
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import com.tencent.bugly.crashreport.CrashReport
import kotlinx.android.synthetic.main.fragment_course.*
import okhttp3.MultipartBody
import java.io.File

/**
 * 各个库使用例子
 *
 */
class CourseFragment : BaseFragment() {

    companion object {
        fun newInstance() = CourseFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_course
    }

    override fun initData() {
    }

    override fun initView() {
        tv_download_apk.setOnClickListener {
            Beta.checkUpgrade()
        }

        tv_download_file.setOnClickListener {
//            下载文件使用
            ToastUtils.show(BaseApplication.context,"下载文件使用")
//            val file = File(filePath)
//            //实现上传进度监听
//            val requestFile = ProgressRequestBody(file, "*/*", object : UploadCallbacks {
//                override fun onProgressUpdate(percentage: In) {
//                }
//
//                override fun onError() {}
//
//                override fun onFinish() {}
//            })
//
//            val body = MultipartBody.Part.createFormData("file", file.name, requestFile)
//            runRxLambda(RetrofitManager.create(OperationApi::class.java).upload(body,0),{
//
//            },{

//            },{
//            })
        }
        tv_upload_file.setOnClickListener {
            ToastUtils.show(BaseApplication.context,"上传文件使用")
//            uploadFile(
//              文件绝对路径
//            )
        }

        tv_share.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Share.SHARE_APP).navigation()
        }

        tv_map.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Map.MAP_APP).navigation()
        }

        tv_gank_photo.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Gank.GANK_PHOTO).navigation()
        }
    }
    override fun setTvTitleBackgroundColor() {
        tv_title.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    override fun fragmentShowToUser() {}

    override fun fragmentHideToUser() {}

    /**
     * 上传文件
     */
    private fun uploadFile(path: String) {
        val dialog = ProgressDialog(activity)
        //设置进度条风格，风格为圆形，旋转的
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        //设置ProgressDialog 标题
        dialog.setTitle("文件上传")
        //设置ProgressDialog 提示信息
        dialog.setMessage("文件上传中...")
        //设置ProgressDialog 标题图标
        dialog.setIcon(android.R.drawable.ic_dialog_alert)
        //设置ProgressDialog的最大进度
        dialog.max = 100
        //设置ProgressDialog 是否可以按退回按键取消
        dialog.setCancelable(false)
        dialog.show()
        dialog.progress = 0
        val file = File(path)
        //实现上传进度监听
        val requestFile = ProgressRequestBody(file, "file", object : UploadCallbacks {
            override fun onProgressUpdate(percentage: Int) {
                dialog.progress = percentage
            }

            override fun onError() {
                dialog.dismiss()
            }

            override fun onFinish() {
                dialog.dismiss()
            }
        })

        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

        val disposable = RetrofitManager.service.upload(body)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                // 上传成功

            }, { throwable ->
                // 上传失败
            })
//        addSubscription(disposable)
    }

}
