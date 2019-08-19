package com.longyi.module_share

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import cn.sharesdk.onekeyshare.OnekeyShare
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication.Companion.context
import com.example.lib_common.constant.BaseConstant.filePath
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.constant.ShareContentType
import com.example.lib_common.service.ServiceFactory
import com.example.lib_common.utils.FileUtil
import com.example.lib_common.utils.LogUtils
import kotlinx.android.synthetic.main.activity_share_home.*

@Route(path = RouterPath.Share.SHARE_APP,name = "分享主页")
class ShareHomeActivity : BaseActivity() {


    private val sTAG:String = ShareHomeActivity::class.java.simpleName

    override fun getLayoutId(): Int {
        return R.layout.activity_share_home
    }

    override fun initView() {
        share()
        tv_share_native.setOnClickListener {
            ShareUtil.Builder(this)
                .setContentType(ShareContentType.FILE)
                .setShareFileUri(FileUtil.getShareFileUri(context,filePath)?: Uri.parse(""))
                .setTitle(getString(R.string.share))
                .build()
                .shareBySystem()
        }



        tv_share_sdk.setOnClickListener {
            LogUtils.e(sTAG,"分享")
            showShare()
//            ShareBottomSheetDialogFragment().show(supportFragmentManager,"dialog")
        }
    }
    private fun showShare() {
        val oks = OnekeyShare()
        //关闭sso授权
        oks.disableSSOWhenAuthorize()

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(getString(R.string.share))
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn")
        // text是分享文本，所有平台都需要这个字段
        oks.text = "我是分享文本"
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg")//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn")
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本")
        // 启动分享GUI
        oks.show(this)
    }
    override fun initData() {}

    private fun share() {
        if(ServiceFactory.getInstance().getAccountService().isLogin()) {
            Toast.makeText(this@ShareHomeActivity,"分享成功了",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@ShareHomeActivity,"分享失败：用户未登录了",Toast.LENGTH_LONG).show()
        }
    }


}
