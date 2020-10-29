package com.longyi.lib_base_item.item

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import com.longyi.lib_base_item.config.ConfigAttrs
import android.widget.TextView
import android.view.ViewGroup
import com.longyi.lib_base_item.R
import com.longyi.lib_base_item.utils.dip2px


/**
 * Created by Aller on 2020/10/28.
 */
abstract class AbstractItem(context: Context):RelativeLayout(context) {
    protected lateinit var iconImg: ImageView
    protected lateinit var textView1: TextView
    protected lateinit var txtLp: RelativeLayout.LayoutParams
    protected lateinit var iconLp: RelativeLayout.LayoutParams


    protected lateinit var configAttrs: ConfigAttrs

    constructor(context:Context,attributeSet: AttributeSet):this(context){
        initData(context)
    }
    constructor(context:Context,attributeSet: AttributeSet, defStyleAttr: Int):this(context, attributeSet){
        initData(context)
    }

    private fun initData(context: Context) {

        setBackgroundResource(R.drawable.btn_list_item_black_bg)

        iconImg = ImageView(context)
        iconImg.id = R.id.img_id
        Log.e("222","-------------------------")
        textView1 = TextView(context)
        Log.e("222",textView1.toString())
        textView1.id = R.id.txt_id
        iconLp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        iconLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        txtLp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        txtLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        txtLp.addRule(RelativeLayout.RIGHT_OF, R.id.img_id)
    }


    /**
     * 创建view
     */
    abstract fun createWidget()

    abstract fun createWidgetLayoutParams()

    open fun addWidget() {

        addView(textView1, txtLp)
        addView(iconImg, iconLp)


    }


    /**
     * 创建出itemview
     * @param configAttrs
     */
    fun create(configAttrs: ConfigAttrs) {
        this.configAttrs = configAttrs

        initData(context)

        setBackgroundResource(configAttrs.getItemBgSelector())
        createWidget()
        createWidgetLayoutParams()
        addWidget()

        setLayoutParams()
        setIconStyle()
        setTextStyle()


    }


    fun setLayoutParams() {


        if (configAttrs.getItemHeight() <= 0) {
            throw RuntimeException("item height is null")
        }

        val layoutParams = ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutParams.height = configAttrs.getItemHeight().dip2px().toInt()
        setLayoutParams(layoutParams)
    }


    /**
     * 设置文字的样式
     */
    fun setTextStyle() {


        txtLp.leftMargin = configAttrs.getIconTextMargin().dip2px().toInt()
        textView1.setTextColor(configAttrs.getTextColor())
        textView1.textSize = configAttrs.getTextSize().toFloat()
        textView1.text = configAttrs.getValueList()!![configAttrs.getPosition()]

    }


    /**
     * 设置 icon 样式
     */
    fun setIconStyle() {


        if (configAttrs.getIconHeight() <= 0) {
            throw RuntimeException("icon height  is null")
        }

        if (configAttrs.getIconWidth() <= 0) {
            throw RuntimeException("icon width  is null")
        }

        iconLp.leftMargin = configAttrs.getIconMarginLeft().dip2px().toInt()

        iconImg.setBackgroundResource(configAttrs.getResIdList()!![configAttrs.getPosition()])

        val layoutParams = iconImg.getLayoutParams()

        layoutParams.width = configAttrs.getIconWidth().dip2px().toInt()
        layoutParams.height = configAttrs.getIconHeight().dip2px().toInt()

        iconImg.layoutParams = layoutParams

    }

}