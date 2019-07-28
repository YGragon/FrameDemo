package com.example.framedemo.ui.course


import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

import com.example.framedemo.R
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import com.longyi.lib_download.app_upgrade.UpdateFragment
import com.longyi.lib_download.file_download.DownloadHelper
import com.longyi.lib_download.file_download.DownloadListener
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import com.tencent.bugly.crashreport.CrashReport
import kotlinx.android.synthetic.main.fragment_course.*
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
//            DownloadHelper("http://www.wanandroid.com/", object : DownloadListener {
//                override fun onStartDownload() {
//                    LogUtils.ee("222", "开始下载")
//                }
//
//                override fun onProgress(progress: Int) {
//                    LogUtils.ee("222", "下载进度：" + progress)
//                }
//
//                override fun onFinishDownload(file: File) {
//                    LogUtils.ee("222", "下载结束：" + file.name)
//                    LogUtils.ee("222", "下载结束：" + file.absolutePath)
//                }
//
//                override fun onFail(ex: Throwable) {
//                    LogUtils.ee("222", "下载失败：" + ex.message)
//                }
//            }).downloadFile(
//                "http://wanandroid.com/blogimgs/fb2c1185-55a0-4598-b5b2-11d1381fa596.png",
//                BaseConstant.filePath, "测试_2019_7_24.png"
//            )
        }

        tv_share.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Share.SHARE_APP).navigation()
        }

        tv_map.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Map.MAP_APP).navigation()
        }
    }
    override fun setTvTitleBackgroundColor() {
        tv_title.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }

}
