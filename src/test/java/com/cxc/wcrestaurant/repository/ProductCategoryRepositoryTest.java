package com.cxc.wcrestaurant.repository;

import com.cxc.wcrestaurant.dataobject.ProductCategory;
import jdk.nashorn.internal.ir.IdentNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {
//        List<ProductCategory> all = productCategoryRepository.findAll();
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(2);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(5);
        ProductCategory saveCategory = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(saveCategory);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = productCategoryRepository.findOneByCategoryId(1);
        productCategory.setCategoryName("最爱");
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 3);
        List<ProductCategory> categoryList = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertEquals(2, categoryList.size());
    }
}