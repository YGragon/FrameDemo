package com.longyi.lib_base_item.item

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.view.ViewGroup
import com.longyi.lib_base_item.R
import com.longyi.lib_base_item.utils.dip2px


/**
 * Created by Aller on 2020/10/28.
 */
class ArrowItem:AbstractItem {
    private lateinit var arrowImg: ImageView
    private lateinit var arrowLp: RelativeLayout.LayoutParams

    constructor(context: Context):super(context){}
    constructor(context: Context, attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){}

    override fun createWidget() {

        arrowImg = ImageView(mContext)
        arrowImg.id = R.id.arrow_id
    }

    override fun createWidgetLayoutParams() {
        arrowLp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        arrowLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        arrowLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
    }


    override fun addWidget() {
        super.addWidget()

        addView(arrowImg, arrowLp)
        setArrowStyle()

    }


    /**
     * 箭头的颜色
     */
    fun setArrowStyle() {

        if (configAttrs == null) {
            throw RuntimeException("config attrs is null")
        }

        if (configAttrs.getArrowResId() == 0) {
            throw RuntimeException("arrow res id is null")

        }
        arrowLp.rightMargin = configAttrs.getMarginRight().dip2px().toInt()
        arrowImg.setImageResource(configAttrs.getArrowResId())

    }
}