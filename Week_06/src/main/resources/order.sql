-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `extend_order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '额外订单号',
  `uid` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `real_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `user_phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户电话',
  `user_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `total_num` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单商品总数',
  `total_price` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '订单总价',
  `pay_price` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '实际支付金额',
  `deduction_price` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '抵扣金额',
  `paid` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '支付状态',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付方式',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款）',
  `refund_status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0 未退款 1 申请中 2 已退款',
  `refund_reason_wap_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款图片',
  `refund_reason_wap_explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款用户说明',
  `refund_reason_time` datetime(0) NULL DEFAULT NULL COMMENT '退款时间',
  `refund_reason_wap` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前台退款原因',
  `refund_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '不退款的理由',
  `refund_price` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '退款金额',
  `mark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  `is_del` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order_id_2`(`order_id`, `uid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `add_time`(`create_time`) USING BTREE,
  INDEX `pay_price`(`pay_price`) USING BTREE,
  INDEX `paid`(`paid`) USING BTREE,
  INDEX `pay_time`(`pay_time`) USING BTREE,
  INDEX `pay_type`(`pay_type`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `is_del`(`is_del`) USING BTREE,
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `oid` bigint(20) UNSIGNED NOT NULL COMMENT '订单id',
  `product_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品ID',
  `num` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '购买商品总数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `oid`(`oid`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单购物详情表' ROW_FORMAT = Dynamic;
