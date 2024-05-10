package com.example.vkpokemonapp.data.memory


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeX(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)