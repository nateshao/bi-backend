package com.bi.service.impl;

import com.bi.entity.Order;
import com.bi.mapper.OrderMapper;
import com.bi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public BigDecimal getTotalAmountBySkuId(String skuId) {
        return orderMapper.selectTotalAmountSkuId(skuId);
    }

    @Override
    public List<Order> getOrderById(Integer id) {
        return orderMapper.selectOrder(id);
    }
}
