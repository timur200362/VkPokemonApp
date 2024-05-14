package com.example.vkpokemonapp.data.remote.response


import com.example.vkpokemonapp.data.memory.Pokemon
import com.example.vkpokemonapp.data.memory.Sprites
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonFormResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("pokemon")
    val pokemon: Pokemon,
    @SerialName("sprites")
    val sprites: Sprites,
)