package cn.webapp.bookstore.model;

import lombok.Data;

import java.util.Date;

/**
 * order model
 * @author china
 */
@Data
public class OrderModel {
    private int orderId;
    private int userId;
    private Date orderDate;
}
