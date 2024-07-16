package com.pokemon.pokedemo.adapter;

import com.pokemon.pokedemo.adapter.payload.PokemonRequestBody;
import com.pokemon.pokedemo.adapter.payload.PokemonResponseBody;

public interface PokemonApi {

    PokemonResponseBody getPokemonList(PokemonRequestBody request);
}
