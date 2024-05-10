package com.example.vkpokemonapp.data.repository

import com.example.vkpokemonapp.data.memory.Result

interface PokemonsRepository {
    suspend fun getPokemons(offset: Int, limit: Int): List<Result>
}