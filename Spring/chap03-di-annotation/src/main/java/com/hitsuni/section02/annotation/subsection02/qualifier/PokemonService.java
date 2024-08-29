package com.hitsuni.section02.annotation.subsection02.qualifier;

import com.hitsuni.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    // @Qualifier : 여러 개의 빈 객체 중 특정 빈 객체를 이름으로 지정하는 어노테이션, 정확이 이름으로 찾는 것.
    // @Primary 와 같이 쓰인 경우 @Qualifier 가 우선 시 된다.

    /* 1. 필드 주입의 경우 */
//    @Autowired
//    @Qualifier("pikachu")
    private Pokemon pokemon;

    /* 2. 생성자 주입의 경우
    * 위치는 파라미터 안에 넣어주어야 함, 파라미터가 몇개인지 모르기 떄문!
    * */
    @Autowired
    public PokemonService(@Qualifier("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
