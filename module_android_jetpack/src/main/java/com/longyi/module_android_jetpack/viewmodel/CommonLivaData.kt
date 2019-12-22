package com.example.uitestdemo.viewmodel

import androidx.lifecycle.LiveData


class CommonLivaData: LiveData<CommonLivaData>() {
    private var tag1: Int = 0
    private var tag2: Int = 0

    fun getTag1(): Int {
        return tag1

    }

    fun setTag1(tag1: Int) {
        this.tag1 = tag1
        postValue(this)
    }

    fun getTag2(): Int {
        return tag2
    }

    fun setTag2(tag2: Int) {
        this.tag2 = tag2
        postValue(this)
    }

}