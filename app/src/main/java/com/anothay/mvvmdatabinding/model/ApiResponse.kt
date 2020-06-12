package com.anothay.mvvmdatabinding.model

data class JpType (
    val id: Int, val name: String
)

data class JpCharacter (
    val id: Int,
    val japan: String,
    val romaji: String,
    val wordJp: String,
    val wordRomaji: String,
    val urlImage: String,
    val jpType: JpType
)