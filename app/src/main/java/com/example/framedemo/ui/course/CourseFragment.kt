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

}
