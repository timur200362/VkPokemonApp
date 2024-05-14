package com.example.vkpokemonapp.presentation.mvi.list

import com.example.vkpokemonapp.domain.usecase.GetPokemonDetailUseCase
import com.example.vkpokemonapp.domain.usecase.GetPokemonPictureUseCase
import com.example.vkpokemonapp.domain.usecase.GetPokemonsUseCase
import com.example.vkpokemonapp.mviRealisation.Reducer

class PokemonsReducer(
    initial: PokemonsScreenState,
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val getPokemonPictureUseCase: GetPokemonPictureUseCase
): Reducer<PokemonsScreenState, PokemonsScreenUiEvent>(initial) {

    override suspend fun reduce(
        currentState: PokemonsScreenState,
        event: PokemonsScreenUiEvent
    ) {
        when (event) {
            is PokemonsScreenUiEvent.GetPokemons -> {
                val pokemonsList = getPokemonsUseCase.execute()
                for (i in pokemonsList) {
                    val responseUrl = getPokemonDetailUseCase.execute(i.name)
                    val pictureResponse = getPokemonPictureUseCase.execute(responseUrl.forms[0].url)
                    i.pictureUrl = pictureResponse.sprites.back_default
                    setState(currentState.copy(pokemonsList=pokemonsList))
                }
            }
        }
    }
}