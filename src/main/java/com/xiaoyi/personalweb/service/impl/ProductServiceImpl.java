package com.xiaoyi.personalweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoyi.personalweb.entity.Product;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.mapper.ProductMapper;
import com.xiaoyi.personalweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Result addProduct(Product product) {
        int row = productMapper.insert(product);
        return new Result(row,row > 0);
    }

    @Override
    public Result delProduct(Integer id) {
        int row = productMapper.deleteById(id);
        return new Result(row,row > 0);
    }

    @Override
    public Result updateProduct(Product product) {
        int row = productMapper.updateById(product);
        return new Result(row,row > 0);
    }

    @Override
    public Result queryByPage(Product product) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.like(product.getName() != null,"name", product.getName());
        List<Product> productList = productMapper.selectList(wrapper);
        return Result.getSuccessResult(productList);
    }
}
