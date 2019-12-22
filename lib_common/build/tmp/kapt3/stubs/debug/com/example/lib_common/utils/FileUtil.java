package com.example.lib_common.utils;

import java.lang.System;

/**
 * * 文件工具类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002J9\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J$\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/lib_common/utils/FileUtil;", "", "()V", "TAG", "", "forceGetFileUri", "Landroid/net/Uri;", "shareFile", "Ljava/io/File;", "getAudioContentUri", "context", "Landroid/content/Context;", "audioFile", "getDataColumn", "uri", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getFileContentUri", "file", "getFileRealPath", "getFileUri", "shareContentType", "getImageContentUri", "imageFile", "getShareFileUri", "filePath", "getVideoContentUri", "videoFile", "isDownloadsDocument", "", "isExternalStorageDocument", "isMediaDocument", "lib_common_debug"})
public final class FileUtil {
    private static final java.lang.String TAG = "Share";
    public static final com.example.lib_common.utils.FileUtil INSTANCE = null;
    
    /**
     * * Get file uri
     *     * @param context context
     *     * @param shareContentType shareContentType [ShareContentType]
     *     * @param file file
     *     * @return Uri
     */
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getFileUri(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String shareContentType, @org.jetbrains.annotations.Nullable()
    java.io.File file) {
        return null;
    }
    
    /**
     * * uri convert to file real path, don't support custom FileProvider
     *     * @param context context
     *     * @param uri uri
     *     * @return path
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFileRealPath(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.net.Uri uri) {
        return null;
    }
    
    /**
     * * forceGetFileUri
     *     * @param shareFile shareFile
     *     * @return Uri
     */
    private final android.net.Uri forceGetFileUri(java.io.File shareFile) {
        return null;
    }
    
    /**
     * * getFileContentUri
     *     * @param context context
     *     * @param file file
     *     * @return Uri
     */
    private final android.net.Uri getFileContentUri(android.content.Context context, java.io.File file) {
        return null;
    }
    
    /**
     * * Gets the content:// URI from the given corresponding path to a file
     *     *
     *     * @param context context
     *     * @param imageFile imageFile
     *     * @return content Uri
     */
    private final android.net.Uri getImageContentUri(android.content.Context context, java.io.File imageFile) {
        return null;
    }
    
    /**
     * * Gets the content:// URI from the given corresponding path to a file
     *     *
     *     * @param context context
     *     * @param videoFile videoFile
     *     * @return content Uri
     */
    private final android.net.Uri getVideoContentUri(android.content.Context context, java.io.File videoFile) {
        return null;
    }
    
    /**
     * * Gets the content:// URI from the given corresponding path to a file
     *     *
     *     * @param context context
     *     * @param audioFile audioFile
     *     * @return content Uri
     */
    private final android.net.Uri getAudioContentUri(android.content.Context context, java.io.File audioFile) {
        return null;
    }
    
    /**
     * * @param uri The Uri to check.
     *     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    private final boolean isExternalStorageDocument(android.net.Uri uri) {
        return false;
    }
    
    /**
     * * @param uri The Uri to check.
     *     * @return Whether the Uri authority is DownloadsProvider.
     */
    private final boolean isDownloadsDocument(android.net.Uri uri) {
        return false;
    }
    
    /**
     * * @param uri The Uri to check.
     *     * @return Whether the Uri authority is MediaProvider.
     */
    private final boolean isMediaDocument(android.net.Uri uri) {
        return false;
    }
    
    /**
     * * Get the value of the data column for this Uri. This is useful for
     *     * MediaStore Uris, and other file-based ContentProviders.
     *     *
     *     * @param context
     *     * The context.
     *     * @param uri
     *     * The Uri to query.
     *     * @param selection
     *     * (Optional) Filter used in the query.
     *     * @param selectionArgs
     *     * (Optional) Selection arguments used in the query.
     *     * @return The value of the _data column, which is typically a file path.
     */
    private final java.lang.String getDataColumn(android.content.Context context, android.net.Uri uri, java.lang.String selection, java.lang.String[] selectionArgs) {
        return null;
    }
    
    /**
     * * 获取分享路径
     */
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getShareFileUri(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return null;
    }
    
    private FileUtil() {
        super();
    }
}