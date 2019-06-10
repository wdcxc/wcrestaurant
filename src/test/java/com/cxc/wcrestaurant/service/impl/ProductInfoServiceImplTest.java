package com.cxc.wcrestaurant.service.impl;

import com.cxc.wcrestaurant.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoServiceImpl service;

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(1, 5);
        Page<ProductInfo> productPage = service.findAll(pageRequest);
        System.out.println(productPage.getTotalElements());
    }

    @Test
    public void findAllUp() {
    }

    @Test
    public void save() {
    }
}