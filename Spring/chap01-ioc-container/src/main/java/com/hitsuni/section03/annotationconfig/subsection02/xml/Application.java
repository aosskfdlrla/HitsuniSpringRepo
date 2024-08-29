package com.hitsuni.section03.annotationconfig.subsection02.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("section03/annotationconfig/spring-context.xml");

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("beanName : " + beanName);
        }
    }
}

/* 스캐닝 결과
* beanName : memberDAO
* beanName : configurationSection02
* beanName : configurationSection03
* beanName : org.springframework.context.annotation.internalConfigurationAnnotationProcessor
* beanName : org.springframework.context.annotation.internalAutowiredAnnotationProcessor
* beanName : org.springframework.context.event.internalEventListenerProcessor
* beanName : org.springframework.context.event.internalEventListenerFactory
* beanName : member
* */
