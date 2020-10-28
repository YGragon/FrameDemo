package com.longyi.lib_base_item

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.longyi.lib_base_item.config.CommonCons
import com.longyi.lib_base_item.config.ConfigAttrs
import com.longyi.lib_base_item.factory.AbstractItemFactory
import com.longyi.lib_base_item.factory.ItemFactory
import com.longyi.lib_base_item.item.ButtonItem
import android.view.ViewGroup
import com.longyi.lib_base_item.config.Mode
import com.longyi.lib_base_item.item.AbstractItem
import com.longyi.lib_base_item.utils.dip2px




/**
 * Created by Aller on 2020/10/28.
 */
class BaseItemLayout(context: Context): LinearLayout(context) {

    private lateinit var mContext: Context


    private var mFactory: AbstractItemFactory? = null
    private lateinit var mConfigAttrs: ConfigAttrs

    private val mViewList = arrayListOf<View>()
    private var mLineColor: Int = 0
    private var mTextSize: Int = 0
    private var mTextColor: Int = 0
    private var mIconMarginLeft: Int = 0
    private var mIconTextMargin: Int = 0
    private var mArrowMarginRight: Int = 0
    private var mItemHeight: Int = 0
    private var mRightTextSize: Int = 0
    private var mRightTextColor: Int = 0
    private var mRightTextMagin: Int = 0
    private var mItemBgSelector: Int = 0


    constructor(context: Context, attributeSet: AttributeSet): this(context){
        initData(context)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): this(context, attributeSet){
        initCustomerArrts(context, attributeSet)
        initData(context)

    }

    private fun initData(context: Context){
        this.mContext = context
        mFactory = ItemFactory(mContext)
        orientation = VERTICAL
    }



    private fun initCustomerArrts(context: Context, attrs: AttributeSet) {

        val a = context.obtainStyledAttributes(attrs, R.styleable.ItemAttrs)

        mLineColor = a.getColor(R.styleable.ItemAttrs_bil_line_color, CommonCons.DF_LINE_COLOR)
        mTextSize = a.getInt(R.styleable.ItemAttrs_bil_text_size, CommonCons.DF_TEXT_SIZE)
        mTextColor = a.getColor(R.styleable.ItemAttrs_bil_text_color, CommonCons.DF_TEXT_COLOR)
        mIconMarginLeft =
            a.getInt(R.styleable.ItemAttrs_bil_icon_margin_left, CommonCons.DF_ICON_MARGIN_LEFT)
        mIconTextMargin =
            a.getInt(R.styleable.ItemAttrs_bil_icon_text_margin, CommonCons.DF_ICON_TEXT_MARGIN)
        mArrowMarginRight =
            a.getInt(R.styleable.ItemAttrs_bil_margin_right, CommonCons.DF_ARROW_MARGIN_RIGHT)
        mItemHeight = a.getInt(R.styleable.ItemAttrs_bil_item_height, CommonCons.DF_ITEM_HEIGHT)
        mRightTextSize =
            a.getInt(R.styleable.ItemAttrs_bil_right_text_size, CommonCons.DF_RIGHT_TEXT_SIZE)
        mRightTextColor =
            a.getColor(R.styleable.ItemAttrs_bil_right_text_color, CommonCons.DF_RIGHT_TEXT_COLOR)
        mRightTextMagin =
            a.getInt(R.styleable.ItemAttrs_bil_right_text_margin, CommonCons.DF_RIGHT_TEXT_MAGIN)
        mItemBgSelector =
            a.getInt(R.styleable.ItemAttrs_bil_item_bg_color, CommonCons.ITEM_BG_COLOR)

        a.recycle()
    }


    fun create(context: Context) {
        this.mContext = context

        if (mConfigAttrs.getValueList() == null) {
            throw RuntimeException("valueList  is null")
        }

        if (mConfigAttrs.getResIdList() == null) {
            throw RuntimeException(" resIdList is null")
        }

        if (mConfigAttrs.getValueList()!!.size != mConfigAttrs.getResIdList()!!.size) {
            throw RuntimeException("params not match, valueList.size() should be equal resIdList.size()")
        }

        for (i in mConfigAttrs.getValueList()!!.indices) {


            mConfigAttrs.setPosition(i)
            val modeArray = mConfigAttrs.getModeArray()
            val mode = modeArray.get(i)
            if (mFactory == null){
                mFactory = ItemFactory(context)
            }
            val itemView = mFactory?.createItem(mode, mConfigAttrs)
            addItem(itemView!!, i)

        }

    }

