package com.longyi.module_android_jetpack.fragment.mine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.os.SystemClock
import autodispose2.AutoDispose.autoDisposable
import com.example.lib_common.http.runRx
import com.example.lib_common.http.runRxLambda
import com.longyi.module_android_jetpack.viewmodel.BaseViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit


class MineViewModel : BaseViewModel() {
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

        runRxLambda(Observable.timer(10,TimeUnit.SECONDS),{
            mElapsedRealTime.postValue(it)
        },{},{})

    }
}
