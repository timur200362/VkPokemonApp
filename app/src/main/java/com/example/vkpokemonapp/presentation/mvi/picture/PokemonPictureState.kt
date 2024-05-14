package com.example.vkpokemonapp.presentation.mvi.picture

import com.example.vkpokemonapp.mviRealisation.UiState

data class PokemonPictureState(
    val pictureUrl: String?
) : UiState {
    companion object {
        fun initial() = PokemonPictureState(
            pictureUrl = ""
        )
    }
}