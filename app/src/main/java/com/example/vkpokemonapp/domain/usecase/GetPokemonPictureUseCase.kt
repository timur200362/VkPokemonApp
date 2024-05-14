package com.example.vkpokemonapp.domain.usecase

import com.example.vkpokemonapp.data.remote.response.PokemonFormResponse
import com.example.vkpokemonapp.data.repository.PokemonsRepository

class GetPokemonPictureUseCase(
    private val pokemonsRepository: PokemonsRepository
) {
    suspend fun execute(pictureUrl: String): PokemonFormResponse {
        return pokemonsRepository.getPokemonPicture(pictureUrl)
    }
}