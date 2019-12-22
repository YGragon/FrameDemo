package com.longyi.module_android_jetpack.widget.custom_bottom_tab

/**
 * AndroidJetPack bottom item
 */
class Tab private constructor(builder: Builder){
    internal var mIconNormalResId: Int? = 0
    internal var mIconPressedResId: Int? = 0
    internal var mNormalColor: Int? = 0
    internal var mSelectColor: Int? = 0
    internal var mText: String? = null

    init {
        mIconNormalResId = builder.mIconNormalResId
        mIconPressedResId = builder.mIconPressedResId
        mNormalColor = builder.mNormalColor
        mSelectColor = builder.mSelectColor
        mText = builder.mText
    }

    class Builder {
        internal var mIconNormalResId: Int? = 0
        internal var mIconPressedResId: Int? = 0
        internal var mNormalColor: Int? = 0
        internal var mSelectColor: Int? = 0
        internal var mText: String? = null

        fun setNormalIcon(res: Int): Builder {
            mIconNormalResId = res
            return this
        }
        fun setPressedIcon(res: Int): Builder {
            mIconPressedResId = res
            return this
        }
        fun setColor(color:Int):Builder{
            mNormalColor = color
            return this
        }
        fun setCheckedColor(color:Int):Builder{
            mSelectColor = color
            return this
        }
        fun setText(text:String):Builder{
            mText = text
            return this
        }

        fun build(): Tab {
            return Tab(this)
        }
    }
}