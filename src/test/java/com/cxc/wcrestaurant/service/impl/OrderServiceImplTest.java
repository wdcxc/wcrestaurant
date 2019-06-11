package com.cxc.wcrestaurant.service.impl;

import com.cxc.wcrestaurant.dataobject.OrderDetail;
import com.cxc.wcrestaurant.dto.OrderDTO;
import com.cxc.wcrestaurant.enums.OrderStatusEnum;
import com.cxc.wcrestaurant.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYEROPENID = "12345678";
    private final String ORDERID = "1560176694862368681";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("somewhere on earth");
        orderDTO.setBuyerName("wdcxc");
        orderDTO.setBuyerOpenid(BUYEROPENID);
        orderDTO.setBuyerPhone("1386868668");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail order1 = new OrderDetail();
        order1.setProductId("123456");
        order1.setProductQuantity(1);
        orderDetailList.add(order1);
        OrderDetail order2 = new OrderDetail();
        order2.setProductId("123457");
        order2.setProductQuantity(2);
        orderDetailList.add(order2);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO createdOrderDTO = orderService.create(orderDTO);
        log.info("【create new order】order:{}", createdOrderDTO);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        log.info("【find one order】order:{}", orderDTO);
        Assert.assertEquals(ORDERID, orderDTO.getOrderId());
    }

    @Test
    public void findByBuyerOpenId() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<OrderDTO> orderDTOPage = orderService.findByBuyerOpenId(BUYEROPENID, pageRequest);
        Assert.assertNotNull(orderDTOPage);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO cancel = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), cancel.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1560176300621485092");
        OrderDTO finish = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), finish.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1560176300621485092");
        OrderDTO paid = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.PAYED.getCode(),paid.getPayStatus());
    }
}