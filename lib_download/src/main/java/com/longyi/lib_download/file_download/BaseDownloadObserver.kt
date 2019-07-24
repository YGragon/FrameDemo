package com.longyi.lib_download.file_download

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 用于只暴露下载 success 和 error
 */
abstract class BaseDownloadObserver<T> : Observer<T> {
    abstract override fun onSubscribe(d: Disposable)

    override fun onNext(t: T) {
        onDownloadSuccess(t)
    }

    override fun onError(e: Throwable) {
        onDownloadError(e)
    }

    override fun onComplete() {

    }

    protected abstract fun onDownloadSuccess(t: T)

    protected abstract fun onDownloadError(e: Throwable)
}