package com.cxc.wcrestaurant.service;

import com.cxc.wcrestaurant.dataobject.ProductCategory;
import sun.plugin.perf.PluginRollup;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
