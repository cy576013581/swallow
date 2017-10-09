/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-10-09 14:15:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for calendars
-- ----------------------------
DROP TABLE IF EXISTS `calendars`;
CREATE TABLE `calendars` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `c_username` varchar(255) NOT NULL,
  `c_title` varchar(255) NOT NULL,
  `c_start` date NOT NULL,
  `c_end` date NOT NULL,
  `c_color` varchar(255) DEFAULT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of calendars
-- ----------------------------
INSERT INTO `calendars` VALUES ('21', 'admin', '大数据保护级别', '2017-08-02', '2017-08-03', '#3a87ad', '2017-08-29 19:13:35', '8', '2017-08-29 19:13:35', '8', '0');
INSERT INTO `calendars` VALUES ('22', 'admin', '任务二', '2017-08-11', '2017-08-12', '#3a87ad', '2017-08-29 19:13:42', '8', '2017-08-29 19:13:42', '8', '1');
INSERT INTO `calendars` VALUES ('23', 'admin', '恶趣味', '2017-08-11', '2017-08-12', 'rgb(209, 91, 71)', '2017-08-29 19:14:13', '8', '2017-08-29 19:16:36', '8', '0');
INSERT INTO `calendars` VALUES ('24', 'admin', '任务二', '2017-08-14', '2017-08-15', 'rgb(214, 72, 126)', '2017-08-29 19:16:46', '8', '2017-08-29 19:17:31', '8', '1');
INSERT INTO `calendars` VALUES ('25', 'admin', '热污染翁人', '2017-08-14', '2017-08-15', 'rgb(254, 225, 136)', '2017-08-29 19:17:41', '8', '2017-08-29 19:18:07', '8', '0');
INSERT INTO `calendars` VALUES ('26', 'admin', '默认日程', '2017-08-17', '2017-08-19', 'rgb(214, 72, 126)', '2017-08-29 19:18:15', '8', '2017-08-29 19:26:56', '8', '0');
INSERT INTO `calendars` VALUES ('27', 'admin', '3213', '2017-08-08', '2017-08-09', '#3a87ad', '2017-08-29 19:22:06', '8', '2017-08-29 19:22:06', '8', '1');
INSERT INTO `calendars` VALUES ('28', 'admin', '默认日程', '2017-08-25', '2017-08-26', 'rgb(58, 135, 173)', '2017-08-29 19:22:40', '8', '2017-08-29 19:22:40', '8', '1');
INSERT INTO `calendars` VALUES ('29', 'admin', '任务', '2017-08-26', '2017-08-27', '#3a87ad', '2017-08-29 19:40:27', '8', '2017-08-29 19:40:27', '8', '0');
INSERT INTO `calendars` VALUES ('30', 'admin', '国庆放假了呀！！！！！！！！！！！！！！！！！！', '2017-10-01', '2017-10-08', '#3a87ad', '2017-09-01 13:23:03', '8', '2017-09-01 13:23:03', '8', '0');
INSERT INTO `calendars` VALUES ('31', 'admin', '共高吼吼', '2017-09-06', '2017-09-07', '#3a87ad', '2017-09-23 09:51:48', '8', '2017-09-23 09:51:48', '8', '0');
INSERT INTO `calendars` VALUES ('32', 'admin', '9099', '2017-10-09', '2017-10-09', '#3a87ad', '2017-10-09 13:52:11', '8', '2017-10-09 13:52:11', '8', '0');
INSERT INTO `calendars` VALUES ('33', 'admin', '000', '2017-10-10', '2017-10-10', '#3a87ad', '2017-10-09 13:52:19', '8', '2017-10-09 13:52:19', '8', '0');

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `c_newFileName` varchar(255) NOT NULL,
  `c_oldFileName` varchar(255) NOT NULL,
  `c_src` varchar(255) DEFAULT NULL,
  `c_fileSize` varchar(255) NOT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of files
