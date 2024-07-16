package com.pokemon.pokedemo.adapter;

import com.pokemon.pokedemo.adapter.payload.PokemonRequestBody;
import com.pokemon.pokedemo.adapter.payload.PokemonResponseBody;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class PokemonApiTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PokemonApiImpl pokemonApi;

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";

    @Test
    public void getPokemonListTest(){
        //given
        int limit = 4;
        int offset = 3;
        URI uriExpected = UriComponentsBuilder.fromHttpUrl(BASE_URL+"?offset="+offset+"&limit="+limit).build().toUri();
        PokemonRequestBody request = new PokemonRequestBody(limit, offset);
        //when
        pokemonApi.getPokemonList(request);
        //then
        Mockito.verify(restTemplate, times(1)).getForObject(eq(uriExpected), eq(PokemonResponseBody.class));
    }
}
