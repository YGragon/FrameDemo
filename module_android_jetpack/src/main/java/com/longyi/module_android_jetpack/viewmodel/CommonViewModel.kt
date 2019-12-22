package com.example.uitestdemo.viewmodel

import androidx.lifecycle.ViewModel

class CommonViewModel : ViewModel() {
    private val mCommonLivaData = CommonLivaData()

    fun getCommonLivaData(): CommonLivaData {
        return mCommonLivaData
    }


    override fun onCleared() {
        super.onCleared()
    }
}