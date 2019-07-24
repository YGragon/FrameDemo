package com.longyi.module_share

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication.Companion.context
import com.example.lib_common.constant.BaseConstant.filePath
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.constant.ShareContentType
import com.example.lib_common.utils.FileUtil
import kotlinx.android.synthetic.main.activity_share_home.*

@Route(path = RouterPath.Share.SHARE_APP,name = "分享主页")
class ShareHomeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_share_home
    }

    override fun initView() {
        tv_share_native.setOnClickListener {
            ShareUtil.Builder(this)
                .setContentType(ShareContentType.FILE)
                .setShareFileUri(FileUtil.getShareFileUri(context,filePath)!!)
                .setTitle("Share File")
                .build()
                .shareBySystem()
        }

        tv_share_sdk.setOnClickListener {

        }
    }

    override fun initData() {
    }


}
