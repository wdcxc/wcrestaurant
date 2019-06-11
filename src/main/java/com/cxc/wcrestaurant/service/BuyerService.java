package com.cxc.wcrestaurant.service;

import com.cxc.wcrestaurant.dto.OrderDTO;

public interface BuyerService {
    public OrderDTO findOrderOne(String openId, String orderId);

    public OrderDTO CancelOrder(String openId, String orderId);
}
