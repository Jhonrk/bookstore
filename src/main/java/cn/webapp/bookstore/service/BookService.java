package cn.webapp.bookstore.service;

import cn.webapp.bookstore.dao.BookMapper;
import cn.webapp.bookstore.vo.BooksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper dao;

    public List<BooksVo> findAllBook() {
        return dao.findAllBook();
    }

    public List<BooksVo> findAllBooksById(int catalogId) {
        return dao.findAllBooksById(catalogId);
    }

    public List<BooksVo> findAllBooksByName(String bookName) {
        return dao.findAllBooksByName(bookName);
    }
}
