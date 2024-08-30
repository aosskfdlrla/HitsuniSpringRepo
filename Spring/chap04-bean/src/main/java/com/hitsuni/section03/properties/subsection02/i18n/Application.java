package com.hitsuni.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 한국어 */
        String error404KR = applicationContext.getMessage("error.404", null, Locale.KOREA);
        String error500KR = applicationContext.getMessage(
                "error.500",
                new Object[] {"여러분", new java.util.Date()},
                Locale.KOREA);

        System.out.println("error404KR : " + error404KR);
        System.out.println("error500KR : " + error500KR);

        /* 영어 */
        String error404US = applicationContext.getMessage("error.404", null, Locale.US);
        String error500US = applicationContext.getMessage(
                "error.500",
                new Object[] {"여러분", new java.util.Date()},
                Locale.US);

        System.out.println("error404KR : " + error404US);
        System.out.println("error500KR : " + error500US);
    }
}
