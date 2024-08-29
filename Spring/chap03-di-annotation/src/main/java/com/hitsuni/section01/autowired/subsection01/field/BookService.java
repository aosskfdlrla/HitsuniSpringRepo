package com.hitsuni.section01.autowired.subsection01.field;

import com.hitsuni.section01.autowired.common.BookDAO;
import com.hitsuni.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component 의 세분화 어노테이션으로 service 계층에서 사용한다.
@Service("bookServiceField")
public class BookService {

    /* BookDAO 타입의 빈 객체를 이 프로퍼티에 자동으로 주입해준다.
    * */
    @Autowired // -> 필드 주입
    private /* final */ BookDAO bookDAO;

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
