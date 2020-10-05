package com.longyi.lib_download.file_download

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.concurrent.TimeUnit

/**
 * 文件下载工具
 */
class DownloadHelper {
    // 超时15s
    private val DEFAULT_TIMEOUT = 30
    // 网络工具retrofit
    private lateinit var retrofit: Retrofit
    // 下载进度、完成、失败等的回调事件
    private lateinit var mDownloadListener: DownloadListener
    // 清除线程需要用到的
    private var disposable: Disposable? = null

    /**
     * 构造函数初始化
     *
     * @param baseUrl  基础 url，必须以"/"结尾
     * @param listener 回调函数
     */
    constructor(baseUrl: String, listener: DownloadListener){
        this.mDownloadListener = listener
        val mInterceptor = DownloadInterceptor(listener)
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(mInterceptor)
            .retryOnConnectionFailure(true)
            .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }


    /**
     * 进行文件下载
     * @param url 网址
     * @param destDir 文件存储目录
     * @param fileName 文件名称
     */
    fun downloadFile(url: String, destDir: String, fileName: String) {
        dispose()
        mDownloadListener.onStartDownload()
        retrofit.create(DownloadService::class.java)
            .download(url)
            .subscribeOn(Schedulers.io())//请求网络 在调度者的io线程
            .observeOn(Schedulers.io()) //指定线程保存文件
            .observeOn(Schedulers.computation())
            .map { responseBody ->
                saveFile(
                    responseBody.byteStream(),
                    destDir,
                    fileName
                )
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseDownloadObserver<File>() {
                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onDownloadSuccess(file: File) {
                    mDownloadListener.onFinishDownload(file)
                }

                override fun onDownloadError(e: Throwable) {
                    mDownloadListener.onFail(e)
                }
            })
    }

    /**
     * 销毁
     */
    private fun dispose() {
        if (disposable != null && !disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }

    /**
     * 将文件写入本地
     *
     * @param destFileDir  目标文件夹
     * @param destFileName 目标文件名
     * @return 写入完成的文件
     * @throws IOException IO异常
     */
    private fun saveFile(inputStream: InputStream, destFileDir: String, destFileName: String): File {
        val buf = ByteArray(2048)
        var len: Int
        var fos: FileOutputStream? = null
        try {
            val dir = File(destFileDir)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            val file = File(dir, destFileName)
            if (file.exists()) {
                file.delete()
            }
            fos = FileOutputStream(file)
            while (((inputStream.read(buf)).also { len = it }) != -1){
                fos.write(buf, 0, len)
            }
            fos.flush()
            return file

        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            try {
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }
}