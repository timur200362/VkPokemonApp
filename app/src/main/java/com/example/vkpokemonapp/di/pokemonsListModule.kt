package com.example.vkpokemonapp.di

import com.example.vkpokemonapp.data.remote.ApiFactory
import com.example.vkpokemonapp.data.remote.ApiService
import com.example.vkpokemonapp.data.repository.PokemonsRepository
import com.example.vkpokemonapp.domain.repository.PokemonsRepositoryImpl
import com.example.vkpokemonapp.domain.usecase.GetPokemonsUseCase
import com.example.vkpokemonapp.presentation.mvi.PokemonsViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val pokemonsListModule = module {
    single<ApiService> { ApiFactory().pokemonsApi }
    single<PokemonsRepository> { PokemonsRepositoryImpl(get()) }
    factory<GetPokemonsUseCase> { GetPokemonsUseCase(get()) }
    viewModel<PokemonsViewModel> {
        PokemonsViewModel(
            get()
        )
    }
}