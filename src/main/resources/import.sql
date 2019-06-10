-- use database wcrestaurant;

drop table if exists `product_info`;
create table `product_info` (
    `product_id` varchar(32) not null comment "商品主键",
    `product_name` varchar(64) not null comment "商品名称",
    `product_price` decimal(8,2) not null comment "单价",
    `product_stock` int not null comment "库存",
    `product_desc` varchar(128) comment "商品描述",
    `product_icon` varchar(512) comment "小图",
    `product_status` tinyint(3) not null default "0" comment "商品销售状态，默认0下架",
    `category_type` int not null comment "类目编号",
    `create_time` timestamp not null default current_timestamp comment "创建时间",
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment "更新时间",
    primary key (`product_id`)
) engine=innodb default charset=utf8mb4 comment "商品表";

drop table if exists `product_category`;
create table `product_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment "类目名称",
    `category_type` int not null comment "类目编号",
    `create_time` timestamp not null default current_timestamp comment "创建时间",
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment "更新时间",
    primary key (`category_id`),
    unique key `uqe_category_type` (`category_type`)
) engine=innodb default charset=utf8mb4 comment "商品类目表";

drop table if exists `order_master`;
create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment "买家姓名",
    `buyer_phone` varchar(32) not null comment "买家电话",
    `buyer_address` varchar(128) not null comment "买家地址",
    `buyer_openid` varchar(64) not null comment "买家微信openid",
    `order_amount` decimal(8,2) not null comment "订单总金额",
    `order_status` tinyint(3) not null default "0" comment "订单状态，默认0新下单",
    `pay_status` tinyint(3) not null default "0" comment "支付状态，默认0未支付",
    `create_time` timestamp not null default current_timestamp comment "创建时间",
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment "更新时间",
    primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
) engine=innodb default charset=utf8mb4 comment "订单主表";

drop table if exists `order_detail`;
create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null comment "关联订单主表id",
    `product_id` varchar(32) not null comment "关联商品表id",
    `product_name` varchar(64) not null comment "下单时商品名称",
    `product_price` decimal(8,2) not null comment "下单时商品价格",
    `product_quantity` int not null comment "购买商品数量",
    `product_icon` varchar(512) comment "下单时商品小图",
    `create_time` timestamp not null default current_timestamp comment "创建时间",
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment "更新时间",
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
) engine=innodb default charset=utf8mb4 comment "订单详情表";