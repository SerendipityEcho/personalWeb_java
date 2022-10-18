package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Product;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping
    public Result add(Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping
    public Result del(Integer id){
        return productService.delProduct(id);
    }

    @PutMapping
    public Result update(Product product){
        return productService.updateProduct(product);
    }

    @GetMapping
    public Result queryByPage(Product product){
        return productService.queryByPage(product);
    }

}

