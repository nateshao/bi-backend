package com.bi.controller;

import com.bi.entity.Order;
import com.bi.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{skuId}")
    public BigDecimal getAmountBySkuId(
            @PathVariable(name = "skuId", required = true) String skuId
    ){
        return orderService.getTotalAmountBySkuId(skuId);
    }

    @GetMapping("/detail/{id}")
    public List<Order> getOderBySkuId(
            @PathVariable(name = "id", required = true) Integer id
    ){
        return orderService.getOrderById(id);
    }
}
