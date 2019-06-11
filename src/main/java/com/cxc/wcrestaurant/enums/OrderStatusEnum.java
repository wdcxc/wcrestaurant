package com.cxc.wcrestaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    NEW(0,"NEW ORDER"),
    FINISHED(1,"FINISHED ORDER"),
    CANCEL(2,"CANCEL ORDER")
    ;

    private Integer code;
    private String msg;
}
