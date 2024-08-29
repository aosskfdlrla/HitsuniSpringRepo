package com.hitsuni.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.hitsuni.section01");

        BookService bookService = applicationContext.getBean("bookServiceField", BookService.class);

        bookService.selectAllBooks().forEach(System.out::println);
        System.out.println(bookService.searchBookBySequence(1));

        /* 필드 주입일 경우 IoC 컨테이너 없이 테스트 하려고 하면 bookDAO 의존성 주입이 불가능해서
        * 아래코드 수행시 NullPointerException이 발생한다. -> 생성자 주입 권장
        *  */
        BookService bookService2 = new BookService();
        bookService2.selectAllBooks();
    }
}
