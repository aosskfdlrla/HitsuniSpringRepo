package com.hitsuni.section02.annotation.subsection05.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* Pokemon 이라는 타입의 객체가 3개가 있을 때 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.hitsuni.section02");

        PokemonService pokemonService = applicationContext.getBean("pokemonServiceInject", PokemonService.class);
        pokemonService.pokemonAttack();
    }
}
