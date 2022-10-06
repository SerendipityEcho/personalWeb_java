package com.xiaoyi.personalweb.service;

import com.xiaoyi.personalweb.entity.Product;
import com.xiaoyi.personalweb.entity.Result;

public interface ProductService {

    Result addProduct(Product product);

    Result delProduct(Integer id);

    Result updateProduct(Product product);

    Result queryByPage(Product product);

}
