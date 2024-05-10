package com.example.vkpokemonapp.presentation.mvi.detail

import com.example.vkpokemonapp.data.remote.response.PokemonDetailResponse
import com.example.vkpokemonapp.mviRealisation.UiState

data class PokemonDetailState(
    val pokemon: PokemonDetailResponse?
) : UiState {
    companion object {
        fun initial() = PokemonDetailState(
            pokemon = null
        )
    }
}