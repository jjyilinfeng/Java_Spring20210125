/*
 Navicat Premium Data Transfer

 Source Server         : master
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 21/01/2021 16:30:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart`  (
  `cartId` int(0) NOT NULL AUTO_INCREMENT,
  `cartUserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cartGoodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cartGoodsSize` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cartGoodsPrice` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cartGoodsCount` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cartGoodsWorth` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`cartId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_cart
-- ----------------------------
INSERT INTO `tb_cart` VALUES (9, 'songjie', '蓝莓冻', '小', '8.00', '1', '8');

-- ----------------------------
-- Table structure for tb_goods_store
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_store`;
CREATE TABLE `tb_goods_store`  (
  `gid` int(0) NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gsize` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gaprice` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gprice` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gcount` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gkind` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_goods_store
-- ----------------------------
INSERT INTO `tb_goods_store` VALUES (1, '蓝莓冻', '小', '9', '8.00', '9998', 'drinks');
INSERT INTO `tb_goods_store` VALUES (2, '蓝莓冻', '中', '12', '10.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (3, '蓝莓冻', '大', '14', '12.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (4, '冰薄荷橙', '中', '11', '9.00', '9995', 'drinks');
INSERT INTO `tb_goods_store` VALUES (5, '冰薄荷橙', '大', '15', '12.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (6, '泡沫抹茶', '中', '15', '10.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (7, '泡沫抹茶', '大', '20', '15.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (8, '泡沫抹茶', '扎', '50', '35.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (9, '草莓圣代', '中', '15', '12.00', '9999', 'dessert');
INSERT INTO `tb_goods_store` VALUES (10, '草莓圣代', '大', '20', '15.00', '9999', 'dessert');
INSERT INTO `tb_goods_store` VALUES (11, '珍珠奶茶', '中', '12', '10.00', '9997', 'drinks');
INSERT INTO `tb_goods_store` VALUES (12, '珍珠奶茶', '大', '15', '12.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (13, '台湾烧仙草', '中', '20', '16.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (14, '台湾烧仙草', '大', '25', '20.00', '9999', 'drinks');
INSERT INTO `tb_goods_store` VALUES (15, '台湾烧仙草', '扎', '60', '40.00', '9999', 'drinks');

-- ----------------------------
-- Table structure for tb_test
-- ----------------------------
DROP TABLE IF EXISTS `tb_test`;
CREATE TABLE `tb_test`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_test
-- ----------------------------
INSERT INTO `tb_test` VALUES (3, NULL, NULL);

-- ----------------------------
-- Table structure for tb_user_information
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_information`;
CREATE TABLE `tb_user_information`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `unickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `usex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `uage` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `ubirthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `usign` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user_information
-- ----------------------------
INSERT INTO `tb_user_information` VALUES (3, 'Sora', '空', '男', '', '', '');

-- ----------------------------
-- Table structure for tb_user_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_log`;
CREATE TABLE `tb_user_log`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `upassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `ukind` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `uEmail` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `uRegisterDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user_log
-- ----------------------------
INSERT INTO `tb_user_log` VALUES (1, 'admin', '123456', 'administrator', '-', '2021-01-15 20:41:14');
INSERT INTO `tb_user_log` VALUES (2, 'administrator', '000000', 'administrator', '-', '2021-01-15 20:41:54');
INSERT INTO `tb_user_log` VALUES (3, 'Sora', '123456', 'user', '774153247@qq.com', '2021-01-15 20:42:19');
INSERT INTO `tb_user_log` VALUES (7, 'songjie', '123456', 'user', '1010560974@qq.com', '2021-01-21 13:34:37');

SET FOREIGN_KEY_CHECKS = 1;
