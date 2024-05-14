package com.example.vkpokemonapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.vkpokemonapp.R
import com.example.vkpokemonapp.presentation.mvi.detail.PokemonDetailViewModel
import com.example.vkpokemonapp.presentation.mvi.picture.PokemonPictureViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetailScreen(pokemonName: String) {
    DisplayDetailInfo(pokemonName)
}

@Composable
fun DisplayDetailInfo(
    pokemonName: String,
    detailViewModel: PokemonDetailViewModel = koinViewModel(),
    pictureViewModel: PokemonPictureViewModel = koinViewModel()
) {
    val state by detailViewModel.state.collectAsStateWithLifecycle()
    val pictureState by pictureViewModel.state.collectAsStateWithLifecycle()

    val pokemon = state.pokemon

    detailViewModel.getPokemonDetail(pokemonName)


    if (pokemon != null) {
        pictureViewModel.getPokemonPicture(pokemon.forms[0].url)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.pokemon),
                    contentScale = ContentScale.Crop
                )
        ){
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Покемон: ${pokemon.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .padding(bottom = 20.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp
                )
                AsyncImage(
                    model = pictureState.pictureUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(260.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 20.dp),
                )
                Text(
                    text = "Вес: ${pokemon.weight}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 340.dp)
                        .padding(bottom = 20.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp
                )
                Text(
                    text = "Рост: ${pokemon.height}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .padding(bottom = 20.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp
                )
            }
        }
    }
}