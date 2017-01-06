/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-01-06 12:00:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userprivilege
-- ----------------------------
DROP TABLE IF EXISTS `userprivilege`;
CREATE TABLE `userprivilege` (
  `user_id` int(11) NOT NULL,
  `privilege_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`privilege_id`),
  KEY `privilege_id` (`privilege_id`),
  CONSTRAINT `userprivilege_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `pusers` (`id`),
  CONSTRAINT `userprivilege_ibfk_2` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userprivilege
-- ----------------------------
INSERT INTO `userprivilege` VALUES ('1', '1');
INSERT INTO `userprivilege` VALUES ('2', '1');
INSERT INTO `userprivilege` VALUES ('1', '2');
INSERT INTO `userprivilege` VALUES ('2', '2');
INSERT INTO `userprivilege` VALUES ('1', '3');
