/*
 Navicat Premium Data Transfer

 Source Server         : 魏祯阿里云
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 47.94.144.44:3306
 Source Schema         : jx_pub

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 15/07/2020 22:46:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `admin_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `admin_password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `admin_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `admin_creat_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建时间',
  `admin_update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '管理员2', 'e10adc3949ba59abbe56e057f20f883e', '18574151356', '2020-01-28 14:21:08', '2020-01-28 14:21:08');
INSERT INTO `admin` VALUES (2, '管理员1', '08759fe1dab809071cb553bbaec5b5da', '18697730816', '2020-01-28 18:11:21', '2020-01-28 18:11:21');

-- ----------------------------
-- Table structure for lodger
-- ----------------------------
DROP TABLE IF EXISTS `lodger`;
CREATE TABLE `lodger`  (
  `lodger_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `lodger_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '入住人名称',
  `lodger_id_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号',
  `lodger_sex` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别（0：男，1：女）',
  `order_item_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单项id',
  `lodger_creat_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建时间（即入住时间）',
  `lodger_update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`lodger_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lodger
-- ----------------------------
INSERT INTO `lodger` VALUES ('069436dd18164a78b4a03e10963c39bc', '程鹏', '411422199988598658', '0', '08b918a4b4524264aa69a84aeb285050', '2020-07-12 10:56:26', '2020-07-12 10:56:26');
INSERT INTO `lodger` VALUES ('1ae4e5bf05d04776a59fe0d8d134cb1c', '听闻', '411422199988598658', '0', 'ffdf27e7f2cd4f00bd9f39c9a6426e79', '2020-07-12 10:51:57', '2020-07-12 10:51:57');
INSERT INTO `lodger` VALUES ('28b0b89a88f349bbbd6aea68240db56d', '从v', '123456789987456321', '0', '606c282bc2fd4788850c045b4f15e0ab', '2020-07-12 11:42:31', '2020-07-12 11:42:31');
INSERT INTO `lodger` VALUES ('443d0174ecf44481bfe2613ad41f031d', '魏祯', '411521199811232540', '1', 'e933aae382ee41e3a0e70510c317b778', '2020-03-21 03:03:55', '2020-03-21 03:03:55');
INSERT INTO `lodger` VALUES ('4ff325d2349c489697d73d262e1e74b7', '听闻', '411422199988598658', '0', '6a27664d70604cc2921b897899a4a798', '2020-07-12 10:53:14', '2020-07-12 10:53:14');
INSERT INTO `lodger` VALUES ('502f109ba7c9466bb00b9de95a49ef16', '听闻', '411422199988598659', '1', '08b918a4b4524264aa69a84aeb285050', '2020-07-12 10:56:26', '2020-07-12 10:56:26');
INSERT INTO `lodger` VALUES ('89410b2b07b24aa3acc7ca0e81ecc84b', '可可', '411521199811232540', '1', 'ef4e00e259084e2fa1f9c09a85631933', '2020-04-07 05:59:31', '2020-04-07 05:59:31');
INSERT INTO `lodger` VALUES ('919f55f4dbf94b47833b54914418d919', '听闻', '411422199988598658', '0', '244a3715577b4ae0ab26466acde12009', '2020-07-12 10:55:25', '2020-07-12 10:55:25');
INSERT INTO `lodger` VALUES ('91a2d2e980be475b95fc94f94525b9a7', '可开', '566987122599653240', '1', '1d06d165987747e0ac28c9433ca78d55', '2020-04-07 06:08:05', '2020-04-07 06:08:05');
INSERT INTO `lodger` VALUES ('999943c995804747a2874f441966a8a8', '卡卡', '455896699788563254', '1', 'ef4e00e259084e2fa1f9c09a85631933', '2020-04-07 05:59:31', '2020-04-07 05:59:31');
INSERT INTO `lodger` VALUES ('9d1adb67a9f34a11af81992c08dc0d4a', '开开', '411521566988123540', '0', 'c9cd9ab303f44b10908a0d6b210fea54', '2020-03-27 06:40:22', '2020-03-27 06:40:22');
INSERT INTO `lodger` VALUES ('9fce52f5b1754f98b81b46b0dd312efd', '乐乐', '411521199811232540', '0', 'c9cd9ab303f44b10908a0d6b210fea54', '2020-03-27 06:40:22', '2020-03-27 06:40:22');
INSERT INTO `lodger` VALUES ('a39af4c4476b4e3e8aae7f8dad41abd2', '听闻', '411422199988598658', '0', 'c83fc9d75a6640ad8e43f377748fafe5', '2020-07-12 10:55:50', '2020-07-12 10:55:50');
INSERT INTO `lodger` VALUES ('b41799994e7c48919bdffeca0e80f8d7', '开开', '411523699877453254', '0', 'af599e4d4832427ba8211c30824a50ef', '2020-03-27 06:31:47', '2020-03-27 06:31:47');
INSERT INTO `lodger` VALUES ('bf6b64a5eae94e2e945350ab60516431', '乐乐', '455219822199633574', '0', 'af599e4d4832427ba8211c30824a50ef', '2020-03-27 06:31:47', '2020-03-27 06:31:47');
INSERT INTO `lodger` VALUES ('bf843142555b46d99bd716b43c8c22c2', '听闻', '551465161551465161', '0', '3bf9b28218104f06ae41db450c736955', '2020-07-12 11:28:16', '2020-07-12 11:28:16');
INSERT INTO `lodger` VALUES ('bfd59e5afb5c4c28a01b68168460ffe5', '看我', '455669366811235420', '1', '1d06d165987747e0ac28c9433ca78d55', '2020-04-07 06:08:05', '2020-04-07 06:08:05');
INSERT INTO `lodger` VALUES ('c8f8a95a854b460298b80554fe02c174', '嗯嗯', '455623399655874520', '1', '4d60b1e5d44f494ab1f95f68e84595e7', '2020-04-07 06:10:33', '2020-04-07 06:10:33');
INSERT INTO `lodger` VALUES ('d5afe2bb512244e89331a2cc35df6820', '听闻', '411422199988598858', '0', 'd3d78e86da104545be181b054a67cfa6', '2020-07-12 10:46:20', '2020-07-12 10:46:20');
INSERT INTO `lodger` VALUES ('db928c2e9a1a4c318ef6a20be322feb5', '啦啦', '455696322577562540', '1', 'db4f1a55e1d4452aa6c61f1d6f2d4ad8', '2020-04-07 06:17:17', '2020-04-07 06:17:17');
INSERT INTO `lodger` VALUES ('fbbdb49a0ba1404f84ddbf5e449c215d', '可以', '411563388111565240', '1', '329876fd8bbd41fdb76b0ba944813665', '2020-04-07 06:24:18', '2020-04-07 06:24:18');
INSERT INTO `lodger` VALUES ('ffb78742ffce425f993c420590c43688', '可可', '455632188966541235', '1', 'e933aae382ee41e3a0e70510c317b778', '2020-03-21 03:03:55', '2020-03-21 03:03:55');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `item_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单id',
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间id',
  `reality_come_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实际入住时间',
  `reality_leave_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实际退房时间',
  `item_status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单项状态（0：入住，1：退房）',
  `item_creat_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建时间',
  `item_update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('08b918a4b4524264aa69a84aeb285050', 'f7f71a2f000d4e60823efb43baff6e04', '7aa366440de74509b380fa474237fd5d', '2020-07-12 10:56:26', '2020-07-13 12:00:00', '1', '2020-07-12 10:38:23', '2020-07-12 10:56:45');
INSERT INTO `order_item` VALUES ('1d06d165987747e0ac28c9433ca78d55', 'dad78b37aa1541dc9a9520fad19697bc', '7aa366440de74509b380fa474237fd5d', '2020-04-07 06:08:05', '2020-04-09 12:00:00', '1', '2020-04-07 06:06:44', '2020-04-09 07:57:26');
INSERT INTO `order_item` VALUES ('244a3715577b4ae0ab26466acde12009', 'c24193d3468f4602972b75d1d22c5ed5', 'dafb5bd23a2e40f1a3d4e0f178aca0ed', '2020-07-12 10:55:25', '2020-07-13 12:00:00', '1', '2020-07-12 10:49:59', '2020-07-12 10:56:32');
INSERT INTO `order_item` VALUES ('329876fd8bbd41fdb76b0ba944813665', '8f3338c693754c3b87a982280ae619b6', 'dafb5bd23a2e40f1a3d4e0f178aca0ed', '2020-04-07 06:24:18', '2020-04-09 12:00:00', '1', '2020-04-07 06:23:03', '2020-07-12 10:46:27');
INSERT INTO `order_item` VALUES ('3bf9b28218104f06ae41db450c736955', '25a649acfc9e441697ca1bd7ded755b4', '493dd4f5fb484cf5b9dca4e82f4ea684', '2020-07-12 11:28:16', '2020-07-13 12:00:00', '1', '2020-07-12 11:27:12', '2020-07-12 11:29:12');
INSERT INTO `order_item` VALUES ('4d60b1e5d44f494ab1f95f68e84595e7', '849010b8a63547e69d30302dbfbbe6ef', '3b256f4217bc4decb750e86ed261999e', '2020-04-07 06:10:33', '2020-03-28 12:00:00', '1', '2020-03-27 06:33:09', '2020-07-12 10:48:12');
INSERT INTO `order_item` VALUES ('606c282bc2fd4788850c045b4f15e0ab', 'c3aefbdbd27144989f6821856fb14261', 'c105304f93ad4df7b821e4743f74808a', '2020-07-12 11:42:31', '2020-07-13 12:00:00', '0', '2020-07-12 11:29:21', '2020-07-12 11:42:31');
INSERT INTO `order_item` VALUES ('6a27664d70604cc2921b897899a4a798', '920675be56594197885a550eeaa1ab6a', '493dd4f5fb484cf5b9dca4e82f4ea684', '2020-07-12 10:53:14', '2020-07-13 12:00:00', '1', '2020-07-12 10:36:43', '2020-07-12 10:56:43');
INSERT INTO `order_item` VALUES ('af599e4d4832427ba8211c30824a50ef', '36164ba5316040178944ca7c6c7f75ae', 'daa986c0e74d4b0fbcbf67d4f84a87cd', '2020-03-27 06:31:47', '2020-03-31 12:00:00', '1', '2020-03-27 06:31:47', '2020-03-27 06:32:20');
INSERT INTO `order_item` VALUES ('c83fc9d75a6640ad8e43f377748fafe5', '1bc6eb47170040aca0e36e426a2ddebd', '3f4ee73e6f294e6fb1302546bd79a098', '2020-07-12 10:55:50', '2020-07-13 12:00:00', '1', '2020-07-12 10:37:54', '2020-07-12 10:57:25');
INSERT INTO `order_item` VALUES ('c9cd9ab303f44b10908a0d6b210fea54', '45d80c50760a4c21b249a53ecb1ac309', '7aa366440de74509b380fa474237fd5d', '2020-03-27 06:40:22', '2020-03-28 12:00:00', '1', '2020-03-27 06:40:22', '2020-03-27 06:41:09');
INSERT INTO `order_item` VALUES ('d3d78e86da104545be181b054a67cfa6', '388916d853f24991a9ecdbaf9a0b8f1e', '493dd4f5fb484cf5b9dca4e82f4ea684', '2020-07-12 10:46:20', '2020-07-13 12:00:00', '1', '2020-07-12 10:46:20', '2020-07-12 10:46:30');
INSERT INTO `order_item` VALUES ('db4f1a55e1d4452aa6c61f1d6f2d4ad8', 'bfcce426ff9c4c8ab15a174277482e86', 'dafb5bd23a2e40f1a3d4e0f178aca0ed', '2020-04-07 06:17:17', '2020-04-09 12:00:00', '1', '2020-04-07 06:17:17', '2020-04-07 06:18:01');
INSERT INTO `order_item` VALUES ('e933aae382ee41e3a0e70510c317b778', '7392002b229e4030861655ea8c43f2c6', '3b256f4217bc4decb750e86ed261999e', '2020-03-21 03:03:55', '2020-03-22 12:00:00', '1', '2020-03-21 03:03:10', '2020-03-27 09:37:39');
INSERT INTO `order_item` VALUES ('ef4e00e259084e2fa1f9c09a85631933', 'e51894eb1fc04d209bbe176677f933c3', 'daa986c0e74d4b0fbcbf67d4f84a87cd', '2020-04-07 05:59:31', '2020-04-08 12:00:00', '1', '2020-04-07 05:59:31', '2020-04-07 06:00:26');
INSERT INTO `order_item` VALUES ('ffdf27e7f2cd4f00bd9f39c9a6426e79', 'ed911e6b6e174704b5d1d91fcea6efa1', '493dd4f5fb484cf5b9dca4e82f4ea684', '2020-07-12 10:51:57', '2020-07-14 12:00:00', '1', '2020-07-12 10:51:57', '2020-07-12 10:52:22');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id（ 线下0000 ）',
  `type_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房型id',
  `lodger_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '入住人姓名（ 线下---- ）',
  `lodger_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '入住人电话（ 线下---- ）',
  `reserve_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '预定房间数量（默认1）',
  `come_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预计入住时间（yyyy-MM-dd 14:00:00）',
  `leave_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预计退房时间（yyyy-MM-dd 12:00:00）',
  `room_price` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间价格',
  `order_price` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单价格',
  `order_reality_price` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实际价格',
  `order_show_status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户是否删除（0：未删除；1已删除）',
  `order_status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '订单状态（0：未入住；1：已入住；2：已完成；3：已删除）',
  `order_creat_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建时间',
  `order_update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1bc6eb47170040aca0e36e426a2ddebd', '5e39ead2659f4ff2a16377764ba69bd4', '982be7fd257e408d87bcc29959a44f62', '听闻', '18338709082', '1', '2020-07-12 14:00:00', '2020-07-13 12:00:00', '89', '89', '89', '0', '2', '2020-07-12 10:37:54', '2020-07-12 10:57:25');
INSERT INTO `orders` VALUES ('25a649acfc9e441697ca1bd7ded755b4', '5e39ead2659f4ff2a16377764ba69bd4', 'db929a622734433aaabe3e802fed6772', '听闻', '18338709082', '1', '2020-07-12 14:00:00', '2020-07-13 12:00:00', '235', '235', '235', '1', '2', '2020-07-12 11:27:12', '2020-07-13 02:11:48');
INSERT INTO `orders` VALUES ('36164ba5316040178944ca7c6c7f75ae', '0000', '2c439cfd692c468fbca91aede8248b04', '----', '----', '1', '2020-03-30 14:00:00', '2020-03-31 12:00:00', '228', '228', '228', '0', '2', '2020-03-27 06:31:47', '2020-03-27 06:32:20');
INSERT INTO `orders` VALUES ('388916d853f24991a9ecdbaf9a0b8f1e', '0000', 'db929a622734433aaabe3e802fed6772', '----', '----', '1', '2020-07-12 14:00:00', '2020-07-13 12:00:00', '235', '235', '235', '0', '2', '2020-07-12 10:46:20', '2020-07-12 10:46:30');
INSERT INTO `orders` VALUES ('45d80c50760a4c21b249a53ecb1ac309', '0000', '1b17bff1e0264a0894cdf5ccfc067846', '----', '----', '1', '2020-03-27 14:00:00', '2020-03-28 12:00:00', '356', '356', '356', '0', '2', '2020-03-27 06:40:22', '2020-03-27 06:41:09');
INSERT INTO `orders` VALUES ('7392002b229e4030861655ea8c43f2c6', '91cbc548502043b29a4b69a30099a178', 'e7474e4edefb4f528e265c12df49dfef', '魏祯', '18697730816', '1', '2020-03-21 14:00:00', '2020-03-22 12:00:00', '168', '168', '168', '0', '2', '2020-03-21 03:03:10', '2020-03-27 09:37:39');
INSERT INTO `orders` VALUES ('849010b8a63547e69d30302dbfbbe6ef', '91cbc548502043b29a4b69a30099a178', 'e7474e4edefb4f528e265c12df49dfef', '魏祯', '18697730816', '1', '2020-03-27 14:00:00', '2020-03-28 12:00:00', '168', '168', '168', '0', '2', '2020-03-27 06:33:09', '2020-07-12 10:48:12');
INSERT INTO `orders` VALUES ('8f3338c693754c3b87a982280ae619b6', '9486b5aa02bb46c2a683ef2a75d08b93', 'db929a622734433aaabe3e802fed6772', '魏一', '15698893654', '1', '2020-04-07 14:00:00', '2020-04-09 12:00:00', '235', '470', '470', '0', '2', '2020-04-07 06:23:03', '2020-07-12 10:46:27');
INSERT INTO `orders` VALUES ('920675be56594197885a550eeaa1ab6a', '5e39ead2659f4ff2a16377764ba69bd4', 'db929a622734433aaabe3e802fed6772', '听闻', '18338709082', '1', '2020-07-12 14:00:00', '2020-07-13 12:00:00', '235', '235', '235', '0', '2', '2020-07-12 10:36:43', '2020-07-12 10:56:43');
INSERT INTO `orders` VALUES ('bfcce426ff9c4c8ab15a174277482e86', '0000', 'db929a622734433aaabe3e802fed6772', '----', '----', '1', '2020-04-07 14:00:00', '2020-04-09 12:00:00', '235', '470', '470', '0', '2', '2020-04-07 06:17:17', '2020-04-07 06:18:01');
INSERT INTO `orders` VALUES ('c24193d3468f4602972b75d1d22c5ed5', '5e39ead2659f4ff2a16377764ba69bd4', 'db929a622734433aaabe3e802fed6772', '听闻', '18338709082', '1', '2020-07-12 14:00:00', '2020-07-13 12:00:00', '235', '235', '235', '0', '2', '2020-07-12 10:49:59', '2020-07-12 10:56:32');
INSERT INTO `orders` VALUES ('c3aefbdbd27144989f6821856fb14261', '5e39ead2659f4ff2a16377764ba69bd4', '6c24d1aedde544f19a66cee0bdfd7f99', '听闻', '18338709082', '1', '2020-07-12 14:00:00', '2020-07-13 12:00:00', '168', '168', '168', '0', '1', '2020-07-12 11:29:21', '2020-07-12 11:42:31');
INSERT INTO `orders` VALUES ('dad78b37aa1541dc9a9520fad19697bc', 'b2e75483b3ed439eb5e81fcdae39babb', '1b17bff1e0264a0894cdf5ccfc067846', '魏祯', '18598870259', '1', '2020-04-07 14:00:00', '2020-04-09 12:00:00', '236', '472', '472', '0', '2', '2020-04-07 06:06:44', '2020-04-09 07:57:26');
INSERT INTO `orders` VALUES ('e51894eb1fc04d209bbe176677f933c3', '0000', '2c439cfd692c468fbca91aede8248b04', '----', '----', '1', '2020-04-07 14:00:00', '2020-04-08 12:00:00', '228', '228', '228', '0', '2', '2020-04-07 05:59:31', '2020-04-07 06:00:26');
INSERT INTO `orders` VALUES ('ed911e6b6e174704b5d1d91fcea6efa1', '0000', 'db929a622734433aaabe3e802fed6772', '----', '----', '1', '2020-07-13 14:00:00', '2020-07-14 12:00:00', '235', '235', '256', '0', '2', '2020-07-12 10:51:57', '2020-07-12 10:52:22');
INSERT INTO `orders` VALUES ('f7f71a2f000d4e60823efb43baff6e04', '5e39ead2659f4ff2a16377764ba69bd4', '1b17bff1e0264a0894cdf5ccfc067846', '听闻', '18338709082', '1', '2020-07-12 14:00:00', '2020-07-13 12:00:00', '354', '354', '354', '1', '2', '2020-07-12 10:38:23', '2020-07-13 02:11:50');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `type_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型id',
  `room_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间号',
  `room_status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间状态 ( 0:未入住；1:已入住； )',
  `room_creat_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建时间',
  `room_update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('3b256f4217bc4decb750e86ed261999e', 'e7474e4edefb4f528e265c12df49dfef', '101', '0', '2020-03-21 02:52:28', '2020-07-12 10:48:12');
INSERT INTO `room` VALUES ('3f4ee73e6f294e6fb1302546bd79a098', '982be7fd257e408d87bcc29959a44f62', '112', '0', '2020-03-27 06:30:38', '2020-07-12 10:57:25');
INSERT INTO `room` VALUES ('493dd4f5fb484cf5b9dca4e82f4ea684', 'db929a622734433aaabe3e802fed6772', '115', '0', '2020-07-12 10:45:08', '2020-07-12 11:29:12');
INSERT INTO `room` VALUES ('7aa366440de74509b380fa474237fd5d', '1b17bff1e0264a0894cdf5ccfc067846', '114', '0', '2020-03-27 06:39:11', '2020-07-12 10:56:45');
INSERT INTO `room` VALUES ('957d77e01987405488031e27ff3ab174', '982be7fd257e408d87bcc29959a44f62', '106', '0', '2020-03-21 04:42:03', '2020-03-21 04:42:03');
INSERT INTO `room` VALUES ('c105304f93ad4df7b821e4743f74808a', '6c24d1aedde544f19a66cee0bdfd7f99', '103', '1', '2020-03-21 04:41:47', '2020-07-12 11:42:31');
INSERT INTO `room` VALUES ('daa986c0e74d4b0fbcbf67d4f84a87cd', '2c439cfd692c468fbca91aede8248b04', '126', '0', '2020-03-21 04:41:57', '2020-04-07 06:15:46');
INSERT INTO `room` VALUES ('dafb5bd23a2e40f1a3d4e0f178aca0ed', 'db929a622734433aaabe3e802fed6772', '136', '0', '2020-04-07 06:16:11', '2020-07-12 10:56:32');
INSERT INTO `room` VALUES ('e4374f1319374aa381ea562f35ce5534', '982be7fd257e408d87bcc29959a44f62', '158', '0', '2020-07-12 10:54:55', '2020-07-12 10:54:55');

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type`  (
  `type_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `type_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型名称',
  `type_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片地址',
  `type_price` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间价格',
  `type_area` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '面积（单位 平方米）',
  `type_window` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否有窗（0:无窗，1有窗）',
  `type_max_people` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最多居住人数',
  `type_breakfast` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否有早餐（0：无，1：有）',
  `type_bed` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '床铺信息',
  `type_creat_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type_update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES ('1b17bff1e0264a0894cdf5ccfc067846', '豪华套房', 'http://23wz.top:8888/group1/M00/00/01/rBECR159n16AQgERAAFQ1AhEEH0385.jpg', '354', '40', '1', '4', '1', '2.0米床一张', '2020-03-27 06:38:46', '2020-04-07 06:13:13');
INSERT INTO `room_type` VALUES ('2c439cfd692c468fbca91aede8248b04', 'ins公主房', 'http://23wz.top:8888/group1/M00/00/01/rBECR151mnqAds93AACQHDPKVNA210.jpg', '228', '30', '1', '2', '1', '1.8米床一张', '2020-03-21 04:39:59', '2020-03-21 04:39:59');
INSERT INTO `room_type` VALUES ('6c24d1aedde544f19a66cee0bdfd7f99', '豪华大床房', 'http://23wz.top:8888/group1/M00/00/01/rBECR151mqaALgkBAAHreUOlwfQ188.jpg', '168', '25', '1', '2', '0', '1.8米床一张', '2020-03-21 04:40:32', '2020-03-21 04:40:32');
INSERT INTO `room_type` VALUES ('982be7fd257e408d87bcc29959a44f62', '实惠单人床', 'http://23wz.top:8888/group1/M00/00/01/rBECR151mjKAL2-OAAFBHgpzk0Q571.jpg', '89', '15', '1', '1', '0', '1.2米床一张', '2020-03-21 04:38:34', '2020-03-21 04:38:34');
INSERT INTO `room_type` VALUES ('c590ea89412d435cbe40ef984ee5a6b7', '商务双人床', 'http://23wz.top:8888/group1/M00/00/01/rBECR151ms6AZDGfAAHPWnj7UPI168.jpg', '168', '25', '0', '2', '0', '1.5米床两张', '2020-03-21 04:41:19', '2020-03-27 06:29:04');
INSERT INTO `room_type` VALUES ('db929a622734433aaabe3e802fed6772', '人文书房', 'http://23wz.top:8888/group1/M00/00/01/rBECR16MGhaAVn4rAAGtczKMgqE785.jpg', '235', '18', '1', '2', '1', '2.2x1.8米床一张', '2020-04-07 06:14:14', '2020-07-12 10:43:39');
INSERT INTO `room_type` VALUES ('e7474e4edefb4f528e265c12df49dfef', '温馨榻榻米', 'http://23wz.top:8888/group1/M00/00/01/rBECR151gJGAbxqsAAEfg4b6PnA462.jpg', '168', '25', '1', '2', '0', '榻榻米一张', '2020-03-21 02:49:20', '2020-03-21 02:49:20');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '真实姓名',
  `user_id_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号',
  `user_nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `user_password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `user_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电话',
  `user_sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别',
  `user_creat_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建时间',
  `user_update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('230d6110f73d4b80a401644795f3d3db', '魏祯', '411521199811232542', '珂珂珂珂', 'e10adc3949ba59abbe56e057f20f883e', '18697730815', '1', '2020-04-30 08:13:23', '2020-04-30 08:13:23');
INSERT INTO `user` VALUES ('5e39ead2659f4ff2a16377764ba69bd4', '听闻', '411422199988598658', 'bruce', 'e10adc3949ba59abbe56e057f20f883e', '18338709082', '0', '2020-07-12 10:34:13', '2020-07-12 10:34:13');
INSERT INTO `user` VALUES ('91cbc548502043b29a4b69a30099a178', '魏祯', '411521199811232540', '可可喏', 'e10adc3949ba59abbe56e057f20f883e', '18697730816', '1', '2020-03-20 12:39:01', '2020-03-20 12:47:48');
INSERT INTO `user` VALUES ('9486b5aa02bb46c2a683ef2a75d08b93', '魏一', '455698755300123650', '一四', 'e10adc3949ba59abbe56e057f20f883e', '15698893654', '1', '2020-04-07 06:20:47', '2020-04-07 06:25:34');
INSERT INTO `user` VALUES ('b2e75483b3ed439eb5e81fcdae39babb', '魏祯', '455652199811232540', '啦啦', 'e10adc3949ba59abbe56e057f20f883e', '18598870259', '1', '2020-04-07 06:04:19', '2020-04-07 06:09:03');
INSERT INTO `user` VALUES ('effffa3b4b1843a78c9f8729b335848a', '方兴', '411521199703048930', 'faxon', '235a77522e686afc33fb89e65ade3205', '18574151356', '0', '2020-03-21 03:17:19', '2020-03-21 03:17:19');

SET FOREIGN_KEY_CHECKS = 1;
