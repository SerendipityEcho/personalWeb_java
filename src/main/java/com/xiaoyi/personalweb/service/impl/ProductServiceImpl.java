package com.xiaoyi.personalweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoyi.personalweb.entity.Price;
import com.xiaoyi.personalweb.entity.Product;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.mapper.ProductMapper;
import com.xiaoyi.personalweb.service.PriceService;
import com.xiaoyi.personalweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final PriceService priceService;

    @Autowired
    public ProductServiceImpl(PriceService priceService, ProductMapper productMapper) {
        this.priceService = priceService;
        this.productMapper = productMapper;
    }

    @Override
    public Result addProduct(Product product) {
        // 添加商品会默认在价格表中添加一条对应的价格数据
        int row = productMapper.insert(product);
        // 在商品插入成功后mybatis会自动在实体类中插入该条数据的id
        // 插入默认的价格列表
        Price price = new Price();
        price.setProductId(product.getId());
        price.setPrice(product.getPrice());
        Result priceRow = priceService.addPrice(price);
        // 当两个都插入成功时返回成功，否则插入失败
        if (priceRow.isSuccess() && row > 0){
            return new Result(row,true);
        }
        return new Result(row,false);
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
        // 分页功能 暂时注掉，需要分页时使用
//        Page<Product> page = new Page<>();
//        Page<Product> productPage = productMapper.selectPage(page, wrapper);
        return Result.getSuccessResult(productList);
    }
}
