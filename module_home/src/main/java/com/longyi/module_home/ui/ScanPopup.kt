package com.longyi.module_home.ui


import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.lib_common.utils.WXHelper
import com.king.zxing.CaptureActivity
import com.longyi.module_home.R
import razerdp.basepopup.BasePopupWindow


/**
 * 首页扫一扫 popup
 */
class ScanPopup(activity: FragmentActivity,callBack:ScanPopupCallBack):BasePopupWindow(activity) {
    init {
        val toWeChatScan = findViewById<TextView>(R.id.tv_wechat_scan)
        val toCustomScan = findViewById<TextView>(R.id.tv_custom_scan)

        toWeChatScan.setOnClickListener {
            callBack.clickWeChat()
            dismiss()
        }
        toCustomScan.setOnClickListener {
            //跳转的默认扫码界面
            callBack.clickCustom()
            dismiss()
        }
    }

    override fun onCreateContentView(): View {
        return createPopupById(R.layout.popup_scan_menu)
    }
}

interface ScanPopupCallBack{
    fun clickCustom()
    fun clickWeChat()
}