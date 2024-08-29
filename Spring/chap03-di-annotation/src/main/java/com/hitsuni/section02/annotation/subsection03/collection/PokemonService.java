package com.hitsuni.section02.annotation.subsection03.collection;

import com.hitsuni.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* 컬렉션 타입으로 의존성 주입을 받게 되면 해당 타입의 등록된 빈이 모두 주입 된다. */
    /* 1. Collection List
    private List<Pokemon> pokemons;

    @Autowired
    public PokemonService(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void pokemonAttack() {
        pokemons.forEach(Pokemon::attack);
    }
    */

    /* 2. Collection Map */
    private Map<String, Pokemon> pokemons;

    public PokemonService(Map<String, Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void pokemonAttack() {
        pokemons.forEach((k, v) -> {
            System.out.println(k + " " + v);
            v.attack();
        });
    }
}
