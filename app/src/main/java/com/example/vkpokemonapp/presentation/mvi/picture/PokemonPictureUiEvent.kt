package com.example.vkpokemonapp.presentation.mvi.picture

import com.example.vkpokemonapp.mviRealisation.UiEvent

sealed class PokemonPictureUiEvent : UiEvent {
    data class GetPokemonPicture(val pictureUrl: String) : PokemonPictureUiEvent()
}