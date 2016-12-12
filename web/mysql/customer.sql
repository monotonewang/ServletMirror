/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : day16

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-12 14:59:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(40) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `preference` varchar(100) DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('a11', 'tom', '男', '2010-10-10', '13888888888', 'tom@163.com', '吃,喝,玩', 'vip', 'good man');
INSERT INTO `customer` VALUES ('a12', 'fox', '男', '2000-10-10', '13888888888', 'tom@163.com', '吃,喝,玩', 'vip', 'good man');
INSERT INTO `customer` VALUES ('a13', 'james', '男', '1990-10-10', '13888888888', 'tom@163.com', '吃,喝,玩', 'vip', 'good man');
