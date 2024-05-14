package com.example.vkpokemonapp.data.remote

import com.example.vkpokemonapp.data.remote.response.PokemonDetailResponse
import com.example.vkpokemonapp.data.remote.response.PokemonFormResponse
import com.example.vkpokemonapp.data.remote.response.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("pokemon")
    suspend fun loadPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonsResponse

    @GET("pokemon/{pokemonName}")
    suspend fun loadPokemonDetail(
        @Path("pokemonName") pokemonName: String
    ): PokemonDetailResponse

    @GET
    suspend fun loadPokemonForm(@Url pictureUrl: String): PokemonFormResponse
}