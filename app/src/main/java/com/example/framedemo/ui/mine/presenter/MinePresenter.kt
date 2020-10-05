package com.example.framedemo.ui.mine.presenter

import android.app.ProgressDialog
import com.example.framedemo.ui.mine.contract.MineContract
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.utils.LogUtils
import com.longyi.lib_download.file_upload.ProgressRequestBody
import com.longyi.lib_download.file_upload.UploadCallbacks
import okhttp3.MultipartBody
import java.io.File

/**
 * Mine Presenter 处理
 */
class MinePresenter : BasePresenter<MineContract.View>(), MineContract.Presenter {


    override fun getUserInfo() {


    }

    override fun loginOut() {
        runRxLambda(RetrofitManager.service.logout(),{
            if (it.errorCode == 0) {
                mRootView?.showLoginOutSuccess()
            }else{
                mRootView?.showError(it.errorMsg)
            }
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
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

        runRxLambda(RetrofitManager.service.upload(body),{
            LogUtils.d("上传成功")
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }
}