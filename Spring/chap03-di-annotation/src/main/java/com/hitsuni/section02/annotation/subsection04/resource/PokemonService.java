package com.hitsuni.section02.annotation.subsection04.resource;

import com.hitsuni.section02.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("pokemonServiceResource")
public class PokemonService {

    /* @Resource : 자바 진영에서 제공하는 DI 어노테이션
    * @Autowire 와 달리 name 속성 값으로 의존성 주입을 할 수 있고, 필드 주입, 세터 주입 방식을 사용한다.
    * 만약 List<Pokemon> 타입을 필드로 선언한다면 @Resource 라고만 어노테이션을 작성하면 된다.
    * -> 기본적으로는 name 속성으로 주입하지만 name 속성이 없을 경우 type 을 통해 의존성을 주입한다.
    * */
    //@Resource(name = "pikachu")
    private Pokemon pokemon;

    @Resource(name = "pikachu")
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
