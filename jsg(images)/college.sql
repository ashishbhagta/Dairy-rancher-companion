/*
Navicat MySQL Data Transfer

Source Server         : new
Source Server Version : 50136
Source Host           : localhost:3306
Source Database       : college

Target Server Type    : MYSQL
Target Server Version : 50136
File Encoding         : 65001

Date: 2016-07-17 13:06:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `custId` varchar(20) DEFAULT NULL,
  `delC` float DEFAULT NULL,
  `delB` float DEFAULT NULL,
  `rateC` float DEFAULT NULL,
  `rateB` float DEFAULT NULL,
  `totbill` float DEFAULT NULL,
  `paymentStatus` int(11) DEFAULT '0',
  `month` varchar(10) DEFAULT NULL,
  `year` varchar(10) DEFAULT NULL,
  `paidDate` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('amnajitroad  ', '59', '95', '40', '45', '6635', '1', '07', '2016', '2016-07-13');
INSERT INTO `bill` VALUES ('rmnajitroad  ', '63', '125', '40', '45', '8145', '0', '07', '2016', null);
INSERT INTO `bill` VALUES ('chmnajiroad  ', '30', '92', '40', '45', '5340', '1', '07', '2016', '2016-07-13');
INSERT INTO `bill` VALUES ('amnajitroad  ', '59', '95', '40', '45', '6635', '0', '08', '2016', null);
INSERT INTO `bill` VALUES ('amnajitroad  ', '60', '90', '40', '45', '6450', '0', '06', '2016', null);

-- ----------------------------
-- Table structure for `details`
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
  `custId` varchar(20) DEFAULT NULL,
  `month` varchar(10) DEFAULT NULL,
  `year` varchar(10) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `Amount` float DEFAULT NULL,
  `paymentLeft` float DEFAULT NULL,
  `paymentStatus` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of details
-- ----------------------------
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '07', '2016', '9041986458', '6635', '270', '1');
INSERT INTO `details` VALUES ('amnajitroad  ', '08', '2016', '9041986458', '6635', '270', '0');
INSERT INTO `details` VALUES ('amnajitroad  ', '06', '2016', '9041986458', '6450', '270', '0');
INSERT INTO `details` VALUES ('chmnajiroad  ', '07', '2016', '9876754545', '5340', '0', '1');
INSERT INTO `details` VALUES ('rmnajitroad  ', '07', '2016', '9876543210', '8145', '0', '0');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `custId` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('Aanchal', '10Jan@2001', '9041986458');

-- ----------------------------
-- Table structure for `milkman`
-- ----------------------------
DROP TABLE IF EXISTS `milkman`;
CREATE TABLE `milkman` (
  `custId` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `qtyc` float DEFAULT '0',
  `qtyb` float DEFAULT '0',
  `dos` date DEFAULT NULL,
  `paymentLeft` float DEFAULT '0',
  PRIMARY KEY (`custId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of milkman
-- ----------------------------
INSERT INTO `milkman` VALUES ('amnajitroad  ', 'aman', 'ajit road bti', '9041986458', '2', '3', '2015-07-06', '270');
INSERT INTO `milkman` VALUES ('chmnajiroad  ', 'chaman', 'ajit road bti', '9876754545', '1', '3', '2015-05-07', '0');
INSERT INTO `milkman` VALUES ('rmnajitroad  ', 'raman', 'ajit road', '9876543210', '2', '4', '2014-06-07', '0');

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `rollno` varchar(20) NOT NULL DEFAULT '',
  `sname` varchar(30) DEFAULT NULL,
  `branch` varchar(10) DEFAULT NULL,
  `per` float DEFAULT NULL,
  `doa` date DEFAULT NULL,
  `toa` time DEFAULT NULL,
  PRIMARY KEY (`rollno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('102', 'Raman', 'CSE', '65', '2016-06-30', '18:34:42');
INSERT INTO `students` VALUES ('103', 'Aman', 'ECE', '80', '2016-06-30', '18:34:53');
INSERT INTO `students` VALUES ('104', 'Chaman', 'Mech', '55', '2016-06-30', '18:35:04');
INSERT INTO `students` VALUES ('105', 'Chaman', 'CSE', '76', '2016-06-30', '18:35:23');

-- ----------------------------
-- Table structure for `users1`
-- ----------------------------
DROP TABLE IF EXISTS `users1`;
CREATE TABLE `users1` (
  `uid` varchar(20) NOT NULL DEFAULT '',
  `pwd` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `picpath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users1
-- ----------------------------
INSERT INTO `users1` VALUES ('abc', '123', '9876543210', 'C:\\Users\\hhh\\Documents');

-- ----------------------------
-- Table structure for `variations`
-- ----------------------------
DROP TABLE IF EXISTS `variations`;
CREATE TABLE `variations` (
  `custId` varchar(20) NOT NULL DEFAULT '',
  `vdate` date DEFAULT NULL,
  `qtyPlusC` float DEFAULT NULL,
  `qtyMinusC` float DEFAULT NULL,
  `qtyPlusB` float DEFAULT NULL,
  `qtyMinusB` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of variations
-- ----------------------------
INSERT INTO `variations` VALUES ('amnajitroad  ', '2016-07-05', '0', '1', '1', '0');
INSERT INTO `variations` VALUES ('amnajitroad  ', '2016-07-08', '0', '2', '1', '0');
INSERT INTO `variations` VALUES ('amnajitroad  ', '2016-08-11', '0', '2', '0', '1');
INSERT INTO `variations` VALUES ('rmnajitroad  ', '2016-06-12', '0', '2', '1', '0');
INSERT INTO `variations` VALUES ('rmnajitroad  ', '2016-07-11', '1', '0', '1', '0');
INSERT INTO `variations` VALUES ('chmnajiroad  ', '2016-06-13', '0', '1', '0', '1');
INSERT INTO `variations` VALUES ('chmnajiroad  ', '2016-07-13', '0', '1', '0', '1');
