package com.xiaoyi.personalweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoyi.personalweb.entity.Price;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.mapper.PriceMapper;
import com.xiaoyi.personalweb.service.PriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PriceServiceImpl implements PriceService {

    @Resource
    private PriceMapper priceMapper;

    @Override
    public Result addPrice(Price price) {
        int row = priceMapper.insert(price);
        return new Result(row, row > 0);
    }

    @Override
    public Result delById(Integer id) {
        int row = priceMapper.deleteById(id);
        return new Result(row, row > 0);
    }

    @Override
    public Result updateById(Price price) {
        int row = priceMapper.updateById(price);
        return new Result(row, row > 0);
    }

    @Override
    public Result queryByPage(Price price) {
        QueryWrapper<Price> wrapper = new QueryWrapper<>();
        wrapper.eq(price.getProductId()!=null,"product_id", price.getProductId());
        List<Price> priceList = priceMapper.selectList(wrapper);
        return Result.getSuccessResult(priceList);
    }
}
