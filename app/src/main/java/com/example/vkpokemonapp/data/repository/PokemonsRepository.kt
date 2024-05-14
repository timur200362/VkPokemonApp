package com.example.vkpokemonapp.data.repository

import com.example.vkpokemonapp.data.memory.Result
import com.example.vkpokemonapp.data.remote.response.PokemonDetailResponse
import com.example.vkpokemonapp.data.remote.response.PokemonFormResponse

interface PokemonsRepository {
    suspend fun getPokemons(offset: Int, limit: Int): List<Result>
    suspend fun getPokemonDetail(pokemonName: String): PokemonDetailResponse
    suspend fun getPokemonPicture(pictureUrl: String): PokemonFormResponse
}