package com.longyi.lib_download.file_download

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * 下载文件的url接口
 */
interface DownloadService {
    /**
     * 下载文件
     */
    @Streaming
    @GET
    fun download(@Url url: String): Observable<ResponseBody> //直接使用网址下载
}