-- ----------------------------
INSERT INTO `files` VALUES ('1', 'jQuery EasyUI 1.4.5 版 API 中文版 (Made By Richie696)1504246312653.chm', 'jQuery EasyUI 1.4.5 版 API 中文版 (Made By Richie696).chm', 'f:/test', '1398030', '2017-09-01 14:11:52', '8', '2017-09-01 14:11:52', '8', '0');
INSERT INTO `files` VALUES ('2', 'ksolaunch1504246492740.exe', 'ksolaunch.exe', 'f:/test', '1231', '2017-09-01 14:14:52', '8', '2017-09-01 14:14:52', '8', '0');

-- ----------------------------
-- Table structure for loginrecord
-- ----------------------------
DROP TABLE IF EXISTS `loginrecord`;
CREATE TABLE `loginrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_username` varchar(255) NOT NULL,
  `c_loginIp` varchar(255) NOT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginrecord
-- ----------------------------
INSERT INTO `loginrecord` VALUES ('7', 'admin', '192.168.1.4', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `loginrecord` VALUES ('8', 'admin', '192.168.1.4', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `loginrecord` VALUES ('9', 'admin', '192.168.1.4', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `loginrecord` VALUES ('10', 'admin', '192.168.1.4', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `loginrecord` VALUES ('11', 'admin', '192.168.1.4', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `loginrecord` VALUES ('12', 'admin', '192.168.1.4', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `loginrecord` VALUES ('117', 'admin', '192.168.153.128', '2017-10-09 13:51:33', '8', '2017-10-09 13:51:33', '8', '0');
INSERT INTO `loginrecord` VALUES ('118', 'admin', '192.168.153.128', '2017-10-09 14:00:32', '8', '2017-10-09 14:00:32', '8', '0');
INSERT INTO `loginrecord` VALUES ('119', 'admin', '192.168.153.128', '2017-10-09 14:11:32', '8', '2017-10-09 14:11:32', '8', '0');
INSERT INTO `loginrecord` VALUES ('120', 'admin', '192.168.153.128', '2017-10-09 14:12:50', '8', '2017-10-09 14:12:50', '8', '0');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_permisCode` varchar(255) NOT NULL,
  `c_permisName` varchar(255) DEFAULT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'add', '添加', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_permission` VALUES ('2', 'del', '删除', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_permission` VALUES ('3', 'update', '更新', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_permission` VALUES ('4', 'list', '列表显示', '2017-08-01 11:00:05', '0', '2017-10-09 14:13:45', '8', '0');

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_roleCode` varchar(255) DEFAULT NULL,
  `c_roleName` varchar(255) NOT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('1', 'admin', '系统管理员', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_roles` VALUES ('2', 'manege', '管理员', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_roles` VALUES ('3', 'normal', '普通用户', '2017-08-01 11:00:05', '0', '2017-10-09 14:14:13', '8', '0');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `n_permission_id` bigint(20) NOT NULL,
  `n_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('3', '3', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '4', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '1', '2');
INSERT INTO `sys_role_permission` VALUES ('6', '2', '2');
INSERT INTO `sys_role_permission` VALUES ('7', '3', '2');
INSERT INTO `sys_role_permission` VALUES ('8', '4', '2');
INSERT INTO `sys_role_permission` VALUES ('9', '3', '3');
INSERT INTO `sys_role_permission` VALUES ('10', '1', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `n_userId` int(11) NOT NULL,
  `n_roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '8', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `c_username` varchar(255) NOT NULL,
  `c_pwd` varchar(255) NOT NULL,
  `c_phone` varchar(255) DEFAULT NULL,
  `n_age` int(11) NOT NULL,
  `n_sex` int(11) NOT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(11) DEFAULT NULL,
  `n_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('8', 'admin', 'c4ca4238a0b92382', '1', '12', '0', '2017-08-01 11:00:05', '8', '2017-09-23 10:47:57', '8', '0', '1');
