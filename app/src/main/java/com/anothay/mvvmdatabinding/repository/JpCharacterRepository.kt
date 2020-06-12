package com.anothay.mvvmdatabinding.repository

import com.anothay.mvvmdatabinding.data.api.CharacterApiService
import com.anothay.mvvmdatabinding.data.api.OnResult
import com.anothay.mvvmdatabinding.data.config.RetrofitRequest
import com.anothay.mvvmdatabinding.model.JpCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JpCharacterRepository(val characterApiService: CharacterApiService) {
    fun getJpCharacters(onResult: OnResult<List<JpCharacter>>) {
        onResult.onLoading()
        characterApiService.getCharactersJp().enqueue(object : Callback<List<JpCharacter>> {
            override fun onFailure(call: Call<List<JpCharacter>>, t: Throwable) {
                onResult.onFailed(t.localizedMessage ?: "Null error")
            }
            override fun onResponse(
                call: Call<List<JpCharacter>>,
                response: Response<List<JpCharacter>>
            ) {
               response.body()?.let {
                   onResult.onSuccess(it)
               } ?: run {
                   onResult.onEmpty()
               }
            }
        })
    }

    companion object {
        private var INSTANCE: JpCharacterRepository? = null
        private var _characterApiService: CharacterApiService =
            RetrofitRequest.instance.create(CharacterApiService::class.java)

        fun getInstance() = INSTANCE ?: JpCharacterRepository(_characterApiService).also {
            INSTANCE = it
        }
    }
}