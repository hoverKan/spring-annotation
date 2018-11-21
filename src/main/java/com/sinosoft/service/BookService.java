package com.sinosoft.service;

import com.sinosoft.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author hoverkan
 * @create 2018-11-19 10:01
 */
@Service
public class BookService {

    @Inject
    private BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
