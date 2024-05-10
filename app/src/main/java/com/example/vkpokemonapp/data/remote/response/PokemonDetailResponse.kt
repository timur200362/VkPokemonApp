package com.example.vkpokemonapp.data.remote.response


import com.example.vkpokemonapp.data.memory.Form
import com.example.vkpokemonapp.data.memory.Type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetailResponse(
    @SerialName("forms")
    val forms: List<Form>,
    @SerialName("height")
    val height: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("types")
    val types: List<Type>,
    @SerialName("weight")
    val weight: Int
)