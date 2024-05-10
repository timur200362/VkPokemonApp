package com.example.vkpokemonapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.example.vkpokemonapp.R
import com.example.vkpokemonapp.presentation.mvi.list.PokemonsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            PokemonsListScreen(
                onNavigateToDetail = { pokemonName ->
                    navController.navigate("detail/$pokemonName")
                }
            )
        }
        composable(
            "detail/{pokemonName}",
            arguments = listOf(navArgument("pokemonName") { defaultValue = "" })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("pokemonName")?.let { pokemonName -> PokemonDetailScreen(pokemonName) }
        }
    }
}
@Composable
fun PokemonsListScreen(
    viewModel: PokemonsViewModel = koinViewModel(),
    onNavigateToDetail: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.pokemon),
                contentScale = ContentScale.Crop
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ) {
            item {
                Text(
                    text = "Список покемонов",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .padding(bottom = 20.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }
            items(state.pokemonsList) { pokemon ->
                Card(
                    modifier = Modifier
                        .clickable(onClick = { onNavigateToDetail(pokemon.name) })
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp)
                        .shadow(5.dp)

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        AsyncImage(
                            model = pokemon.url,
                            contentDescription = null,
                            modifier = Modifier
                                .height(90.dp)
                                .width(90.dp)
                                .padding(end = 15.dp)
                                .background(Color.White)
                        )
                        Text(
                            text = pokemon.name,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}