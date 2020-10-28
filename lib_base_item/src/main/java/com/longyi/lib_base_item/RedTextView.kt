package com.longyi.lib_base_item

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView
import com.longyi.lib_base_item.utils.dip2px
import com.longyi.lib_base_item.utils.sp2px
import android.graphics.Typeface

/**
 * Created by Aller on 2020/10/28.
 */
class RedTextView: TextView {

    private var badgeCount = "0"
    private var badgerPaint: Paint = Paint()
    private var badgerBgColor: Int = 0
    private var badgerTextColor: Int = 0
    private var badgerMargin = 0
    private var badgerPadding = 0
    private var textHeight = 0
    private var strokeWidth = 1f
    private val xFolat = 68
    private val yFolat = 10

    constructor(context: Context):super(context){}
    constructor(context: Context, attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){
        badgerPaint.isAntiAlias = true
        badgerPaint.style = Paint.Style.FILL
        badgerPaint.textAlign = Paint.Align.CENTER


        badgerPaint.textSize = 8.sp2px()
        badgerTextColor = -0x1
        badgerBgColor = Color.RED
        badgerMargin = 2.dip2px().toInt()
        badgerPadding = 6.dip2px().toInt()

        textHeight = getTextHeight(badgerPaint)
        strokeWidth = resources.displayMetrics.density * strokeWidth + 0.5f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if ("0" != badgeCount) {
            badgerPaint.typeface = Typeface.DEFAULT
            val countStr = badgeCount
            val textWidth = badgerPaint.measureText("88")
            val bgRadius = badgerPadding + textWidth / 2

            //画徽章背景圆
            badgerPaint.color = badgerBgColor
            val cx = width - badgerMargin - bgRadius - xFolat
            val cy = badgerMargin + bgRadius - yFolat
            canvas.drawCircle(cx, cy, bgRadius, badgerPaint)
            //画徽章背景圆描边
            badgerPaint.color = badgerTextColor
            badgerPaint.style = Paint.Style.STROKE
            badgerPaint.strokeWidth = strokeWidth
            canvas.drawCircle(cx, cy, bgRadius, badgerPaint)
            //画徽章数字
            badgerPaint.style = Paint.Style.FILL
            badgerPaint.typeface = Typeface.DEFAULT_BOLD
            canvas.drawText(countStr, cx, cy + textHeight / 3, badgerPaint)
        }

    }

    fun setBadgeCount(count: String) {
        this.badgeCount = count
        invalidate()
    }

    /**
     * 获取指定画笔的文字高度
     */
    private fun getTextHeight(paint: Paint): Int {
        val fm = paint.fontMetrics
        return Math.ceil((fm.descent - fm.ascent).toDouble()).toInt()
    }
}