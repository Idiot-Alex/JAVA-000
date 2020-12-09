-- create database
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE `test`;

USE `test`;

-- create table
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
    `user_id` int(11) NOT NULL,
    `user_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
    `order_id` int(11) NOT NULL,
    `user_id` int(11) NOT NULL,
    `product_id` int(11) NOT NULL,
    `price` DECIMAL(5,2) DEFAULT 0,
    `amount` int(11) NOT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
    `product_id` int(11) NOT NULL,
    `product_name` varchar(255) NOT NULL,
    `price` DECIMAL(5,2) DEFAULT 0,
    `amount` int(11) NOT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;