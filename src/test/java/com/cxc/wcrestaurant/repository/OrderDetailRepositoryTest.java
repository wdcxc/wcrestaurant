package com.cxc.wcrestaurant.repository;

import com.cxc.wcrestaurant.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567");
        orderDetail.setOrderId("oid_123456317752305");
        orderDetail.setProductIcon("icon.jpg");
        orderDetail.setProductName("爱马仕包包");
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(2);
        orderDetail.setProductPrice(new BigDecimal(55000));
        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("oid_123456317752305");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}