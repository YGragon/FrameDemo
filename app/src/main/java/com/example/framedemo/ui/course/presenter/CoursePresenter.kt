package com.example.framedemo.ui.mine.presenter

import android.app.ProgressDialog
import com.example.framedemo.ui.mine.contract.CourseContract
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.longyi.lib_download.file_upload.ProgressRequestBody
import com.longyi.lib_download.file_upload.UploadCallbacks
import okhttp3.MultipartBody
import java.io.File

/**
 * Mine Presenter 处理
 */
class CoursePresenter : BasePresenter<CourseContract.View>(), CourseContract.Presenter {


    override fun getUserInfo() {


    }

    override fun loginOut() {
        val disposable = RetrofitManager.service.logout()
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                if (res.errorCode == 0) {
                    mRootView?.showLoginOutSuccess()
                }else{
                    mRootView?.showError(res.errorMsg)
                }
            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)

    }

    /**
     * 上传文件
     */
    override fun uploadFile(path: String) {
        val dialog = ProgressDialog(BaseApplication.context)
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
        addSubscription(disposable)
    }
}