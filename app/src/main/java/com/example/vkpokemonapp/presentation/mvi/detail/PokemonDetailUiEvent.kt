package com.example.vkpokemonapp.presentation.mvi.detail

import com.example.vkpokemonapp.mviRealisation.UiEvent

sealed class PokemonDetailUiEvent : UiEvent {
    data class GetPokemonDetail(val pokemonName: String) : PokemonDetailUiEvent()
}