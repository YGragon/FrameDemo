package com.longyi.lib_base_item.config

import android.util.SparseArray
import androidx.annotation.ColorRes
import androidx.annotation.NonNull


/**
 * Created by Aller on 2020/10/28.
 */
class ConfigAttrs {


    private var position: Int = 0

    /**
     * item 的 高度
     */
    private var itemHeight: Int = 0

    /**
     * 线的颜色
     */
    private var lineColor: Int = 0

    /**
     * 图标的 高宽
     */
    private var iconWidth: Int = 0
    private var iconHeight: Int = 0

    /**
     * 字体的大小
     */
    private var textSize: Int = 0

    /**
     * 字体的颜色
     */
    private var textColor: Int = 0


    /**
     * 图标距离左边的 marginLeft 大小
     */
    private var iconMarginLeft: Int = 0

    /**
     * 文字 距离 图标的 marginLeft 大小
     */
    private var iconTextMargin: Int = 0

    /**
     * TextView 的显示文字 按顺序 插入
     */
    private var valueList: List<String>? = null

    /**
     * icon 图标的 resId 按顺序插入
     */
    private var resIdList: List<Int>? = null


    /**
     * 箭头距离 最右边 的 marginRight 大小
     */
    private var marginRight: Int = 0

    /**
     * 箭头的资源Id
     */
    private var arrowResId: Int = 0


    private var textArrowResId: Int = 0

    /**
     * 字体的大小
     */
    private var rightTextSize: Int = 0

    /**
     * 字体的颜色
     */
    private var rightTextColor: Int = 0


    /**
     * button图标的资源
     */
    private var trunResId: Int = 0
    private var upResId: Int = 0
    /**
     * 右边字体和箭头的间距
     */
    private var rightTextMagin: Int = 0

    /**
     * item 的背景selector
     */
    private var itemBgSelector: Int = 0

    /**
     * 每一个 item 与 item 之间的 marginTop 的大小
     */
    private val marginArray = SparseArray<Int>()


    /**
     * item 的模式
     */
    private val modeArray = SparseArray<Mode>()

    /**
     * 保存右边的text
     */

    private val rightTextArray = SparseArray<String>()


    fun getTextArrowResId(): Int {
        return textArrowResId
    }

    fun setTextArrowResId(textArrowResId: Int): ConfigAttrs {
        this.textArrowResId = textArrowResId
        return this
    }

    fun getPosition(): Int {
        return position
    }

    fun setPosition(position: Int) {
        this.position = position
    }

    fun getItemHeight(): Int {
        return itemHeight
    }

    fun getItemBgSelector(): Int {
        return itemBgSelector
    }

    fun setItemBgSelector(drawableId: Int): ConfigAttrs {
        this.itemBgSelector = drawableId
        return this
    }

    fun setItemHeight(itemHeight: Int): ConfigAttrs {
        this.itemHeight = itemHeight
        return this
    }

    fun getLineColor(): Int {
        return lineColor
    }

    fun setLineColor(@ColorRes lineColor: Int): ConfigAttrs {
        this.lineColor = lineColor
        return this
    }

    fun getIconWidth(): Int {
        return iconWidth
    }

    fun setIconWidth(iconWidth: Int): ConfigAttrs {
        this.iconWidth = iconWidth
        return this
    }

    fun getIconHeight(): Int {
        return iconHeight
    }

    fun setIconHeight(iconHeight: Int): ConfigAttrs {
        this.iconHeight = iconHeight
        return this
    }

    fun getTextSize(): Int {
        return textSize
    }

    fun setTextSize(textSize: Int): ConfigAttrs {
        this.textSize = textSize
        return this
    }

    fun getTextColor(): Int {
        return textColor
    }

    fun setTextColor(@ColorRes textColor: Int): ConfigAttrs {
        this.textColor = textColor
        return this
    }

    fun getIconMarginLeft(): Int {
        return iconMarginLeft
    }

    fun setIconMarginLeft(iconMarginLeft: Int): ConfigAttrs {
        this.iconMarginLeft = iconMarginLeft
        return this
    }

    fun getIconTextMargin(): Int {
        return iconTextMargin
    }

    fun setIconTextMargin(iconTextMargin: Int): ConfigAttrs {
        this.iconTextMargin = iconTextMargin
        return this
    }

    fun getValueList(): List<String>? {
        return valueList
    }

    fun setValueList(@NonNull valueList: List<String>): ConfigAttrs {
        this.valueList = valueList
        return this
    }

    fun getResIdList(): List<Int>? {
        return resIdList
    }

    fun setResIdList(@NonNull resIdList: List<Int>): ConfigAttrs {
        this.resIdList = resIdList
        return this
    }

    fun getMarginRight(): Int {
        return marginRight
    }

    fun setMarginRight(marginRight: Int): ConfigAttrs {
        this.marginRight = marginRight
        return this
    }

    fun getArrowResId(): Int {
        return arrowResId
    }

    fun setArrowResId(arrowResId: Int): ConfigAttrs {
        this.arrowResId = arrowResId
        return this
    }

    fun getRightTextSize(): Int {
        return rightTextSize
    }

    fun setRightTextSize(rightTextSize: Int): ConfigAttrs {
        this.rightTextSize = rightTextSize
        return this
    }

    fun getRightTextColor(): Int {
        return rightTextColor
    }

    fun setRightTextColor(rightTextColor: Int): ConfigAttrs {
        this.rightTextColor = rightTextColor
        return this
    }

    fun getTrunResId(): Int {
        return trunResId
    }

    fun setTrunResId(trunResId: Int): ConfigAttrs {
        this.trunResId = trunResId
        return this
    }

    fun getUpResId(): Int {
        return upResId
    }

    fun setUpResId(upResId: Int): ConfigAttrs {
        this.upResId = upResId
        return this
    }

    fun getRightTextMagin(): Int {
        return rightTextMagin
    }

    fun setRightTextMagin(rightTextMagin: Int): ConfigAttrs {
        this.rightTextMagin = rightTextMagin
        return this
    }


    fun getMarginArray(): SparseArray<*> {
        return marginArray
    }

    fun getModeArray(): SparseArray<Mode> {
        return modeArray
    }

    fun getRightTextArray(): SparseArray<String> {
        return rightTextArray
    }


    fun setItemMode(value: Mode): ConfigAttrs {

        if (valueList!!.size <= 0) {
            throw RuntimeException("values is null")
        }

        for (i in valueList!!.indices) {
            modeArray.put(i, value)
        }
        return this
    }

    fun setItemMode(index: Int, value: Mode): ConfigAttrs {
        modeArray.put(index, value)
        return this
    }


    fun setRightText(values: List<String>?): ConfigAttrs {

        if (values == null) {
            throw RuntimeException("values is null")
        }

        if (values.size <= 0) {
            throw RuntimeException("")
        }

        for (i in values.indices) {
            rightTextArray.put(i, values[i])
        }

        return this
    }

    fun setRightText(position: Int, text: String): ConfigAttrs {

        rightTextArray.put(position, text)
        return this
    }


    fun setItemMarginTop(index: Int, value: Int): ConfigAttrs {
        marginArray.put(index, value)
        return this
    }

    fun setItemMarginTop(value: Int): ConfigAttrs {

        if (valueList!!.size <= 0) {
            throw RuntimeException("")
        }

        for (i in valueList!!.indices) {
            marginArray.put(i, value)
        }
        return this
    }

}