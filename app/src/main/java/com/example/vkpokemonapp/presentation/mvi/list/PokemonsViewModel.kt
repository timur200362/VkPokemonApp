package com.example.vkpokemonapp.presentation.mvi.list

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.vkpokemonapp.domain.usecase.GetPokemonsUseCase
import com.example.vkpokemonapp.mviRealisation.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonsViewModel(
    getPokemonsUseCase: GetPokemonsUseCase
) : BaseViewModel<PokemonsScreenState, PokemonsScreenUiEvent>() {

    private val reducer: PokemonsReducer = PokemonsReducer(
        PokemonsScreenState.initial(),
        getPokemonsUseCase
    )

    init {
        getPokemons()
    }

    override val state: StateFlow<PokemonsScreenState>
        get() = reducer.state

    private fun sendEvent(event: PokemonsScreenUiEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                reducer.sendEvent(event)
            } catch (throwable: Throwable) {
                println("Произошла ошибка!")
                Log.e("PokemonsVM", "Ошибка:$throwable")
            }
        }
    }

    private fun getPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                sendEvent(PokemonsScreenUiEvent.GetPokemons)
            } catch (throwable: Throwable) {
                println("Произошла ошибка при загрузке покемонов!")
                Log.e("PokemonsVM", "Ошибка:$throwable")
            }
        }
    }
}