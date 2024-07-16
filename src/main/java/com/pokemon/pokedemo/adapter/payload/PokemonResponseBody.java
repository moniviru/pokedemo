package com.pokemon.pokedemo.adapter.payload;

import java.util.List;

public class PokemonResponseBody {

    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
