package com.longyi.module_share

import android.app.Application
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.service.ServiceFactory
import com.example.lib_common.utils.LogUtils
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig


/**
 * 分享 app
 */
class ShareApplication : BaseApplication() {

    override fun initData(application: Application) {
        LogUtils.ee("222", "分享初始化==============开始===============")
        UMConfigure.init(this, "5d4d7a434ca357e78400031f", "umeng", UMConfigure.DEVICE_TYPE_PHONE,"")

        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0")
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com")
        PlatformConfig.setQQZone("1106315391", "H3UUrnh4NQosFUIp")
        ServiceFactory.getInstance().setAccountService(AccountService())
        LogUtils.ee("222", "分享初始化==============结束=================")
    }
}