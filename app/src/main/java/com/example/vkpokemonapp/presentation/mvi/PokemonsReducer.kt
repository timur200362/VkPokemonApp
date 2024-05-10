package com.example.vkpokemonapp.presentation.mvi

import com.example.vkpokemonapp.domain.usecase.GetPokemonsUseCase
import com.example.vkpokemonapp.mviRealisation.Reducer

class PokemonsReducer(
    initial: PokemonsScreenState,
    private val getPokemonsUseCase: GetPokemonsUseCase
): Reducer<PokemonsScreenState, PokemonsScreenUiEvent>(initial) {

    override suspend fun reduce(
        currentState: PokemonsScreenState,
        event: PokemonsScreenUiEvent
    ) {
        when (event) {
            is PokemonsScreenUiEvent.GetPokemons -> {
                val pokemonsList = getPokemonsUseCase.execute()
                setState(currentState.copy(pokemonsList=pokemonsList))
            }
        }
    }
}