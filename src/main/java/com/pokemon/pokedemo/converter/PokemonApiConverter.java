package com.pokemon.pokedemo.converter;

import com.pokemon.pokedemo.adapter.payload.PokemonRequestBody;
import com.pokemon.pokedemo.adapter.payload.PokemonResponseBody;
import com.pokemon.pokedemo.dto.PokemonRequestDto;
import com.pokemon.pokedemo.dto.PokemonResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonApiConverter {

    public static List<PokemonResponseDto> toDto(PokemonResponseBody pokemonResponseBody){
        return pokemonResponseBody.getResults().stream().map( prb -> new PokemonResponseDto(prb.getName(), prb.getUrl())
        ).collect(Collectors.toList());
    }

    public static PokemonRequestBody toRequestBody(PokemonRequestDto dto){
        return new PokemonRequestBody(dto.getLimit(), dto.getOffset());
    }
}
