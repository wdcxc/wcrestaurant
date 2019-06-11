package com.cxc.wcrestaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
public enum PayStatusEnum {
    UNPAY(0, "UNPAY"),
    PAYED(1, "PAYED");

    private Integer code;
    private String msg;
}
