package com.cxc.wcrestaurant.form;

import lombok.Data;
import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {
    @NotEmpty(message = "买家姓名不能为空")
    private String name;
    @NotEmpty(message = "买家手机不能为空")
    private String phone;
    @NotEmpty(message = "买家地址不能为空")
    private String address;
    @NotEmpty(message = "买家微信openid不能为空")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
