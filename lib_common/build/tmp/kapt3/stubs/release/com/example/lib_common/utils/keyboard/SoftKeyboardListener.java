package com.example.lib_common.utils.keyboard;

import java.lang.System;

/**
 * 软键盘监听
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/lib_common/utils/keyboard/SoftKeyboardListener;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "onSoftKeyBoardChangeListener", "Lcom/example/lib_common/utils/keyboard/SoftKeyboardListener$OnSoftKeyBoardChangeListener;", "rootView", "Landroid/view/View;", "rootViewVisibleHeight", "", "setOnSoftKeyBoardChangeListener", "", "OnSoftKeyBoardChangeListener", "lib_common_release"})
public final class SoftKeyboardListener {
    private final android.view.View rootView = null;
    private int rootViewVisibleHeight;
    private com.example.lib_common.utils.keyboard.SoftKeyboardListener.OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    
    private final void setOnSoftKeyBoardChangeListener(com.example.lib_common.utils.keyboard.SoftKeyboardListener.OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
    }
    
    public SoftKeyboardListener(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/lib_common/utils/keyboard/SoftKeyboardListener$OnSoftKeyBoardChangeListener;", "", "keyBoardHide", "", "height", "", "keyBoardShow", "lib_common_release"})
    public static abstract interface OnSoftKeyBoardChangeListener {
        
        public abstract void keyBoardShow(int height);
        
        public abstract void keyBoardHide(int height);
    }
}