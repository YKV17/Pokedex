package com.ykv17.repository

import com.ykv17.data.remote.PokeApi
import com.ykv17.data.remote.responses.Pokemon
import com.ykv17.data.remote.responses.PokemonList
import com.ykv17.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>{
        val response = try{
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            return Resource.Error(e.message?:"An unknown error occurred.")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        val response = try{
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            return Resource.Error(e.message?:"An unknown error occurred.")
        }

        return Resource.Success(response)
    }
}