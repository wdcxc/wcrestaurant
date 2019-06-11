package com.cxc.wcrestaurant.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    //   购买时商品单价
    private BigDecimal productPrice;
    //  购买数量
    private Integer productQuantity;
    private String productIcon;
}
