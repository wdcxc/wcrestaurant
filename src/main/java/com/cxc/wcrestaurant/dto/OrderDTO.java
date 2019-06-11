package com.cxc.wcrestaurant.dto;

import com.cxc.wcrestaurant.dataobject.OrderDetail;
import com.cxc.wcrestaurant.enums.OrderStatusEnum;
import com.cxc.wcrestaurant.enums.PayStatusEnum;
import com.cxc.wcrestaurant.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    //    买家微信openid
    private String buyerOpenid;
    private BigDecimal orderAmount;
    //    订单状态，默认0新订单
    private Integer orderStatus;
    //    支付状态，默认0未支付
    private Integer payStatus;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    private List<OrderDetail> orderDetailList;
}
