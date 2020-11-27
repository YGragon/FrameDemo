package com.example.lib_common.utils;

import java.lang.System;

/**
 * 判断 微信是否安装
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/lib_common/utils/WXHelper;", "", "()V", "WECHAT_APP_PACKAGE", "", "WECHAT_LAUNCHER_UI_CLASS", "WECHAT_OPEN_SCANER_NAME", "openScanner", "", "context", "Landroid/content/Context;", "lib_common_debug"})
public final class WXHelper {
    private static final java.lang.String WECHAT_APP_PACKAGE = "com.tencent.mm";
    private static final java.lang.String WECHAT_LAUNCHER_UI_CLASS = "com.tencent.mm.ui.LauncherUI";
    private static final java.lang.String WECHAT_OPEN_SCANER_NAME = "LauncherUI.From.Scaner.Shortcut";
    public static final com.example.lib_common.utils.WXHelper INSTANCE = null;
    
    public final void openScanner(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private WXHelper() {
        super();
    }
}