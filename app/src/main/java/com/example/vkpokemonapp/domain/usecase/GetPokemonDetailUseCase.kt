package com.example.vkpokemonapp.domain.usecase

import com.example.vkpokemonapp.data.remote.response.PokemonDetailResponse
import com.example.vkpokemonapp.data.repository.PokemonsRepository

class GetPokemonDetailUseCase(
    private val pokemonsRepository: PokemonsRepository
) {
    suspend fun execute(pokemonName: String): PokemonDetailResponse{
        return pokemonsRepository.getPokemonDetail(pokemonName)
    }
}