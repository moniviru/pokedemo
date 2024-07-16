package com.pokemon.pokedemo.endpoint;

import com.pokemon.pokedemo.converter.PokemonEndpointConverter;
import com.pokemon.pokedemo.facade.PokedemoFacade;
import com.pokemon.pokedemo.payload.GetPokemonListRequest;
import com.pokemon.pokedemo.payload.GetPokemonListResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class PokedemoEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/pokedemo";

    private PokedemoFacade pokedemoFacade;

    public PokedemoEndpoint(PokedemoFacade pokedemoFacade){
        this.pokedemoFacade = pokedemoFacade;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonListRequest")
    @ResponsePayload
    public GetPokemonListResponse getPokemonList(@RequestPayload GetPokemonListRequest request) {
        return PokemonEndpointConverter.toSoap(pokedemoFacade.getPokemonList(PokemonEndpointConverter.fromSoap(request)));
    }
}
