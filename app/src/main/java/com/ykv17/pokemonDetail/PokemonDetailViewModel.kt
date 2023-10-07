package com.ykv17.pokemonDetail

import androidx.lifecycle.ViewModel
import com.ykv17.data.remote.responses.Pokemon
import com.ykv17.repository.PokemonRepository
import com.ykv17.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }

}