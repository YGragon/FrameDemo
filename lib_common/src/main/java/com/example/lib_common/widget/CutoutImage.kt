package com.example.lib_common.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import com.example.lib_common.R

/**
 * Created by Aller on 2020/11/8.
 */
/**
 * A custom view to display a circular cutout on an image that can be controlled by MotionLayout.
 *
 * Animation of this view is driven by motionLayout controlling [bottomCutSize] and [endCutSize]
 * and [translationProgress].
 *
 * This View will overwrite scaleType from XML to be matrix to allow custom translation. This is
 * a slightly more efficient way to translate a background than oversizing the view and changing
 * constraints as is done in [Entrance].
 */
class CutoutImage @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private val scratchRect = RectF()

    private var _bottomCutSize: Float

    /**
     * Set the size of the bottomCut.
     *
     * This can directly be called by MotionLayout to animate the size.
     */
    var bottomCutSize: Float
        get() = _bottomCutSize
        set(value) {
            _bottomCutSize = value
            invalidate()
        }

    private var _endCutSize: Float

    /**
     * Set the size of the endCut.
     *
     * This can directly be called by MotionLayout to animate the size.
     */
    var endCutSize: Float
        get() = _endCutSize
        set(value) {
            _endCutSize = value
            invalidate()
        }

    /**
     * Fixed image translation progress to make the image scroll as animation progresses.
     *
     * This uses a Matrix to scale then translate the image based on the current progress.
     *
     * This can be directly called by MotionLayout, or be called in response to progress change like
     * we do in this sample.
     */
    var translationProgress: Int = 0
        set(value) {
            field = value
            val matrix = imageMatrix
            val imageWidth = drawable.intrinsicWidth.toFloat()
            val scaleFactor = width.toFloat() / imageWidth
            matrix.setScale(scaleFactor, scaleFactor)
            matrix.postTranslate(0f, -100f + value)
            imageMatrix = matrix
        }

    private val painter = Paint()

    private val grayPainter = Paint().also {
        it.color = 0x33000000
        it.strokeWidth = dpToF(1)
    }

    /**
     * Read the endCut, bottomCut, and cutoutColor from XML
     */
    init {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CutoutImage,
            0,
            0
        )

        _endCutSize = typedArray.getDimension(R.styleable.CutoutImage_endCut, dpToF(0))
        _bottomCutSize = typedArray.getDimension(R.styleable.CutoutImage_bottomCut, dpToF(0))
        painter.color = typedArray.getColor(R.styleable.CutoutImage_cutoutColor, 0xFFaaFFaa.toInt())
        typedArray.recycle()
    }

    /**
     * Force the scaleType to matrix
     */
    init {
        scaleType = ScaleType.MATRIX // ignore any other scale types
    }

    private fun dpToF(value: Int): Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value.toFloat(),
        resources.displayMetrics
    )

    /**
     * Draw the image with current cutouts applied
     */
    override fun onDraw(canvas: Canvas?) {
        // let the parent draw the bitmap
        super.onDraw(canvas)

        // draw the bottom circle at the correct position and size
        canvas?.drawCircle(
            width.toFloat() / 2, // midpoint of view
            height.toFloat(), // bottom of view
            _bottomCutSize / 2, // radius from diameter
            painter
        )

        // draw the end circle at the correct position and size
        val margin = dpToF(16)
        canvas?.drawCircle(
            width - margin, // end of view, with custom margin applied
            2 * height.toFloat() / 3, // 2/3 down on view (determined by designer)
            _endCutSize / 2, // radius from diameter
            painter
        )

        // add a 1px gray line to the bottom of the end circle region so it clearly divides from
        // surrounding region (this effectively brings the shadow in early on the end circle)
        canvas?.drawLine(
            // start at the left edge of circle (this could do trig to calculate intersection
            // between circle and bottom, but visually this works fine)
            width - margin - _endCutSize / 2,
            height.toFloat(), // bottom of view
            width.toFloat(), // to end of view X
            height.toFloat(), // bottom of view
            grayPainter
        )
    }
}