package cn.webapp.bookstore.dao;

import cn.webapp.bookstore.model.OrderItemModel;
import cn.webapp.bookstore.model.OrderModel;
import cn.webapp.bookstore.vo.CartVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface CartMapper {
    List<CartVo> findCartById(int userId);
    int addOrders(OrderModel model);
    int addOrderItem(OrderItemModel model);
}
