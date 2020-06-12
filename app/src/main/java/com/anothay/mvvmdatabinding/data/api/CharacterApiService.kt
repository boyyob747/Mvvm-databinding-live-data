package com.anothay.mvvmdatabinding.data.api

import com.anothay.mvvmdatabinding.data.config.ApiConfig
import com.anothay.mvvmdatabinding.model.JpCharacter
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService {
    @GET(ApiConfig.GET_CHARACTERS)
    fun getCharactersJp() : Call<List<JpCharacter>>
}