package com.example.vkpokemonapp.data.remote.response


import com.example.vkpokemonapp.data.memory.Result
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonsResponse(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: String,
    @SerialName("results")
    val results: List<Result>
)