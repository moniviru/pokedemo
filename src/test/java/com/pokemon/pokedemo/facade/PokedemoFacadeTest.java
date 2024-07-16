package com.pokemon.pokedemo.facade;

import com.pokemon.pokedemo.adapter.PokemonApi;
import com.pokemon.pokedemo.adapter.payload.Pokemon;
import com.pokemon.pokedemo.adapter.payload.PokemonResponseBody;
import com.pokemon.pokedemo.dto.PokemonRequestDto;
import com.pokemon.pokedemo.dto.PokemonResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokedemoFacadeTest {

    @Mock
    private PokemonApi pokemonApi;

    @InjectMocks
    private PokedemoFacadeImpl pokedemoFacade;

    @Test
    public void getPokemonListTest(){
        //given
        when(pokemonApi.getPokemonList(Mockito.any())).thenReturn(mockPokemonData());
        PokemonRequestDto request = new PokemonRequestDto(4, 3);
        //when
        List<PokemonResponseDto> response = pokedemoFacade.getPokemonList(request);
        //then
        assertNotNull(response);
        assertEquals(response.size(), 4);
        response.forEach(r -> assertTrue(r.getScore() > 0));
    }

    private PokemonResponseBody mockPokemonData(){
        List<Pokemon> results = new ArrayList<>();
        results.add(new Pokemon("Pikachu", "http://test.io/1"));
        results.add(new Pokemon("Charizard", "http://test.io/7"));
        results.add(new Pokemon("Venusaur", "http://test.io/5"));
        results.add(new Pokemon("Squirtle", "http://test.io/3"));
        PokemonResponseBody response = new PokemonResponseBody();
        response.setResults(results);
        return response;
    }
}
