package com.cxc.wcrestaurant.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(1, "UP"),
    DOWN(0, "DOWN");

    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
