package com.longyi.lib_download.file_download

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message

/**
 * Created by Aller on 2019/7/24.
 */
class DownloadHandler {
    // handle ,处理ui方面的onProgress
    private var mHandler: Handler? = null

    private val WHAT_UPDATE = 0x01 // 更新进度
    private val PROGRESS = "progress"

    private var mDownloadListener: DownloadListener? = null

    /**
     * 初始化handler
     */
    fun initHandler(downloadListener: DownloadListener) {
        if (mHandler != null) {
            return
        }
        mDownloadListener = downloadListener
        // 同步锁此类
        synchronized(DownloadHandler::class.java) {
            if (mHandler == null) {
                mHandler = object : Handler(Looper.getMainLooper()) {
                    override fun handleMessage(msg: Message?) {
                        super.handleMessage(msg)
                        if (msg == null) {
                            return
                        }
                        when (msg.what) {
                            WHAT_UPDATE -> {
                                val updateData = msg.data ?: return
                                val progress = updateData.getInt(PROGRESS)
                                downloadListener.onProgress(progress)
                            }
                            else -> {
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 传递进度给ui
     * @param progress 进度，100为满
     */
    fun onProgress(progress: Int) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mDownloadListener!!.onProgress(progress)
            return
        }
        val message = mHandler!!.obtainMessage()
        message.what = WHAT_UPDATE
        val data = Bundle()
        data.putInt(PROGRESS, progress)
        message.data = data
        mHandler!!.sendMessage(message)
    }
}