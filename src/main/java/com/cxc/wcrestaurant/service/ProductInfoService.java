package com.cxc.wcrestaurant.service;

import com.cxc.wcrestaurant.dataobject.ProductInfo;
import com.cxc.wcrestaurant.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findAll();

    List<ProductInfo> findAllUp();

    ProductInfo save(ProductInfo productInfo);

    //    增库存
    void increaseStock(List<CartDTO> cartDTOList);

    //    扣库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
