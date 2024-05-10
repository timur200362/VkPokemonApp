package com.example.vkpokemonapp.presentation.mvi

import com.example.vkpokemonapp.mviRealisation.UiEvent

sealed class PokemonsScreenUiEvent : UiEvent {
    data object GetPokemons : PokemonsScreenUiEvent()
}