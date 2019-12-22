package com.longyi.module_android_jetpack.widget.custom_bottom_tab

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.longyi.module_android_jetpack.R

/**
 * 自定义view 实现底部导航栏 tab
 */
class CustomTabView:LinearLayout, View.OnClickListener {
    private lateinit var mTabViews:MutableList<View> //保存TabView
    private lateinit var mTabs:MutableList<Tab> // 保存Tab
    private lateinit var mOnTabCheckListener:OnTabCheckListener

    constructor(context: Context): super(context)

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        mTabViews = arrayListOf()
        mTabs = arrayListOf()

    }

    fun setOnTabCheckListener(onTabCheckListener:OnTabCheckListener) {
        mOnTabCheckListener = onTabCheckListener
    }

    /**
     * 添加Tab
     * @param tab
     */
    fun addTab(tab:Tab){
        val view = LayoutInflater.from(context).inflate(R.layout.custom_tab_item_layout,null)
        val textView =  view.findViewById<TextView>(R.id.custom_tab_text)
        val imageView =  view.findViewById<ImageView>(R.id.custom_tab_icon)
        tab.mIconNormalResId?.let { imageView.setImageResource(it) }
        textView.text = tab.mText
        tab.mNormalColor?.let { textView.setTextColor(it) }

        view.tag = mTabViews.size
        view.setOnClickListener(this)

        mTabViews.add(view)
        mTabs.add(tab)

        addView(view)

    }

    /**
     * 设置选中Tab
     * @param position
     */
    fun setCurrentItem(position:Int){
        var tempPosition = position
        if(tempPosition >= mTabs.size || tempPosition<0){
            tempPosition = 0
        }

        mTabViews[tempPosition].performClick()

        updateState(tempPosition)


    }

    /**
     * 更新状态
     * @param position
     */
    fun updateState(position:Int){
        for(i in mTabViews.indices){
            val view = mTabViews[i]
            val textView =  view.findViewById<TextView>(R.id.custom_tab_text)
            val imageView = view.findViewById<ImageView>(R.id.custom_tab_icon)
            if(i == position){
                mTabs[i].mIconPressedResId?.let { imageView.setImageResource(it) }
                mTabs[i].mSelectColor?.let { textView.setTextColor(it) }
            }else{
                mTabs[i].mIconNormalResId?.let { imageView.setImageResource(it) }
                mTabs[i].mNormalColor?.let { textView.setTextColor(it) }
            }
        }
    }

    override fun onClick(v: View?) {
        val position = v?.tag
        if(mOnTabCheckListener!=null){
            v?.let { mOnTabCheckListener.onTabSelected(it, position as Int) }
        }
    }

    interface  OnTabCheckListener{
        fun onTabSelected(v:View,position:Int)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if(mTabViews!=null){
            mTabViews.clear()
        }
        if(mTabs!=null){
            mTabs.clear()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow();
        // 调整每个Tab的大小
        for(i in mTabViews.indices){
            val view = mTabViews[i]
            val width = resources.displayMetrics.widthPixels / (mTabs.size)
            val params =  LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT)
            view.layoutParams = params
        }

    }
}