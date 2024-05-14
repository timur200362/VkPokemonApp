package com.example.vkpokemonapp.domain.repository

import com.example.vkpokemonapp.data.memory.Result
import com.example.vkpokemonapp.data.remote.ApiService
import com.example.vkpokemonapp.data.remote.response.PokemonDetailResponse
import com.example.vkpokemonapp.data.remote.response.PokemonFormResponse
import com.example.vkpokemonapp.data.repository.PokemonsRepository

class PokemonsRepositoryImpl(
    private val apiService: ApiService
) : PokemonsRepository {
    override suspend fun getPokemons(offset: Int, limit: Int): List<Result> {
        return apiService.loadPokemons(offset, limit).results
    }

    override suspend fun getPokemonDetail(pokemonName: String): PokemonDetailResponse {
        return apiService.loadPokemonDetail(pokemonName)
    }

    override suspend fun getPokemonPicture(pictureUrl: String): PokemonFormResponse {
        return apiService.loadPokemonForm(pictureUrl)
    }
}