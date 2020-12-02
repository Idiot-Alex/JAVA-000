-- order table
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
`order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
`description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易描述',
`total_num` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单商品总数',
`total_price` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '订单总价',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`) USING BTREE,
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;