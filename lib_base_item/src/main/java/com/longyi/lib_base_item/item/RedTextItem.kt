package com.longyi.lib_base_item.item

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.view.ViewGroup
import com.longyi.lib_base_item.utils.dip2px
import android.widget.TextView
import android.view.Gravity
import java.util.regex.Pattern


/**
 * Created by Aller on 2020/10/28.
 */
class RedTextItem:AbstractItem {


    private lateinit var redTextView: TextView
    private lateinit var  redTextViewlp: RelativeLayout.LayoutParams
    private lateinit var  arrowView: ImageView
    private lateinit var  arrowViewlp: RelativeLayout.LayoutParams
    // 数字格式
    private val REG_NUMBER = "^\\d+$"

    constructor(context: Context):super(context){}
    constructor(context: Context, attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){}

    override fun createWidget() {
        redTextView = TextView(mContext);
        redTextView.setId(com.longyi.lib_base_item.R.id.red_text_id);
        arrowView = ImageView(mContext);
    }

    override fun createWidgetLayoutParams() {
        redTextViewlp = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        redTextViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        redTextViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);


        arrowViewlp = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        arrowViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        arrowViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
//        arrowViewlp.addRule(RelativeLayout.RIGHT_OF,R.id.red_text_id);
    }


    override fun addWidget() {
        super.addWidget()
        addView(redTextView,redTextViewlp);
        addView(arrowView,arrowViewlp);
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


        val marginRight = configAttrs.getMarginRight() * 2 + 5
        redTextViewlp.rightMargin = marginRight.dip2px().toInt()


        if (!number(text)) {
            throw RuntimeException("right text must be number")
        }

        redTextView.text = text
        redTextView.setBackgroundResource(com.longyi.lib_base_item.R.drawable.shape_text_red)

        redTextView.setPadding(10, 0, 10, 0)
        redTextView.gravity = Gravity.CENTER
        redTextView.setTextColor(-0x1)
        redTextView.textSize = configAttrs.getRightTextSize().toFloat()


        if (configAttrs.getArrowResId() != 0) {

            arrowViewlp.rightMargin = configAttrs.getMarginRight().dip2px().toInt()

            arrowView.setBackgroundResource(configAttrs.getArrowResId())
        }

    }

    /**
     * 验证数字格式(只能为0-9的值)
     */
    fun number(value: String): Boolean {
        return matcher(REG_NUMBER, value)
    }

    fun matcher(regEx: String, input: String?): Boolean {

        return if (input != null && "" != input) {
            val p = Pattern.compile(regEx)
            val m = p.matcher(input)
            m.matches()
        } else {
            false
        }
    }
}