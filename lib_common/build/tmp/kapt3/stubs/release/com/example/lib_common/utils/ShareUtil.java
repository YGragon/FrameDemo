package com.example.lib_common.utils;

import java.lang.System;

/**
 * 分享工具类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/lib_common/utils/ShareUtil;", "", "builder", "Lcom/example/lib_common/utils/ShareUtil$Builder;", "(Lcom/example/lib_common/utils/ShareUtil$Builder;)V", "TAG", "", "activity", "Landroid/app/Activity;", "componentClassName", "componentPackageName", "contentText", "contentType", "forcedUseSystemChooser", "", "requestCode", "", "shareFileUri", "Landroid/net/Uri;", "title", "checkShareParam", "createShareIntent", "Landroid/content/Intent;", "shareBySystem", "", "Builder", "lib_common_release"})
public final class ShareUtil {
    private final java.lang.String TAG = null;
    
    /**
     * Current activity
     */
    private final android.app.Activity activity = null;
    
    /**
     * Share content type
     */
    private final java.lang.String contentType = null;
    
    /**
     * Share title
     */
    private java.lang.String title;
    
    /**
     * Share file Uri
     */
    private final android.net.Uri shareFileUri = null;
    
    /**
     * Share content text
     */
    private final java.lang.String contentText = null;
    
    /**
     * Share to special component PackageName
     */
    private final java.lang.String componentPackageName = null;
    
    /**
     * Share to special component ClassName
     */
    private final java.lang.String componentClassName = null;
    
    /**
     * Share complete onActivityResult requestCode
     */
    private int requestCode;
    
    /**
     * Forced Use System Chooser
     */
    private boolean forcedUseSystemChooser;
    
    /**
     * shareBySystem
     */
    public final void shareBySystem() {
    }
    
    private final android.content.Intent createShareIntent() {
        return null;
    }
    
    private final boolean checkShareParam() {
        return false;
    }
    
    public ShareUtil(@org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    com.example.lib_common.utils.ShareUtil.Builder builder) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010+\u001a\u00020,J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0014J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010/\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\'\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\bJ\u0010\u0010*\u001a\u00020\u00002\b\b\u0001\u0010(\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b\'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\f\u00a8\u00060"}, d2 = {"Lcom/example/lib_common/utils/ShareUtil$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "componentClassName", "", "getComponentClassName", "()Ljava/lang/String;", "setComponentClassName", "(Ljava/lang/String;)V", "componentPackageName", "getComponentPackageName", "setComponentPackageName", "contentType", "getContentType", "setContentType", "forcedUseSystemChooser", "", "getForcedUseSystemChooser", "()Z", "setForcedUseSystemChooser", "(Z)V", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "shareFileUri", "Landroid/net/Uri;", "getShareFileUri", "()Landroid/net/Uri;", "setShareFileUri", "(Landroid/net/Uri;)V", "textContent", "getTextContent", "setTextContent", "title", "getTitle", "setTitle", "build", "Lcom/example/lib_common/utils/ShareUtil;", "enable", "setOnActivityResult", "setShareToComponent", "lib_common_release"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull()
        private java.lang.String contentType;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String title;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String componentPackageName;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String componentClassName;
        @org.jetbrains.annotations.Nullable()
        private android.net.Uri shareFileUri;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String textContent;
        private int requestCode;
        private boolean forcedUseSystemChooser;
        @org.jetbrains.annotations.NotNull()
        private final android.app.Activity activity = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getContentType() {
            return null;
        }
        
        public final void setContentType(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getTitle() {
            return null;
        }
        
        public final void setTitle(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getComponentPackageName() {
            return null;
        }
        
        public final void setComponentPackageName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getComponentClassName() {
            return null;
        }
        
        public final void setComponentClassName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.net.Uri getShareFileUri() {
            return null;
        }
        
        public final void setShareFileUri(@org.jetbrains.annotations.Nullable()
        android.net.Uri p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getTextContent() {
            return null;
        }
        
        public final void setTextContent(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final int getRequestCode() {
            return 0;
        }
        
        public final void setRequestCode(int p0) {
        }
        
        public final boolean getForcedUseSystemChooser() {
            return false;
        }
        
        public final void setForcedUseSystemChooser(boolean p0) {
        }
        
        /**
         * Set Content Type
         * @param contentType [ShareContentType]
         * @return Builder
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ShareUtil.Builder setContentType(@org.jetbrains.annotations.NotNull()
        java.lang.String contentType) {
            return null;
        }
        
        /**
         * Set Title
         * @param title title
         * @return Builder
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ShareUtil.Builder setTitle(@org.jetbrains.annotations.NotNull()
        @androidx.annotation.NonNull()
        java.lang.String title) {
            return null;
        }
        
        /**
         * Set share file path
         * @param shareFileUri shareFileUri
         * @return Builder
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ShareUtil.Builder setShareFileUri(@org.jetbrains.annotations.NotNull()
        android.net.Uri shareFileUri) {
            return null;
        }
        
        /**
         * Set text content
         * @param textContent  textContent
         * @return Builder
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ShareUtil.Builder setTextContent(@org.jetbrains.annotations.NotNull()
        java.lang.String textContent) {
            return null;
        }
        
        /**
         * Set Share To Component
         * @param componentPackageName componentPackageName
         * @param componentClassName componentPackageName
         * @return Builder
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ShareUtil.Builder setShareToComponent(@org.jetbrains.annotations.NotNull()
        java.lang.String componentPackageName, @org.jetbrains.annotations.NotNull()
        java.lang.String componentClassName) {
            return null;
        }
        
        /**
         * Set onActivityResult requestCode, default value is -1
         * @param requestCode requestCode
         * @return Builder
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ShareUtil.Builder setOnActivityResult(int requestCode) {
            return null;
        }
        
        /**
         * Forced Use System Chooser To Share
         * @param enable default is true
         * @return Builder
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ShareUtil.Builder forcedUseSystemChooser(boolean enable) {
            return null;
        }
        
        /**
         * build
         * @return ShareUtil
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ShareUtil build() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.app.Activity getActivity() {
            return null;
        }
        
        public Builder(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
            super();
        }
    }
}