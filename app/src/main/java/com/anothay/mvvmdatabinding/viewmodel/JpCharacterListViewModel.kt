package com.anothay.mvvmdatabinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anothay.mvvmdatabinding.base.BaseViewModel
import com.anothay.mvvmdatabinding.data.api.OnResult
import com.anothay.mvvmdatabinding.model.JpCharacter
import com.anothay.mvvmdatabinding.repository.JpCharacterRepository

class JpCharacterListViewModel(private val jpCharacterRepository: JpCharacterRepository = JpCharacterRepository.getInstance()) : BaseViewModel() {
    val jpCharacterList = MutableLiveData<List<JpCharacter>>()
    val jpCharacterClicked = MutableLiveData<JpCharacter>()
    fun onCharacterClick() {
        //TODO:
    }
    fun fetchJpCharacterList() {
        jpCharacterRepository.getJpCharacters(object : OnResult<List<JpCharacter>> {
            override fun onSuccess(response: List<JpCharacter>) {
                dataLoading.value = false
                jpCharacterList.value = response
            }

            override fun onLoading() {
                dataLoading.value = true
            }

            override fun onFailed(message: String) {
                dataLoading.value = false
                failedData.value = message
            }

            override fun onEmpty() {
                dataLoading.value = false
                emptyData.value = true
            }

        })
    }
}