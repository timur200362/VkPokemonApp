package com.example.vkpokemonapp.data.remote

import com.example.vkpokemonapp.data.memory.Result
import com.example.vkpokemonapp.data.remote.response.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    suspend fun loadPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonsResponse
}