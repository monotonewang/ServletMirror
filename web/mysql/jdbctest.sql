/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-02 07:15:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for examstudent
-- ----------------------------
DROP TABLE IF EXISTS `examstudent`;
CREATE TABLE `examstudent` (
  `flowID` int(16) DEFAULT NULL,
  `type` int(16) DEFAULT NULL,
  `idCard` varchar(255) DEFAULT NULL,
  `examStudent` varchar(16) DEFAULT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `gradle` int(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examstudent
-- ----------------------------
INSERT INTO `examstudent` VALUES ('1', '2', '121', '85', '李四', '北京', '1');
INSERT INTO `examstudent` VALUES ('2', '2', '1212', '96', '王五', '上海', '2');
INSERT INTO `examstudent` VALUES ('1', '4', '50', '212120', '张山0', '北京0', '2');
INSERT INTO `examstudent` VALUES ('2', '5', '51', '212121', '张山1', '北京1', '3');
INSERT INTO `examstudent` VALUES ('3', '6', '52', '212122', '张山2', '北京2', '4');
INSERT INTO `examstudent` VALUES ('4', '7', '53', '212123', '张山3', '北京3', '5');
INSERT INTO `examstudent` VALUES ('5', '8', '54', '212124', '张山4', '北京4', '6');
INSERT INTO `examstudent` VALUES ('6', '9', '55', '212125', '张山5', '北京5', '7');
INSERT INTO `examstudent` VALUES ('7', '10', '56', '212126', '张山6', '北京6', '8');
INSERT INTO `examstudent` VALUES ('8', '11', '57', '212127', '张山7', '北京7', '9');
INSERT INTO `examstudent` VALUES ('9', '12', '58', '212128', '张山8', '北京8', '10');
INSERT INTO `examstudent` VALUES ('10', '13', '59', '212129', '张山9', '北京9', '11');
INSERT INTO `examstudent` VALUES ('11', '14', '510', '2121210', '张山10', '北京10', '12');
INSERT INTO `examstudent` VALUES ('12', '15', '511', '2121211', '张山11', '北京11', '13');
INSERT INTO `examstudent` VALUES ('13', '16', '512', '2121212', '张山12', '北京12', '14');
INSERT INTO `examstudent` VALUES ('14', '17', '513', '2121213', '张山13', '北京13', '15');
INSERT INTO `examstudent` VALUES ('15', '18', '514', '2121214', '张山14', '北京14', '16');
INSERT INTO `examstudent` VALUES ('16', '19', '515', '2121215', '张山15', '北京15', '17');
INSERT INTO `examstudent` VALUES ('17', '20', '516', '2121216', '张山16', '北京16', '18');
INSERT INTO `examstudent` VALUES ('18', '21', '517', '2121217', '张山17', '北京17', '19');
INSERT INTO `examstudent` VALUES ('19', '22', '518', '2121218', '张山18', '北京18', '20');
INSERT INTO `examstudent` VALUES ('20', '23', '519', '2121219', '张山19', '北京19', '21');
INSERT INTO `examstudent` VALUES ('21', '24', '520', '2121220', '张山20', '北京20', '22');
INSERT INTO `examstudent` VALUES ('22', '25', '521', '2121221', '张山21', '北京21', '23');
INSERT INTO `examstudent` VALUES ('23', '26', '522', '2121222', '张山22', '北京22', '24');
INSERT INTO `examstudent` VALUES ('24', '27', '523', '2121223', '张山23', '北京23', '25');
INSERT INTO `examstudent` VALUES ('25', '28', '524', '2121224', '张山24', '北京24', '26');
INSERT INTO `examstudent` VALUES ('26', '29', '525', '2121225', '张山25', '北京25', '27');
INSERT INTO `examstudent` VALUES ('27', '30', '526', '2121226', '张山26', '北京26', '28');
INSERT INTO `examstudent` VALUES ('28', '31', '527', '2121227', '张山27', '北京27', '29');
INSERT INTO `examstudent` VALUES ('29', '32', '528', '2121228', '张山28', '北京28', '30');
INSERT INTO `examstudent` VALUES ('30', '33', '529', '2121229', '张山29', '北京29', '31');
INSERT INTO `examstudent` VALUES ('31', '34', '530', '2121230', '张山30', '北京30', '32');
INSERT INTO `examstudent` VALUES ('32', '35', '531', '2121231', '张山31', '北京31', '33');
INSERT INTO `examstudent` VALUES ('33', '36', '532', '2121232', '张山32', '北京32', '34');
INSERT INTO `examstudent` VALUES ('34', '37', '533', '2121233', '张山33', '北京33', '35');
INSERT INTO `examstudent` VALUES ('35', '38', '534', '2121234', '张山34', '北京34', '36');
INSERT INTO `examstudent` VALUES ('36', '39', '535', '2121235', '张山35', '北京35', '37');
INSERT INTO `examstudent` VALUES ('37', '40', '536', '2121236', '张山36', '北京36', '38');
INSERT INTO `examstudent` VALUES ('38', '41', '537', '2121237', '张山37', '北京37', '39');
INSERT INTO `examstudent` VALUES ('39', '42', '538', '2121238', '张山38', '北京38', '40');
INSERT INTO `examstudent` VALUES ('40', '43', '539', '2121239', '张山39', '北京39', '41');
INSERT INTO `examstudent` VALUES ('41', '44', '540', '2121240', '张山40', '北京40', '42');
INSERT INTO `examstudent` VALUES ('42', '45', '541', '2121241', '张山41', '北京41', '43');
INSERT INTO `examstudent` VALUES ('43', '46', '542', '2121242', '张山42', '北京42', '44');
INSERT INTO `examstudent` VALUES ('44', '47', '543', '2121243', '张山43', '北京43', '45');
INSERT INTO `examstudent` VALUES ('45', '48', '544', '2121244', '张山44', '北京44', '46');
INSERT INTO `examstudent` VALUES ('46', '49', '545', '2121245', '张山45', '北京45', '47');
INSERT INTO `examstudent` VALUES ('47', '50', '546', '2121246', '张山46', '北京46', '48');
INSERT INTO `examstudent` VALUES ('48', '51', '547', '2121247', '张山47', '北京47', '49');
INSERT INTO `examstudent` VALUES ('49', '52', '548', '2121248', '张山48', '北京48', '50');
INSERT INTO `examstudent` VALUES ('50', '53', '549', '2121249', '张山49', '北京49', '51');
INSERT INTO `examstudent` VALUES ('51', '54', '550', '2121250', '张山50', '北京50', '52');
INSERT INTO `examstudent` VALUES ('52', '55', '551', '2121251', '张山51', '北京51', '53');
INSERT INTO `examstudent` VALUES ('53', '56', '552', '2121252', '张山52', '北京52', '54');
INSERT INTO `examstudent` VALUES ('54', '57', '553', '2121253', '张山53', '北京53', '55');
INSERT INTO `examstudent` VALUES ('55', '58', '554', '2121254', '张山54', '北京54', '56');
INSERT INTO `examstudent` VALUES ('56', '59', '555', '2121255', '张山55', '北京55', '57');
INSERT INTO `examstudent` VALUES ('57', '60', '556', '2121256', '张山56', '北京56', '58');
INSERT INTO `examstudent` VALUES ('58', '61', '557', '2121257', '张山57', '北京57', '59');
INSERT INTO `examstudent` VALUES ('59', '62', '558', '2121258', '张山58', '北京58', '60');
INSERT INTO `examstudent` VALUES ('60', '63', '559', '2121259', '张山59', '北京59', '61');
INSERT INTO `examstudent` VALUES ('61', '64', '560', '2121260', '张山60', '北京60', '62');
INSERT INTO `examstudent` VALUES ('62', '65', '561', '2121261', '张山61', '北京61', '63');
INSERT INTO `examstudent` VALUES ('63', '66', '562', '2121262', '张山62', '北京62', '64');
INSERT INTO `examstudent` VALUES ('64', '67', '563', '2121263', '张山63', '北京63', '65');
INSERT INTO `examstudent` VALUES ('65', '68', '564', '2121264', '张山64', '北京64', '66');
INSERT INTO `examstudent` VALUES ('66', '69', '565', '2121265', '张山65', '北京65', '67');
INSERT INTO `examstudent` VALUES ('67', '70', '566', '2121266', '张山66', '北京66', '68');
INSERT INTO `examstudent` VALUES ('68', '71', '567', '2121267', '张山67', '北京67', '69');
INSERT INTO `examstudent` VALUES ('69', '72', '568', '2121268', '张山68', '北京68', '70');
INSERT INTO `examstudent` VALUES ('70', '73', '569', '2121269', '张山69', '北京69', '71');
INSERT INTO `examstudent` VALUES ('71', '74', '570', '2121270', '张山70', '北京70', '72');
INSERT INTO `examstudent` VALUES ('72', '75', '571', '2121271', '张山71', '北京71', '73');
INSERT INTO `examstudent` VALUES ('73', '76', '572', '2121272', '张山72', '北京72', '74');
INSERT INTO `examstudent` VALUES ('74', '77', '573', '2121273', '张山73', '北京73', '75');
INSERT INTO `examstudent` VALUES ('75', '78', '574', '2121274', '张山74', '北京74', '76');
INSERT INTO `examstudent` VALUES ('76', '79', '575', '2121275', '张山75', '北京75', '77');
INSERT INTO `examstudent` VALUES ('77', '80', '576', '2121276', '张山76', '北京76', '78');
INSERT INTO `examstudent` VALUES ('78', '81', '577', '2121277', '张山77', '北京77', '79');
INSERT INTO `examstudent` VALUES ('79', '82', '578', '2121278', '张山78', '北京78', '80');
INSERT INTO `examstudent` VALUES ('80', '83', '579', '2121279', '张山79', '北京79', '81');
