package com.hitsuni.section01.autowired.subsection02.constructor;

import com.hitsuni.section01.autowired.common.BookDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.hitsuni.section01");

        BookService bookService = applicationContext.getBean("bookServiceConstructor", BookService.class);

        bookService.selectAllBooks().forEach(System.out::println);
        System.out.println(bookService.searchBookBySequence(1));

        /* 생성자 주입일 경우 IoC 컨테이너 없이 코드를 테스트 할때 생성자를 통해 bookDAO 객체를 전달하므로
         * 아래 코드는 문제 없이 테스트 될 수 있다.
         *  */
        BookService bookService2 = new BookService(new BookDAOImpl());
        bookService2.selectAllBooks();
    }
}