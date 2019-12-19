package cn.webapp.bookstore.dao;

import cn.webapp.bookstore.model.CatalogModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author china
 */

@Mapper
@Service
public interface CatalogMapper {
    List<CatalogModel> findAllCata();
}

