package com.xiaoyi.personalweb.service;

import com.xiaoyi.personalweb.entity.Price;
import com.xiaoyi.personalweb.entity.Result;

public interface PriceService {
    Result addPrice(Price price);
    Result delById(Integer id);
    Result updateById(Price price);
    Result queryByPage(Price price);
}
