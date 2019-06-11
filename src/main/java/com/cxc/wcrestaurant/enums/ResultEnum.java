package com.cxc.wcrestaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    PRODUCT_NOT_FOUND(0, "product not found"),
    PRODUCT_STOCK_ERROR(1, "product stock error"),
    ORDER_NOT_FOUND(2,"order not found"),
    ORDER_DETAIL_NOT_FOUND(3,"order detail not found"),
    ORDER_STATUS_ERROR(4,"order status error"),
    ORDER_UPDATE_ERROR(5, "order update error"),
    PAY_STATUS_ERROR(6, "pay status error"),
    PARAM_ERROR(7, "param error"),
    USER_ORDER_ERROR(7, "user order error");

    private Integer code;
    private String msg;
}
