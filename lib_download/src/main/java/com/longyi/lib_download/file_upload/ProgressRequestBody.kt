package com.longyi.lib_download.file_upload

import android.os.Handler
import android.os.Looper
import com.example.lib_common.constant.ParameterConstant.GankPhoto.count
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSink
import okio.BufferedSource
import java.io.File
import java.io.FileInputStream

/**
 * Created by Aller on 2019/8/20.
 */
class ProgressRequestBody(file:File, mediaType:String, listener:UploadCallbacks): RequestBody() {
    private var mFile: File = file
    private var mPath = ""
    private var mMediaType = ""
    private var mListener:UploadCallbacks

    private var mEachBufferSize = 1024.toByte()




   init {
       mMediaType = mediaType
       mListener = listener
   }


    inner class ProgressUpdater(uploaded:Long, total:Long): Runnable {
        override fun run() {

            mListener.onProgressUpdate( (100 * mUploaded / mTotal).toInt())
        }
        private var mUploaded = 0L
        private var mTotal = 0L

        init {
            mUploaded = uploaded
            mTotal = total
        }
    }
    override fun contentType(): MediaType? {
        // i want to upload only images
        return mMediaType.toMediaTypeOrNull()
    }

    override fun writeTo(sink: BufferedSink) {
        if (sink is Buffer) {
            return
        }
        val fileLength = mFile.length()
        val buffer = byteArrayOf(mEachBufferSize)
        val fin = FileInputStream(mFile)
        var uploaded = 0L


        try {
            var read = 0
            val handler = Handler(Looper.getMainLooper())
            while ({ read = fin.read(buffer);read }() > 0) {
                // update progress on UI thread
                handler.post(ProgressUpdater(uploaded, fileLength))
                uploaded += read
                sink.write(buffer, 0, read)
            }
        } finally {
            fin.close()
        }
    }

}