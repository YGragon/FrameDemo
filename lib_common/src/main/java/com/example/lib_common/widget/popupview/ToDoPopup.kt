package com.example.lib_common.widget.popupview

import android.view.View
import razerdp.basepopup.BasePopupWindow
import android.content.Context
import com.example.lib_common.R


/**
 * TODO页面的弹窗
 */
class ToDoPopup(context:Context): BasePopupWindow(context) {

    // 必须实现，这里返回您的contentView
    // 为了让库更加准确的做出适配，强烈建议使用createPopupById()进行inflate
    override fun onCreateContentView(): View {
        return createPopupById(R.layout.popup_todo)
    }

}