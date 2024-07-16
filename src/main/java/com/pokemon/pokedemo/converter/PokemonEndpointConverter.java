package com.pokemon.pokedemo.converter;

import com.pokemon.pokedemo.dto.PokemonRequestDto;
import com.pokemon.pokedemo.dto.PokemonResponseDto;
import com.pokemon.pokedemo.payload.GetPokemonListRequest;
import com.pokemon.pokedemo.payload.GetPokemonListResponse;
import com.pokemon.pokedemo.payload.GetPokemonListResponse.Pokemon;

import java.util.List;

public class PokemonEndpointConverter {

    public static GetPokemonListResponse toSoap(List<PokemonResponseDto> dtoList){
        GetPokemonListResponse response = new GetPokemonListResponse();
        for(PokemonResponseDto dto: dtoList){
            Pokemon pokemon = new Pokemon();
            pokemon.setName(dto.getName());
            pokemon.setUrl(dto.getUrl());
            pokemon.setScore(dto.getScore());
            response.getPokemon().add(pokemon);
        }
        return response;
    }

    public static PokemonRequestDto fromSoap(GetPokemonListRequest request){
        return new PokemonRequestDto(request.getLimit(), request.getOffset());
    }
}
