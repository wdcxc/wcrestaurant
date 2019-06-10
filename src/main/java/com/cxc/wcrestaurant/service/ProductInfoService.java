package com.cxc.wcrestaurant.service;

import com.cxc.wcrestaurant.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.plugin.perf.PluginRollup;

import java.util.List;

public interface ProductInfoService {
    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findAll();

    List<ProductInfo> findAllUp();

    ProductInfo save(ProductInfo productInfo);
}
