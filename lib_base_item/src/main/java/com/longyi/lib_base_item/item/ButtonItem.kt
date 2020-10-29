package com.longyi.lib_base_item.item

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.view.ViewGroup
import android.widget.Switch
import com.longyi.lib_base_item.R
import com.longyi.lib_base_item.utils.dip2px
import com.longyi.lib_base_item.SwitchImageView


/**
 * Created by Aller on 2020/10/28.
 */
class ButtonItem:AbstractItem {

    private lateinit var switchImageView: SwitchImageView

    private lateinit var switchCblp: RelativeLayout.LayoutParams

    constructor(context: Context):super(context){}
    constructor(context: Context, attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){}

    override fun createWidget() {

        switchImageView = SwitchImageView(context)
    }

    override fun createWidgetLayoutParams() {
        switchCblp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        switchCblp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        switchCblp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
    }


    override fun addWidget() {
        super.addWidget()
        addView(switchImageView,switchCblp);
        setSwitchImageViewStyle();

    }


    fun setSwitchImageViewStyle() {


        if (configAttrs == null) {
            throw RuntimeException("config attrs is not set")
        }
        if (configAttrs.getTrunResId() <= 0 || configAttrs.getUpResId() <= 0) {
            throw RuntimeException("button res is not set")
        }

        switchCblp.rightMargin = configAttrs.getMarginRight().dip2px().toInt()

        switchImageView.setImageResource(configAttrs.getTrunResId())


    }


    fun getSwitchImageView(): SwitchImageView {
        return switchImageView
    }
}