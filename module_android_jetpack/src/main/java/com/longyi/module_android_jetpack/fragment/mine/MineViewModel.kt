package com.longyi.module_android_jetpack.fragment.mine

import androidx.lifecycle.MutableLiveData
import com.example.lib_common.base.BaseViewModel
import com.example.lib_common.http.runRxLambdaViewModel
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit


class MineViewModel : BaseViewModel() {
    private val TAG = MineViewModel::class.java.simpleName
    private val periodTime = 1000L
    private val mElapsedRealTime = MutableLiveData<Long>()
    private var mInitialTime: Long = 0

    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    // Create a LiveData with a Long
    val countDownTime: MutableLiveData<Long> by lazy {
        mElapsedRealTime
    }

    /**
     * 开启倒计时
     */
    fun getTime(){
//        mInitialTime = SystemClock.elapsedRealtime()
//        val timer = Timer()
//        val timeTask = object : TimerTask() {
//            override fun run() {
//                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
//                if (newValue < 10){
//                    mElapsedRealTime.postValue(newValue)
//                }else{
//                    timer.cancel()
//                }
//            }
//        }
//        timer.scheduleAtFixedRate(timeTask,periodTime,periodTime)

        // 只处理成功，失败的可以处理可以不处理
        runRxLambdaViewModel(this,Observable.timer(10,TimeUnit.SECONDS),{
            mElapsedRealTime.postValue(it)
        })
    }
}
