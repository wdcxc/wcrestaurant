package com.cxc.wcrestaurant.controller;

import com.cxc.wcrestaurant.VO.ProductInfoVO;
import com.cxc.wcrestaurant.VO.ProductVO;
import com.cxc.wcrestaurant.VO.ResultVO;
import com.cxc.wcrestaurant.dataobject.ProductCategory;
import com.cxc.wcrestaurant.dataobject.ProductInfo;
import com.cxc.wcrestaurant.service.ProductCategoryService;
import com.cxc.wcrestaurant.service.ProductInfoService;
import com.cxc.wcrestaurant.utils.ResultVOUtil;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sun.xml.internal.stream.StaxErrorReporter;
import org.apache.tomcat.jni.Procattr;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list() {
        List<ProductVO> productVOList = new ArrayList<>();
        List<ProductInfo> productInfoList = productInfoService.findAll();
        List<ProductCategory> categoryList = productCategoryService.findAll();

//        List<Integer> categoryTypeList = categoryList.stream().map(c -> c.getCategoryType()).collect(Collectors.toList());

        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(category.getCategoryType());
            productVO.setCategoryName(category.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
