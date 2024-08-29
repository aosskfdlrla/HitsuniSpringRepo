package com.hitsuni.section01.autowired.subsection02.constructor;

import com.hitsuni.section01.autowired.common.BookDAO;
import com.hitsuni.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component 의 세분화 어노테이션으로 service 계층에서 사용한다.
@Service("bookServiceConstructor")
public class BookService {

    private BookDAO bookDAO;

    //public BookService() {}

    /* 생성자 주입 */
    // spring 4.3 버전 이후부터 생성자가 1개 뿐이라면 어노테이션을 생략해도 자동으로 생성자 주입이 동작한다.
    // 단, 생성자가 1개 이상인 경우에는 명시적으로 작성해주어야 한다.
    //@Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
