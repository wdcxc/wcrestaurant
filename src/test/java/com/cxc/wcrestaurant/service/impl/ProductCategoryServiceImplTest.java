package com.cxc.wcrestaurant.service.impl;

import com.cxc.wcrestaurant.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne() {
        ProductCategory category = productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1), category.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList = productCategoryService.findAll();
        Assert.assertNotEquals(0,categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4,5,10));
        Assert.assertNotEquals(0,categoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("霸气专属", 100);
        ProductCategory savedCategory = productCategoryService.save(productCategory);
        Assert.assertNotNull(savedCategory);
    }
}