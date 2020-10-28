package com.longyi.lib_base_item

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.view.ViewGroup
import android.view.View
import com.longyi.lib_base_item.utils.dip2px





/**
 * Created by Aller on 2020/10/28.
 */
class ItemView: RelativeLayout {

    private lateinit var mContext: Context
    private lateinit var iconImg: ImageView
    private lateinit var textView: TextView
    private lateinit var arrowImg: ImageView
    private lateinit var txtLp: RelativeLayout.LayoutParams
    private lateinit var iconLp: RelativeLayout.LayoutParams
    private lateinit var arrowLp: RelativeLayout.LayoutParams
    private lateinit var rightTextView: TextView
    private lateinit var rightTextViewlp: RelativeLayout.LayoutParams
    private lateinit var switchImageView: SwitchImageView
    private lateinit var switchCblp: RelativeLayout.LayoutParams

    constructor(context: Context):super(context){}
    constructor(context: Context, attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){
        this.mContext = context;

        createWidget(context);

        createWidgetLayoutParams();

        addWidget();

        setBackgroundResource(R.drawable.btn_list_item_bg)
    }

    private fun addWidget() {
        addView(textView, txtLp)
        addView(iconImg, iconLp)
        addView(arrowImg, arrowLp)
        addView(rightTextView, rightTextViewlp)
        addView(switchImageView, switchCblp)
    }

    /**
     * 创建item 中没一个控件的  layotParams
     */
    private fun createWidgetLayoutParams() {
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


        arrowLp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        arrowLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        arrowLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)


        rightTextViewlp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        rightTextViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        rightTextViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)


        switchCblp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        switchCblp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        switchCblp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
    }

    /**
     * 创建item 中的控件
     * @param context
     */

    private fun createWidget(context: Context) {
        iconImg = ImageView(context)
        iconImg.id = R.id.img_id

        textView = TextView(context)
        textView.id = R.id.txt_id

        arrowImg = ImageView(context)
        arrowImg.id = R.id.arrow_id

        rightTextView = TextView(context)

        rightTextView.id = R.id.right_text_id


        switchImageView = SwitchImageView(context)

    }


    fun setLayoutParams(itemHeight: Int) {

        val layoutParams = ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutParams.height = itemHeight.dip2px().toInt()
        setLayoutParams(layoutParams)
    }

    /**
     * 设置文字的样式
     * @param text
     */
    fun setTextStyle(text: String, textSize: Int, textColor: Int, iconTextMargin: Int) {
        txtLp.leftMargin = iconTextMargin.dip2px().toInt()
        textView.setText(text)
        textView.setTextColor(textColor)
        textView.setTextSize(textSize.toFloat())

    }

    /**
     * 设置 icon 样式
     * @param width 图片的宽度
     * @param height 图片的高度
     * @param resId 资源Id
     */
    fun setImageStyle(width: Int, height: Int, resId: Int, iconMarginLeft: Int) {
        iconLp.leftMargin = iconMarginLeft.dip2px().toInt()

        iconImg.setBackgroundResource(resId)

        val layoutParams = iconImg.getLayoutParams()

        layoutParams.width = width.dip2px().toInt()
        layoutParams.height = height.dip2px().toInt()

        iconImg.setLayoutParams(layoutParams)

    }

    /**
     * 箭头的颜色
     * @param resId 资源ID
     * @param isShow 是否显示
     */
    fun setArrowStyle(resId: Int, isShow: Boolean, arrowMarginRight: Int) {

        if (resId == 0) {
            arrowImg.setVisibility(View.GONE)
            return
        }

        arrowLp.rightMargin = arrowMarginRight.dip2px().toInt()

        arrowImg.setImageResource(resId)
        if (isShow) {
            arrowImg.setVisibility(View.VISIBLE)
        } else {
            arrowImg.setVisibility(View.GONE)
        }
    }

    /**
     * 箭头的
     * @param resId 资源ID
     */
    fun setArrowStyle(resId: Int, arrowMarginRight: Int) {

        if (resId == 0) {
            arrowImg.setVisibility(View.GONE)
            return
        }

        arrowLp.rightMargin = arrowMarginRight.dip2px().toInt()

        arrowImg.setImageResource(resId)

    }

    /**
     * 设置文字的样式
     * @param text
     */
    fun setRightTextStyle(
        text: String?,
        textSize: Int,
        textColor: Int,
        arrowMarginRight: Int,
        arrowResId: Int
    ) {
        var text = text


        if (text == null || text == "") {
            text = ""
        }
        rightTextViewlp.rightMargin = arrowMarginRight.dip2px().toInt()
        rightTextView.setText(text)
        rightTextView.setTextColor(textColor)
        rightTextView.setTextSize(textSize.toFloat())

        if (arrowResId == 0) {
            return
        }

        val drawable = resources.getDrawable(arrowResId)
        /// 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
        rightTextView.setCompoundDrawables(null, null, drawable, null)
        rightTextView.setCompoundDrawablePadding(20)


    }

    /**
     * 设置文字的样式
     * @param text
     */
    fun setRightText(text: String) {

        rightTextView.setText(text)

    }

    fun setSwitchImageViewStyle(
        trunResId: Int,
        upresId: Int,
        arrowMarginRight: Int
    ): SwitchImageView {


        if (trunResId == 0 || upresId == 0) {
            throw RuntimeException("turnResId or upResId is not set")
        }


        switchCblp.rightMargin = arrowMarginRight.dip2px().toInt()

        switchImageView.setImageResource(trunResId)


        return switchImageView
    }


    /**
     * 隐藏右边全部类型的控件
     */
    private fun hideRightAllType() {
        arrowImg.setVisibility(View.GONE)
        rightTextView.setVisibility(View.GONE)
        switchImageView.setVisibility(View.GONE)
    }

}