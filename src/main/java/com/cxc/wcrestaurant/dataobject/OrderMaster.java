package com.cxc.wcrestaurant.dataobject;

import com.cxc.wcrestaurant.enums.OrderStatusEnum;
import com.cxc.wcrestaurant.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Data
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    //    买家微信openid
    private String buyerOpenid;
    private BigDecimal orderAmount;
    //    订单状态，默认0新订单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //    支付状态，默认0未支付
    private Integer payStatus = PayStatusEnum.UNPAY.getCode();
    private Date createTime;
    private Date updateTime;
}
