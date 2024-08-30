package com.hitsuni.section02.initdestroy.subsection01.java;

import com.hitsuni.common.Beverage;
import com.hitsuni.common.Bread;
import com.hitsuni.common.Product;
import com.hitsuni.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

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
    @Scope("prototype")// default 값인 singleton 에서 prototype 으로 변경
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

    /*   initMethod : 객체 생성 시 수행되어야 할 초기화 메소드 지정 옵션
    * destroyMethod : 객체 삭제 시 수행되어야 할 메소드 지정 옵션 */
    @Bean(initMethod = "openShop", destroyMethod="closeShop")
    public Owner owner() {
        return new Owner();
    }
}
