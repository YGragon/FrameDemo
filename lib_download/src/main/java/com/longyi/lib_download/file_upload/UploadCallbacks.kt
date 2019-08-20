package com.longyi.lib_download.file_upload

/**
 * 上传文件回调
 */
interface UploadCallbacks {
    fun onProgressUpdate(percentage: Int)

    fun onError()

    fun onFinish()
}