package com.longyi.lib_download.file_download

import android.util.Log
import androidx.annotation.NonNull
import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.*
import java.io.IOException

/**
 * 处理返回数据
 */
class DownloadResponseBody() : ResponseBody() {
    private lateinit var responseBody: ResponseBody

    private lateinit var mDownloadListener: DownloadListener
    private var mDownloadHandler = DownloadHandler()

    // BufferedSource 是okio库中的输入流，这里就当作inputStream来使用。
    private var bufferedSource: BufferedSource? = null


    constructor(responseBody: ResponseBody, mDownloadListener: DownloadListener) : this() {
        this.responseBody = responseBody
        this.mDownloadListener = mDownloadListener
        this.mDownloadHandler.initHandler(mDownloadListener)
    }

    override fun contentType(): MediaType? {
        return responseBody.contentType()
    }

    override fun contentLength(): Long {
        return responseBody.contentLength()
    }

    override fun source(): BufferedSource {
        if (bufferedSource == null) {
            bufferedSource = source(responseBody.source()).buffer()
        }
        return bufferedSource as BufferedSource
    }

    /**
     * 处理数据
     * @param source 数据源
     * @return 返回处理后的数据源
     */
    private fun source(source: Source): Source {
        return object : ForwardingSource(source) {
            internal var totalBytesRead = 0L

            @Throws(IOException::class)
            override fun read(@NonNull sink: Buffer, byteCount: Long): Long {
                val bytesRead = super.read(sink, byteCount)
                // read() returns the number of bytes read, or -1 if this source is exhausted.
                totalBytesRead += if (bytesRead.toInt() != -1) bytesRead else 0
                Log.e("download", "read: " + (totalBytesRead * 100 / responseBody.contentLength()).toInt())
                if (null != mDownloadListener) {
                    if (bytesRead.toInt() != -1) {
                        // 回调进度ui
                        mDownloadHandler.onProgress((totalBytesRead * 100 / responseBody.contentLength()).toInt())
                    }

                }
                return bytesRead
            }
        }

    }
}