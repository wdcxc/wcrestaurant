package com.cxc.wcrestaurant.converter;

import com.cxc.wcrestaurant.dataobject.OrderDetail;
import com.cxc.wcrestaurant.dto.OrderDTO;
import com.cxc.wcrestaurant.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.hibernate.criterion.Order;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;

import java.util.ArrayList;
import java.util.List;

public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        Gson gson = new Gson();
        List<OrderDetail> orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
        }.getType());
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
