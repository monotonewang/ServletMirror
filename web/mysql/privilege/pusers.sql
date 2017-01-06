/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-01-06 12:00:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pusers
-- ----------------------------
DROP TABLE IF EXISTS `pusers`;
CREATE TABLE `pusers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pusers
-- ----------------------------
INSERT INTO `pusers` VALUES ('1', 'aaa', '111');
INSERT INTO `pusers` VALUES ('2', 'bbb', '111');
INSERT INTO `pusers` VALUES ('3', 'ccc', '111');
