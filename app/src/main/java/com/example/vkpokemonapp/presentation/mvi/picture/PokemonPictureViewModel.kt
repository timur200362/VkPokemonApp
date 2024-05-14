package com.example.vkpokemonapp.presentation.mvi.picture

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.vkpokemonapp.domain.usecase.GetPokemonPictureUseCase
import com.example.vkpokemonapp.mviRealisation.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonPictureViewModel(
    getPokemonPictureUseCase: GetPokemonPictureUseCase
) : BaseViewModel<PokemonPictureState, PokemonPictureUiEvent>() {

    private val reducer: PokemonPictureReducer = PokemonPictureReducer(
        PokemonPictureState.initial(),
        getPokemonPictureUseCase
    )

    override val state: StateFlow<PokemonPictureState>
        get() = reducer.state



    fun getPokemonPicture(pictureUrl: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                reducer.sendEvent(PokemonPictureUiEvent.GetPokemonPicture(pictureUrl))
            } catch (throwable: Throwable) {
                println("Произошла ошибка при загрузке картинки покемона!")
                Log.e("PokemonDetailVM", "Ошибка:$throwable")
            }
        }
    }
}