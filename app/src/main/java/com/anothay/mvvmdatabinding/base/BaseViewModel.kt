package com.anothay.mvvmdatabinding.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val dataLoading = MutableLiveData<Boolean>()
    val emptyData = MutableLiveData<Boolean>()
    val failedData = MutableLiveData<String>()
}