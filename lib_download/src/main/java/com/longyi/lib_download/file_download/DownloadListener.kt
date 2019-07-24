package com.longyi.lib_download.file_download

import java.io.File

/**
 * 下载进度回调
 */
interface DownloadListener {
    abstract fun onStartDownload()

    abstract fun onProgress(progress: Int)

    abstract fun onFinishDownload(file: File)

    abstract fun onFail(ex: Throwable)
}