    /**
     * 添加 item
     * @param view
     * @param pos
     */
    private fun addItem(view: AbstractItem, pos: Int) {


        if (mConfigAttrs.getMarginArray().get(pos) != null) {
            addView(createLineView(mConfigAttrs.getMarginArray().get(pos) as Int))
        }


        addView(view)
        addView(createLineView(CommonCons.ZERO_HEIGHT))
        //
        if (onBaseItemClick != null) {
            setListener(view, pos)
        }

        if (onSwitchClickListener != null) {
            setButtonClick()
        }

        mViewList.add(view)
    }

    /**
     * 创建线
     * @param margin
     * @return
     */
    private fun createLineView(margin: Int): View {

        val view = View(mContext)
        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        lp.topMargin = margin.dip2px().toInt()

        view.layoutParams = lp
        view.setBackgroundColor(mLineColor)
        return view
    }

    private fun setOnClick() {
        if (onBaseItemClick != null) {
            for (i in mViewList.indices) {
                val view = mViewList[i]
                setListener(view, i)
            }
        }
    }

    /**
     * 设置 item 的监听回调
     * @param view
     * @param position
     */
    private fun setListener(view: View?, position: Int) {
        if (view == null) {
            return
        }

        view.setOnClickListener { onBaseItemClick!!.onItemClick(position) }
    }

    /**
     * 设置 button的点击事件
     */
    private fun setButtonClick() {

        if (onSwitchClickListener != null) {

            for (i in mViewList.indices) {

                val modeArray = mConfigAttrs.getModeArray()

                val mode = modeArray.get(i)

                if (mode === Mode.BOTTON) {

                    val view = mViewList[i] as ButtonItem

                    val switchImageView = view.getSwitchImageView()

                    onButtonClick(i, switchImageView)

                }

            }

        }
    }


    private fun onButtonClick(pos: Int, switchImageView: SwitchImageView) {

        switchImageView.setOnSwitchClickListener(object : SwitchImageView.OnSwitchClickListener {
            override fun onClick(isCheck: Boolean) {


                if (isCheck) {
                    switchImageView.setImageResource(R.drawable.img_up)
                } else {
                    switchImageView.setImageResource(R.drawable.img_turn_down)
                }
                onSwitchClickListener!!.onClick(pos, isCheck)
            }
        })
    }


    fun setConfigAttrs(attrs: ConfigAttrs?): BaseItemLayout {


        if (attrs == null) {
            throw RuntimeException("attrs is null")
        }
        this.mConfigAttrs = attrs


        if (mConfigAttrs.getLineColor() == 0) {
            mConfigAttrs.setLineColor(mLineColor)
        }

        if (mConfigAttrs.getTextSize() == 0) {
            mConfigAttrs.setTextSize(mTextSize)
        }

        if (mConfigAttrs.getTextColor() == 0) {
            mConfigAttrs.setTextColor(mTextColor)
        }

        if (mConfigAttrs.getIconMarginLeft() == 0) {
            mConfigAttrs.setIconMarginLeft(mIconMarginLeft)
        }

        if (mConfigAttrs.getRightTextColor() == 0) {
            mConfigAttrs.setRightTextColor(mRightTextColor)
        }
        if (mConfigAttrs.getRightTextSize() == 0) {
            mConfigAttrs.setRightTextSize(mRightTextSize)
        }

        if (mConfigAttrs.getIconTextMargin() == 0) {
            mConfigAttrs.setIconTextMargin(mIconTextMargin)
        }
        if (mConfigAttrs.getMarginRight() == 0) {
            mConfigAttrs.setMarginRight(mArrowMarginRight)
        }

        if (mConfigAttrs.getItemHeight() == 0) {
            mConfigAttrs.setItemHeight(mItemHeight)
        }

        if (mConfigAttrs.getRightTextMagin() == 0) {

            mConfigAttrs.setRightTextMagin(mRightTextMagin)
        }
        if (mConfigAttrs.getItemBgSelector() == 0) {

            mConfigAttrs.setItemBgSelector(mItemBgSelector)
        }
        return this
    }

    //=================================监听事件====================================


    private var onBaseItemClick: OnBaseItemClick? = null

    fun setOnBaseItemClick(onBaseItemClick: OnBaseItemClick) {
        this.onBaseItemClick = onBaseItemClick
        setOnClick()
    }

    interface OnBaseItemClick {

        fun onItemClick(position: Int)
    }


    private var onSwitchClickListener: OnSwitchClickListener? = null

    fun setOnSwitchClickListener(onSwitchClickListener: OnSwitchClickListener) {
        this.onSwitchClickListener = onSwitchClickListener
        setButtonClick()
    }


    interface OnSwitchClickListener {

        fun onClick(position: Int, isCheck: Boolean)
    }
}