package com.example.vkpokemonapp.presentation.mvi.picture

import com.example.vkpokemonapp.domain.usecase.GetPokemonPictureUseCase
import com.example.vkpokemonapp.mviRealisation.Reducer

class PokemonPictureReducer(
    initial: PokemonPictureState,
    private val getPokemonPictureUseCase: GetPokemonPictureUseCase
): Reducer<PokemonPictureState, PokemonPictureUiEvent>(initial) {

    override suspend fun reduce(
        currentState: PokemonPictureState,
        event: PokemonPictureUiEvent
    ) {
        when (event) {
            is PokemonPictureUiEvent.GetPokemonPicture -> {
                val pictureResponse = getPokemonPictureUseCase.execute(event.pictureUrl)
                setState(currentState.copy(pictureResponse.sprites.back_default))
            }
        }
    }
}