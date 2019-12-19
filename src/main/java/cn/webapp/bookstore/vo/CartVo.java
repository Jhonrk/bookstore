package cn.webapp.bookstore.vo;

import lombok.Data;

/**
 * cart vo
 * @author china
 */
@Data
public class CartVo {
    private int userId;
    private String bookName;
    private String picture;
    private int price;
    private int quantity;
}
