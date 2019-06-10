package com.cxc.wcrestaurant.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDesc;
    private String productIcon;
    //    商品状态，默认0下架 1上架
    private Integer productStatus;
    private Integer categoryType;
}
