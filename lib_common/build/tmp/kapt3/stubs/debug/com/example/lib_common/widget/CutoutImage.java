package com.example.lib_common.widget;

import java.lang.System;

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
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/example/lib_common/widget/CutoutImage;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_bottomCutSize", "", "_endCutSize", "value", "bottomCutSize", "getBottomCutSize", "()F", "setBottomCutSize", "(F)V", "endCutSize", "getEndCutSize", "setEndCutSize", "grayPainter", "Landroid/graphics/Paint;", "painter", "scratchRect", "Landroid/graphics/RectF;", "translationProgress", "getTranslationProgress", "()I", "setTranslationProgress", "(I)V", "dpToF", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "lib_common_debug"})
public final class CutoutImage extends androidx.appcompat.widget.AppCompatImageView {
    private final android.graphics.RectF scratchRect = null;
    private float _bottomCutSize;
    private float _endCutSize;
    
    /**
     * Fixed image translation progress to make the image scroll as animation progresses.
     *
     * This uses a Matrix to scale then translate the image based on the current progress.
     *
     * This can be directly called by MotionLayout, or be called in response to progress change like
     * we do in this sample.
     */
    private int translationProgress;
    private final android.graphics.Paint painter = null;
    private final android.graphics.Paint grayPainter = null;
    private java.util.HashMap _$_findViewCache;
    
    public final float getBottomCutSize() {
        return 0.0F;
    }
    
    public final void setBottomCutSize(float value) {
    }
    
    public final float getEndCutSize() {
        return 0.0F;
    }
    
    public final void setEndCutSize(float value) {
    }
    
    public final int getTranslationProgress() {
        return 0;
    }
    
    public final void setTranslationProgress(int value) {
    }
    
    private final float dpToF(int value) {
        return 0.0F;
    }
    
    /**
     * Draw the image with current cutouts applied
     */
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.Nullable()
    android.graphics.Canvas canvas) {
    }
    
    public CutoutImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public CutoutImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public CutoutImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}