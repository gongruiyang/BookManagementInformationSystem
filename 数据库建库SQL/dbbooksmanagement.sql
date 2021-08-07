/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : dbbooksmanagement

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 07/08/2021 15:19:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbbook
-- ----------------------------
DROP TABLE IF EXISTS `tbbook`;
CREATE TABLE `tbbook`  (
  `bookName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `ISBN` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookState` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbbook
-- ----------------------------
INSERT INTO `tbbook` VALUES ('1', '1', '1', '可以借阅');
INSERT INTO `tbbook` VALUES ('数据库系统原理与设计', '46546525', '万常选', '可以借阅');
INSERT INTO `tbbook` VALUES ('Java程序设计实用教程', '82234654', '张永常', '可以借阅');
INSERT INTO `tbbook` VALUES ('c primer plus', '84561897', 'Stephen Prata ', '可以借阅');
INSERT INTO `tbbook` VALUES ('数据库系统概论', '84951548', '王珊', '可以借阅');
INSERT INTO `tbbook` VALUES ('市场营销学', '95923165', '杨小红', '可以借阅');

-- ----------------------------
-- Table structure for tbborrow
-- ----------------------------
DROP TABLE IF EXISTS `tbborrow`;
CREATE TABLE `tbborrow`  (
  `bookName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookISBN` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bookAuthor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bookISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbborrow
-- ----------------------------
INSERT INTO `tbborrow` VALUES ('剑指offer', '74621951', '何海涛');

-- ----------------------------
-- Table structure for tbmanager
-- ----------------------------
DROP TABLE IF EXISTS `tbmanager`;
CREATE TABLE `tbmanager`  (
  `managerAccount` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `managerPassword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`managerAccount`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbmanager
-- ----------------------------

-- ----------------------------
-- Table structure for tbuser
-- ----------------------------
DROP TABLE IF EXISTS `tbuser`;
CREATE TABLE `tbuser`  (
  `UserAccount` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `UserPassword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`UserAccount`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbuser
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
