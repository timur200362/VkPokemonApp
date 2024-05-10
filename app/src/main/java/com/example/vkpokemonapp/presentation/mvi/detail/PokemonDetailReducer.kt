package com.example.vkpokemonapp.presentation.mvi.detail

import com.example.vkpokemonapp.domain.usecase.GetPokemonDetailUseCase
import com.example.vkpokemonapp.mviRealisation.Reducer

class PokemonDetailReducer(
    initial: PokemonDetailState,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
): Reducer<PokemonDetailState, PokemonDetailUiEvent>(initial) {

    override suspend fun reduce(
        currentState: PokemonDetailState,
        event: PokemonDetailUiEvent
    ) {
        when (event) {
            is PokemonDetailUiEvent.GetPokemonDetail -> {
                val pokemon = getPokemonDetailUseCase.execute(event.pokemonName)
                setState(currentState.copy(pokemon))
            }
        }
    }
}