package com.cxc.wcrestaurant.repository;

import com.cxc.wcrestaurant.dataobject.OrderMaster;
import com.sun.jnlp.JNLPRandomAccessFileImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            OrderMaster orderMaster = new OrderMaster();
            int ranInt = random.nextInt();
            orderMaster.setOrderId("123456" + ranInt);
            orderMaster.setBuyerName("buyer" + ranInt);
            orderMaster.setBuyerAddress("buyer address " + ranInt);
            orderMaster.setBuyerOpenid("oid_123456" + ranInt);
            orderMaster.setBuyerPhone("1386666668" + ranInt);
            orderMaster.setOrderAmount(new BigDecimal(100.12));
            OrderMaster savedOrderMaster = repository.save(orderMaster);
            Assert.assertNotNull(savedOrderMaster);
        }
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<OrderMaster> page = repository.findByBuyerOpenid("oid_123456317752305", pageRequest);
        Assert.assertNotEquals(0, page.getTotalElements());
    }
}