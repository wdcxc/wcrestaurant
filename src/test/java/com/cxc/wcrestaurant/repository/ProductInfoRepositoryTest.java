package com.cxc.wcrestaurant.repository;

import com.cxc.wcrestaurant.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setCategoryType(1);
        productInfo.setProductName("爱马仕包包");
        productInfo.setProductPrice(new BigDecimal(50000));
        productInfo.setProductStatus(1);
        productInfo.setProductDesc("高贵气质，值得拥有");
        productInfo.setProductStock(10);
        productInfo.setProductIcon("http://amsbb.jpg");
        ProductInfo save = repository.save(productInfo);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productList = repository.findByProductStatus(1);
        Assert.assertNotEquals(0, productList.size());
    }
}