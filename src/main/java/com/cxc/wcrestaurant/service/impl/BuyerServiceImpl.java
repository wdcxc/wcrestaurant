package com.cxc.wcrestaurant.service.impl;

import com.cxc.wcrestaurant.dto.OrderDTO;
import com.cxc.wcrestaurant.enums.ResultEnum;
import com.cxc.wcrestaurant.exception.SellException;
import com.cxc.wcrestaurant.service.BuyerService;
import com.cxc.wcrestaurant.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        return findAndCheckUserOrder(openId,orderId);
    }

    @Override
    public OrderDTO CancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = findAndCheckUserOrder(openId, orderId);
        OrderDTO cancel = orderService.cancel(orderDTO);
        return cancel;
    }

    private OrderDTO findAndCheckUserOrder(String openId, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (!orderDTO.getBuyerOpenid().equals(openId)) {
            log.error("【订单查询出错，用户不存在该订单】openId:{},orderDTO:{}", openId, orderDTO);
            throw new SellException(ResultEnum.USER_ORDER_ERROR);
        }
        return orderDTO;
    }
}
