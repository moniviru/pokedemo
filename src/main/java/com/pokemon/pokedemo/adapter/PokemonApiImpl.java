package com.pokemon.pokedemo.adapter;

import com.pokemon.pokedemo.adapter.payload.PokemonRequestBody;
import com.pokemon.pokedemo.adapter.payload.PokemonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class PokemonApiImpl implements PokemonApi {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";

    @Autowired
    private RestTemplate restTemplate;

    public PokemonResponseBody getPokemonList(PokemonRequestBody request) {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("offset", request.getOffset())
                .queryParam("limit", request.getLimit())
                .build()
                .toUri();
        return restTemplate.getForObject(uri, PokemonResponseBody.class);
    }
}
