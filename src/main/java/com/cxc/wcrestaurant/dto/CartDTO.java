package com.cxc.wcrestaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDTO {
    private String productId;
    private Integer productQuantity;
}
