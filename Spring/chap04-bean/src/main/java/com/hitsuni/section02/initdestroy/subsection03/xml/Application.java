package com.hitsuni.section02.initdestroy.subsection03.xml;

import com.hitsuni.common.Product;
import com.hitsuni.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* IoC 컨테이너 시작 */
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext("section02/initdestroy/subsection03/xml/spring-context.xml");

        /* 슈퍼에 상품이 진열 되어 있다. */
        Product carpBread = applicationContext.getBean("carpBread", Product.class);
        Product milk = applicationContext.getBean("milk", Product.class);
        Product water = applicationContext.getBean("water", Product.class);

        /* 한 손님이 쇼핑카트를 꺼내 상품을 카드에 담는다. */
        ShoppingCart cart = applicationContext.getBean("cart", ShoppingCart.class);
        cart.addItem(carpBread);
        cart.addItem(milk);

        System.out.println("cart 에 담긴 상품 : " + cart.getItem());

        /* 다른 손님이 쇼핑카트를 꺼내 상품을 카트에 담는다. */
        ShoppingCart cart2 = applicationContext.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 에 담긴 상품 : " + cart2.getItem());

        ((GenericXmlApplicationContext)applicationContext).close();
    }
}
