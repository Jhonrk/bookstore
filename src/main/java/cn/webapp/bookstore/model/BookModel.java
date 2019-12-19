package cn.webapp.bookstore.model;

import lombok.Data;

/**
 * book model
 * @author 胡继恒
 */
@Data
public class BookModel {
    private int bookId;
    private int catalogId;
    private String bookName;
    private int price;
    private String picture;
}
