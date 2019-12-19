package cn.webapp.bookstore.model;
import lombok.Data;

/**order item model
 * @author china
 */
@Data
public class OrderItemModel {
    private int orderItemId;
    private int bookId;
    private int orderId;
    private int quantity;
}
