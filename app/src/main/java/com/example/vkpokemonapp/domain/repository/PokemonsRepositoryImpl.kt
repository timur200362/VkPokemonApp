package com.example.vkpokemonapp.domain.repository

import com.example.vkpokemonapp.data.memory.Result
import com.example.vkpokemonapp.data.remote.ApiService
import com.example.vkpokemonapp.data.repository.PokemonsRepository

class PokemonsRepositoryImpl(
    private val apiService: ApiService
) : PokemonsRepository {
    override suspend fun getPokemons(offset: Int, limit: Int): List<Result> {
        return apiService.loadPokemons(offset, limit).results
    }
}