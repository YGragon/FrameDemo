package com.longyi.lib_base_item.item

import android.content.Context
import android.util.AttributeSet
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
abstract class AbstractItem:RelativeLayout {
    protected lateinit var mContext: Context
    protected var iconImg: ImageView
    protected var textView: TextView
    protected var txtLp: RelativeLayout.LayoutParams
    protected var iconLp: RelativeLayout.LayoutParams


    protected lateinit var configAttrs: ConfigAttrs

    constructor(context:Context):super(context){}
    constructor(context:Context,attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context:Context,attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){
        this.mContext = context
    }

    init {
        setBackgroundResource(R.drawable.btn_list_item_black_bg)

        iconImg = ImageView(mContext)
        iconImg.id = R.id.img_id
        textView = TextView(mContext)
        textView.id = R.id.txt_id
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

        addView(textView, txtLp)
        addView(iconImg, iconLp)


    }


    /**
     * 创建出itemview
     * @param configAttrs
     */
    fun create(configAttrs: ConfigAttrs) {
        this.configAttrs = configAttrs

        setBackgroundResource(configAttrs.getItemBgSelector())
        createWidget()
        createWidgetLayoutParams()
        addWidget()

        setLayoutParams()
        setIconStyle()
        setTextStyle()


    }


    fun setLayoutParams() {


        if (configAttrs == null) {
            throw RuntimeException("config arrts is null")
        }


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


        if (configAttrs == null) {
            throw RuntimeException("config arrts is null")
        }



        txtLp.leftMargin = configAttrs.getIconTextMargin().dip2px().toInt()
        textView.setTextColor(configAttrs.getTextColor())
        textView.textSize = configAttrs.getTextSize().toFloat()
        textView.text = configAttrs.getValueList()!![configAttrs.getPosition()]

    }


    /**
     * 设置 icon 样式
     */
    fun setIconStyle() {

        if (configAttrs == null) {
            throw RuntimeException("config arrts is null")
        }


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