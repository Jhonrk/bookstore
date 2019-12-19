package cn.webapp.bookstore.dao;

import cn.webapp.bookstore.vo.BooksVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
@Service
public interface BookMapper {
    List<BooksVo> findAllBook();
    List<BooksVo> findAllBooksById(int catalogId);
    List<BooksVo> findAllBooksByName(String bookName);
}
