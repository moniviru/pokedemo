package com.pokemon.pokedemo.facade;

import com.pokemon.pokedemo.dto.PokemonRequestDto;
import com.pokemon.pokedemo.dto.PokemonResponseDto;

import java.util.List;

public interface PokedemoFacade {

    List<PokemonResponseDto> getPokemonList(PokemonRequestDto pokemonRequestDto);
}
