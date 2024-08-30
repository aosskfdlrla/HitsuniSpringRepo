package com.hitsuni.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    @PostConstruct // initMethod 와 같은 설정 어노테이션
    public void openShop() {
        System.out.println("사장님이 가게 문을 열었습니다. 이제 쇼핑을 하실 수 있습니다.");
    }

    @PostConstruct // destroyMethod 와 같은 설정 어노테이션
    public void closeShop() {
        System.out.println("사장님이 가게 문을 닫았습니다. 이제 쇼핑을 하실 수 없습니다.");
    }
}
