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
import android.widget.TextView


/**
 * Created by Aller on 2020/10/28.
 */
class TextItem:AbstractItem {
    private lateinit var rightTextView: TextView

    private lateinit var  rightTextViewlp: RelativeLayout.LayoutParams

    constructor(context: Context):super(context){}
    constructor(context: Context, attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){}

    override fun createWidget() {
        rightTextView = TextView(context)

        rightTextView.id = R.id.right_text_id;
    }

    override fun createWidgetLayoutParams() {
        rightTextViewlp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        rightTextViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        rightTextViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
    }


    override fun addWidget() {
        super.addWidget()
        addView(rightTextView, rightTextViewlp);
        setRightTextStyle();
    }

    /**
     * 设置文字的样式
     */
    fun setRightTextStyle() {


        val text = if (configAttrs.getRightTextArray().get(configAttrs.getPosition()) == null)
            ""
        else
            configAttrs.getRightTextArray().get(configAttrs.getPosition())



        rightTextViewlp.rightMargin = configAttrs.getMarginRight().dip2px().toInt()

        rightTextView.text = text

        rightTextView.setTextColor(configAttrs.getRightTextColor())
        rightTextView.textSize = configAttrs.getRightTextSize().toFloat()


        if (configAttrs.getArrowResId() != 0) {

            val drawable = resources.getDrawable(configAttrs.getArrowResId())
            /// 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
            rightTextView.setCompoundDrawables(null, null, drawable, null)
            rightTextView.compoundDrawablePadding = 20

        }

    }
}