package com.example.vkpokemonapp.presentation.mvi.detail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.vkpokemonapp.domain.usecase.GetPokemonDetailUseCase
import com.example.vkpokemonapp.domain.usecase.GetPokemonsUseCase
import com.example.vkpokemonapp.mviRealisation.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    getPokemonDetailUseCase: GetPokemonDetailUseCase
) : BaseViewModel<PokemonDetailState, PokemonDetailUiEvent>() {

    private val reducer: PokemonDetailReducer = PokemonDetailReducer(
        PokemonDetailState.initial(),
        getPokemonDetailUseCase
    )

    override val state: StateFlow<PokemonDetailState>
        get() = reducer.state



    fun getPokemonDetail(pokemonName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                reducer.sendEvent(PokemonDetailUiEvent.GetPokemonDetail(pokemonName))
            } catch (throwable: Throwable) {
                println("Произошла ошибка при загрузке дет. экрана покемона!")
                Log.e("PokemonDetailVM", "Ошибка:$throwable")
            }
        }
    }
}