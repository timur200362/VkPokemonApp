package com.example.vkpokemonapp.presentation.mvi.list

import com.example.vkpokemonapp.mviRealisation.UiEvent

sealed class PokemonsScreenUiEvent : UiEvent {
    data object GetPokemons : PokemonsScreenUiEvent()
}