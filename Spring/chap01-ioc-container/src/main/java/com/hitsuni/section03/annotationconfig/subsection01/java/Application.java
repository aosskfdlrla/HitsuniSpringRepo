package com.hitsuni.section03.annotationconfig.subsection01.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigurationContext.class);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : beanNames)
            System.out.println("beanName : " + beanName);
    }
}

/* 스캐닝 결과
* beanName : org.springframework.context.annotation.internalConfigurationAnnotationProcessor
* beanName : org.springframework.context.annotation.internalAutowiredAnnotationProcessor
* beanName : org.springframework.context.event.internalEventListenerProcessor
* beanName : org.springframework.context.event.internalEventListenerFactory
* beanName : configurationContext
* beanName : memberDAO
* beanName : configurationSection02
* beanName : member
* */
