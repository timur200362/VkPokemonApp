package com.example.vkpokemonapp.presentation.mvi.list

import com.example.vkpokemonapp.data.memory.Result
import com.example.vkpokemonapp.mviRealisation.UiState

data class PokemonsScreenState(
    val pokemonsList: List<Result>
) : UiState {
    companion object {
        fun initial() = PokemonsScreenState(
            pokemonsList = listOf()
        )
    }
}