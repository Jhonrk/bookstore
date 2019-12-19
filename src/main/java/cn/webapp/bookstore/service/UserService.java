package cn.webapp.bookstore.service;

import cn.webapp.bookstore.dao.UserMapper;
import cn.webapp.bookstore.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Autowired
    private UserMapper dao;

    public UserModel findByUser(String userName) {
        return dao.findByUser(userName);
    }

    public int addUser(UserModel model) {
        return dao.addUser(model);
    }
}
