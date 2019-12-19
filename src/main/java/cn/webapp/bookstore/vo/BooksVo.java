package cn.webapp.bookstore.vo;

import cn.webapp.bookstore.model.CatalogModel;
import lombok.Data;

/**books vo
 * @author china
 */
@Data
public class BooksVo {
    private int bookId;
    private int catalogId;
    private int price;
    private String bookName;
    private String picture;
    private CatalogModel model;
}
