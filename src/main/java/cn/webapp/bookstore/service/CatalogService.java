package cn.webapp.bookstore.service;

import cn.webapp.bookstore.dao.CatalogMapper;
import cn.webapp.bookstore.model.CatalogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private CatalogMapper dao;

    public List<CatalogModel> findAllCata() {
        return dao.findAllCata();
    }
}
