package com.longyi.module_share

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication.Companion.context
import com.example.lib_common.constant.BaseConstant.filePath
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.constant.ShareContentType
import com.example.lib_common.service.ServiceFactory
import com.example.lib_common.utils.FileUtil
import com.example.lib_common.utils.LogUtils
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import kotlinx.android.synthetic.main.activity_share_home.*

@Route(path = RouterPath.Share.SHARE_APP,name = "分享主页")
class ShareHomeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_share_home
    }

    override fun initView() {
        share()
        tv_share_native.setOnClickListener {
            ShareUtil.Builder(this)
                .setContentType(ShareContentType.FILE)
                .setShareFileUri(FileUtil.getShareFileUri(context,filePath)?: Uri.parse(""))
                .setTitle("Share File")
                .build()
                .shareBySystem()
        }

        val umShareListener = object : UMShareListener {
            /**
             * @descrption 分享成功的回调
             * @param p0 平台类型
             */
            override fun onResult(p0: SHARE_MEDIA?) {
                Toast.makeText(this@ShareHomeActivity,"onResult                                          了",Toast.LENGTH_LONG).show()
            }
            /**
             * @descrption 分享取消的回调
             * @param p0 平台类型
             */
            override fun onCancel(p0: SHARE_MEDIA?) {
                Toast.makeText(this@ShareHomeActivity,"onCancel                                          了",Toast.LENGTH_LONG).show()
            }
            /**
             * @descrption 分享失败的回调
             * @param p0 平台类型
             * @param p1 错误原因
             */
            override fun onError(p0: SHARE_MEDIA?, p1: Throwable?) {
                Toast.makeText(this@ShareHomeActivity,"onError                                          了",Toast.LENGTH_LONG).show()
            }
            /**
             * @descrption 分享开始的回调
             * @param p0 平台类型
             */
            override fun onStart(p0: SHARE_MEDIA?) {
                Toast.makeText(this@ShareHomeActivity,"onStart                                          了",Toast.LENGTH_LONG).show()
            }

        }

        tv_share_sdk.setOnClickListener {
            LogUtils.e("222","分享")
            ShareAction(this)
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setShareboardclickCallback { snsPlatform, share_media ->
                    when (share_media) {
                        SHARE_MEDIA.QQ -> {
                            LogUtils.e("222","点击QQ")
                            ShareAction(this@ShareHomeActivity).setPlatform(SHARE_MEDIA.QQ)
                                .withText("hello")
                                .setCallback(umShareListener)
                                .share()
                        }
                        SHARE_MEDIA.WEIXIN -> {
                            LogUtils.e("222","点击微信")
                            ShareAction(this@ShareHomeActivity).setPlatform(SHARE_MEDIA.WEIXIN)
                                .withText("hello")
                                .setCallback(umShareListener)
                                .share()
                        }
                        SHARE_MEDIA.SINA -> {
                            LogUtils.e("222","点击新浪微博")
                            ShareAction(this@ShareHomeActivity).setPlatform(SHARE_MEDIA.QZONE)
                                .withText("hello")
                                .setCallback(umShareListener)
                                .share()
                        }
                    }
                }
                .open()
//            ShareBottomSheetDialogFragment().show(supportFragmentManager,"dialog")
        }
    }

    override fun initData() {}

    private fun share() {
        if(ServiceFactory.getInstance().getAccountService().isLogin()) {
            Toast.makeText(this@ShareHomeActivity,"分享成功                                          了",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@ShareHomeActivity,"分享失败：用户未登录                                          了",Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
    }

}
