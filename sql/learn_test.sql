/*
 Navicat Premium Data Transfer

 Source Server         : l
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : learn_test

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 25/12/2020 17:22:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_test
-- ----------------------------
DROP TABLE IF EXISTS `user_test`;
CREATE TABLE `user_test`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id(数据库自增)',
  `uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'uuid（后台定义）',
  `gmt_create` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间(时间戳)，格式为YY-MM-DD hh:mm:ss',
  `gmt_create_id` bigint(0) NULL DEFAULT 0 COMMENT '创建人id（系统默认为0）',
  `gmt_modified` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近修改时间(时间戳)，格式为YY-MM-DD hh:mm:ss',
  `gmt_modified_id` bigint(0) NULL DEFAULT 0 COMMENT '修改人id（系统默认为0）',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  `spare` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '预留字段（存储时可存储k-v格式的字符串）',
  `test_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '名称',
  `test_age` int(0) NULL DEFAULT 0 COMMENT '年龄',
  `test_gender` smallint(0) NULL DEFAULT 0 COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_test
-- ----------------------------
INSERT INTO `user_test` VALUES (46, NULL, '2020-12-25 12:02:22', 0, '2020-12-25 12:02:22', 0, 'aaaa', '', '测试名字-1119', 14, 0);
INSERT INTO `user_test` VALUES (49, NULL, '2020-10-21 11:23:08', 0, '2020-10-21 11:23:08', 0, '', '', '测试名字-2', 12, 0);
INSERT INTO `user_test` VALUES (50, NULL, '2020-10-21 11:27:14', 0, '2020-10-21 11:27:14', 0, '', '', '测试名字-2', 12, 0);
INSERT INTO `user_test` VALUES (51, NULL, '2020-12-25 17:16:27', 0, '2020-12-25 17:16:27', 0, 'aaaa', '', '测试名字-1119', 12, 0);

SET FOREIGN_KEY_CHECKS = 1;
