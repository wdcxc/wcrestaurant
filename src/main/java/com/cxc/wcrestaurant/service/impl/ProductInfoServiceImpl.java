package com.cxc.wcrestaurant.service.impl;

import com.cxc.wcrestaurant.dataobject.ProductInfo;
import com.cxc.wcrestaurant.dto.CartDTO;
import com.cxc.wcrestaurant.enums.OrderStatusEnum;
import com.cxc.wcrestaurant.enums.ProductStatusEnum;
import com.cxc.wcrestaurant.enums.ResultEnum;
import com.cxc.wcrestaurant.exception.SellException;
import com.cxc.wcrestaurant.repository.ProductInfoRepository;
import com.cxc.wcrestaurant.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.PortUnreachableException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductInfo> findAllUp() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_FOUND);
            }
            productInfo.setProductStock(productInfo.getProductStock() + cartDTO.getProductQuantity());
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo product = repository.findById(cartDTO.getProductId()).orElse(null);
            if (product == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_FOUND);
            }

            if (product.getProductStock() < cartDTO.getProductQuantity()) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            product.setProductStock(product.getProductStock() - cartDTO.getProductQuantity());
            repository.save(product);
        }
    }
}
