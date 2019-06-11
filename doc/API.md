# API

## 商品列表

### 请求
```
GET /wcrestaurant/buyer/product/list
```

### 参数
无

### 返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "name": "女生最爱",
            "type": 1,
            "productList": [
                {
                    "id": "123456",
                    "name": "爱马仕包包",
                    "price": 50000,
                    "desc": "高贵气质，值得拥有",
                    "icon": "http://amsbb.jpg"
                }
            ]
        },
        {
            "name": "男生最爱",
            "type": 3,
            "productList": [
                {
                    "id": "123457",
                    "name": "mac book pro",
                    "price": 15000,
                    "desc": "酷炫外观，卓越性能",
                    "icon": "xxx.jpg"
                }
            ]
        },
        {
            "name": "热销榜",
            "type": 100,
            "productList": []
        }
    ]
}
```

## 创建列表

### 请求
```json
POST /wcrestaurant/buyer/order/create
```

### 参数
+ openId
+ name
+ address
+ phone
+ items: [{productId:123456,productQuantity:2},{productId:123457,productQuantity:10}]

### 返回
```json
{
    "code": 0,
    "msg": "成功",
    "data":{
        "orderId": "1560262870445457249"
    }
}
```

## 订单详情

### 请求
```json
POST /wcrestaurant/buyer/order/detail
```

### 参数
+ openId
+ orderId

### 返回
```json
{
    "code": 0,
    "msg": "成功",
    "data": {
        "orderId": "1560175761276290922",
        "buyerName": "wdcxc",
        "buyerPhone": "1386868668",
        "buyerAddress": "somewhere on earth",
        "buyerOpenid": "12345678",
        "orderAmount": 50000,
        "orderStatus": 0,
        "payStatus": 0,
        "createTime": 1560204561,
        "updateTime": 1560204561,
        "orderDetailList": [
            {
                "detailId": "1560175761392992274",
                "orderId": "1560175761276290922",
                "productId": "123456",
                "productName": "爱马仕包包",
                "productPrice": 50000,
                "productQuantity": 1,
                "productIcon": "http://amsbb.jpg"
            }
        ]
    }
}
```

## 取消订单

### 请求
```json
POST /wcrestaurant/buyer/order/cancel
```

### 参数
+ openId
+ orderId

### 返回
```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```
