package com.hitsuni.section01.scope.subsection01.singleton;

import com.hitsuni.common.Beverage;
import com.hitsuni.common.Bread;
import com.hitsuni.common.Product;
import com.hitsuni.common.ShoppingCart;
import org.springframework.context.annotation.Bean;

public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산 암반수", 3000, 1000);
    }

    @Bean
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
