package com.hitsuni.section01.autowired.subsection03.setter;

import com.hitsuni.section01.autowired.common.BookDAO;
import com.hitsuni.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component 의 세분화 어노테이션으로 service 계층에서 사용한다.
@Service("bookServiceSetter")
public class BookService {

    private /* final */ BookDAO bookDAO;

    /* Setter 주입 */
    @Autowired

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
