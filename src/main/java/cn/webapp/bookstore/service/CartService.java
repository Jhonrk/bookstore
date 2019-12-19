package cn.webapp.bookstore.service;

import cn.webapp.bookstore.dao.CartMapper;
import cn.webapp.bookstore.model.OrderItemModel;
import cn.webapp.bookstore.model.OrderModel;
import cn.webapp.bookstore.vo.CartVo;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartMapper dao;

    public List<CartVo> findCartById(int userId) {
        return dao.findCartById(userId);
    }

    @Transactional(rollbackFor = Exception.class)
    public int addOrder(OrderModel model, OrderItemModel orderItemModel) {
        //Logger logger = Logger.getLogger(CartService.class);
        dao.addOrders(model);
        //logger.info("%%%%%%%%%%%%%%%%%%%%%%%%" + model.getOrderId());
        orderItemModel.setOrderId(model.getOrderId());
        return dao.addOrderItem(orderItemModel);
    }
}
