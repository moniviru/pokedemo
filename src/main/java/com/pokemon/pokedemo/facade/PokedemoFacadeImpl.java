package com.pokemon.pokedemo.facade;

import com.pokemon.pokedemo.adapter.PokemonApi;
import com.pokemon.pokedemo.converter.PokemonApiConverter;
import com.pokemon.pokedemo.dto.PokemonRequestDto;
import com.pokemon.pokedemo.dto.PokemonResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokedemoFacadeImpl implements PokedemoFacade {

    private PokemonApi pokemonApi;

    public PokedemoFacadeImpl(PokemonApi pokemonApi){
        this.pokemonApi = pokemonApi;
    }

    public List<PokemonResponseDto> getPokemonList(PokemonRequestDto pokemonRequestDto){
        List<PokemonResponseDto> dtoList = PokemonApiConverter.toDto(pokemonApi.getPokemonList(PokemonApiConverter.toRequestBody(pokemonRequestDto)));

        // added some business logic to calculate Pokemon score
        for(PokemonResponseDto dto: dtoList){
            dto.setScore((int) (Math.random() * 100) + 1);
        }

        return dtoList;
    }

}
