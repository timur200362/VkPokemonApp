package com.example.vkpokemonapp.data.memory


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    @SerialName("back_default")
    val back_default: String?,
    @SerialName("back_female")
    val back_female: String?,
    @SerialName("back_shiny")
    val back_shiny: String?,
    @SerialName("back_shiny_female")
    val back_shiny_female: String?,
    @SerialName("front_default")
    val front_default: String?,
    @SerialName("front_female")
    val front_female: String?,
    @SerialName("front_shiny")
    val front_shiny: String?,
    @SerialName("front_shiny_female")
    val front_shiny_female: String?
)