package cn.webapp.bookstore.dao;

import cn.webapp.bookstore.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author china
 */

@Mapper
@Service
public interface UserMapper {
    UserModel findByUser(@Param(value = "username") String username);
    int addUser(@Param(value = "model") UserModel model);
}
