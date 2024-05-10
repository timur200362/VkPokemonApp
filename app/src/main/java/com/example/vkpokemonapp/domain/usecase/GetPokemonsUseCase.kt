package com.example.vkpokemonapp.domain.usecase

import com.example.vkpokemonapp.data.memory.Result
import com.example.vkpokemonapp.data.repository.PokemonsRepository

private const val limit = 20;

class GetPokemonsUseCase(
    private val pokemonsRepository: PokemonsRepository
) {
    suspend fun execute(): List<Result> {
        return pokemonsRepository.getPokemons(limit, limit)
    }
}