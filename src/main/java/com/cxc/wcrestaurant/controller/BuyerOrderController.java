package com.cxc.wcrestaurant.controller;

import com.cxc.wcrestaurant.VO.ResultVO;
import com.cxc.wcrestaurant.converter.OrderForm2OrderDTOConverter;
import com.cxc.wcrestaurant.dto.OrderDTO;
import com.cxc.wcrestaurant.enums.ResultEnum;
import com.cxc.wcrestaurant.exception.SellException;
import com.cxc.wcrestaurant.form.OrderForm;
import com.cxc.wcrestaurant.service.impl.BuyerServiceImpl;
import com.cxc.wcrestaurant.service.impl.OrderServiceImpl;
import com.cxc.wcrestaurant.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private BuyerServiceImpl buyerService;

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【订单创建失败，表单参数验证错误】orderForm:{}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【订单创建失败，购物车不能为空】,orderDTO:{}", orderDTO);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam(value = "pageIndex", defaultValue = "0") Integer pageIndex,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                         @RequestParam(value = "openId", required = true) String openId) {
        if (StringUtils.isEmpty(openId)) {
            log.error("【查询订单列表出错，用户openid不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        Page<OrderDTO> orderDTOPage = orderService.findByBuyerOpenId(openId, pageRequest);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam(value = "openId", required = true) String openId,
                                     @RequestParam(value = "orderId", required = true) String orderId) {
        OrderDTO orderDTO = buyerService.findOrderOne(openId, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam(value = "openId", required = true) String openId,
                           @RequestParam(value = "orderId", required = true) String orderId) {
        buyerService.CancelOrder(openId, orderId);
        return ResultVOUtil.success();
    }
}
