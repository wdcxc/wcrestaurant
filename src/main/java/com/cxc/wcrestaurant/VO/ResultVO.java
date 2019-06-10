package com.cxc.wcrestaurant.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultVO() {
    }
}
