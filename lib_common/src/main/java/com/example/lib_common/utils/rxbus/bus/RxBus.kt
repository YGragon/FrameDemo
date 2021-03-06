package com.example.lib_common.utils.rxbus.bus

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

/**
 * 使用 RxJava 封装的事件总线：只需要关心发送、接收

1. 发送数据
RxBus.postSticky("imagesInfo",ImageEvent(position,mPage,mCount,mList))

2. 接收数据
RxBus.receiveSticky(this,"imagesInfo",object :RxBusReceiver<Any>(){
    override fun receive(data: Any) {
        val imageInfo = data as ImageEvent
        mCount = imageInfo.count
        mPage = imageInfo.page
    }
})
 */
object RxBus {
    /**
     * @param tag
     * @param event
     * 发送普通事件
     */
    fun post(tag: String, event: Any) {
        RxSimpleBus.sendMessage(RxBusMessage(tag, event))
    }

    /**
     * 普通接收
     * @param filter
     * @param receiver
     * @return
     */
    private fun receive(filter: String, receiver: RxBusReceiver<Any>): Disposable {
        return RxSimpleBus.receiveMessageFrom(filter, receiver)
    }

    /**
     * 发送粘性事件
     * @param tag
     * @param event
     */
    fun postSticky(tag: String, event: Any) {
        RxSimpleBus.sendStickyMessage(RxBusMessage(tag, event))
    }

    /**
     * 需要手动取消 dispose 否则容易内存泄露
     * @param filter
     * @param receiver
     * @return
     */
    private fun receiveSticky(filter: String, receiver: RxBusReceiver<Any>): Disposable {
        receiver.setCurFilter(filter)
        return RxSimpleBus.receiveStickyMessage(filter, receiver)
    }

    /**
     * 接受普通事件
     * 自动取消注册
     * @param fragment
     * @param filter
     * @param receiver
     */
    fun receive(fragment: Fragment, filter: String, receiver: RxBusReceiver<Any>) {
        val disposable = receive(filter, receiver)
        val fragment1 = HolderLifeFragment().holderFragmentFor(fragment)
        setDispose(fragment1, disposable)
    }

    /**
     * 接受普通事件
     * 自动取消注册
     * @param activity
     * @param filter
     * @param receiver
     */
    fun receive(activity: FragmentActivity, filter: String, receiver: RxBusReceiver<Any>) {
        val disposable = receive(filter, receiver)
        val fragment1 = HolderLifeFragment().holderFragmentFor(activity)
        setDispose(fragment1, disposable)
    }

    /**
     * 接受粘性事件
     * 自动取消注册
     * @param fragment
     * @param filter
     * @param receiver
     */
    fun receiveSticky(fragment: Fragment, filter: String, receiver: RxBusReceiver<Any>) {
        val disposable = receiveSticky(filter, receiver)
        val fragment1 = HolderLifeFragment().holderFragmentFor(fragment)
        setDispose(fragment1, disposable)
    }

    /**
     *
     * @param activity
     * @param filter
     * @param receiver
     */
    fun receiveSticky(activity: FragmentActivity, filter: String, receiver: RxBusReceiver<Any>) {
        val disposable = receiveSticky(filter, receiver)
        val fragment1 = HolderLifeFragment().holderFragmentFor(activity)
        setDispose(fragment1, disposable)
    }

    private fun setDispose(fragment: HolderLifeFragment?, disposable: Disposable) {
        fragment?.setDispose(disposable)
    }
}