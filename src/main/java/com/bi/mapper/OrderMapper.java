package com.bi.mapper;


import com.bi.entity.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderMapper {
    BigDecimal selectTotalAmountSkuId(String skuId);
    List<Order> selectOrder(Integer Id);
}
