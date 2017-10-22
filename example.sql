/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-10-22 20:18:17
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
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8;

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
INSERT INTO `loginrecord` VALUES ('121', 'admin', '192.168.0.100', '2017-10-11 19:54:42', '8', '2017-10-11 19:54:42', '8', '0');
INSERT INTO `loginrecord` VALUES ('122', 'admin', '192.168.0.100', '2017-10-11 22:11:57', '8', '2017-10-11 22:11:57', '8', '0');
INSERT INTO `loginrecord` VALUES ('123', 'admin', '192.168.0.100', '2017-10-11 22:18:51', '8', '2017-10-11 22:18:51', '8', '0');
INSERT INTO `loginrecord` VALUES ('124', 'admin', '192.168.0.100', '2017-10-11 22:22:28', '8', '2017-10-11 22:22:28', '8', '0');
INSERT INTO `loginrecord` VALUES ('125', 'admin', '192.168.0.101', '2017-10-14 20:37:30', '8', '2017-10-14 20:37:30', '8', '0');
INSERT INTO `loginrecord` VALUES ('126', 'admin', '192.168.0.101', '2017-10-14 21:11:51', '8', '2017-10-14 21:11:51', '8', '0');
INSERT INTO `loginrecord` VALUES ('127', 'admin', '192.168.0.101', '2017-10-14 23:19:52', '8', '2017-10-14 23:19:52', '8', '0');
INSERT INTO `loginrecord` VALUES ('128', 'admin', '192.168.0.101', '2017-10-14 23:23:46', '8', '2017-10-14 23:23:46', '8', '0');
INSERT INTO `loginrecord` VALUES ('129', 'admin', '192.168.0.101', '2017-10-15 13:20:23', '8', '2017-10-15 13:20:23', '8', '0');
INSERT INTO `loginrecord` VALUES ('130', 'admin', '192.168.0.101', '2017-10-15 13:49:23', '8', '2017-10-15 13:49:23', '8', '0');
INSERT INTO `loginrecord` VALUES ('131', 'admin', '192.168.0.101', '2017-10-15 14:32:08', '8', '2017-10-15 14:32:08', '8', '0');
INSERT INTO `loginrecord` VALUES ('132', 'admin', '192.168.0.101', '2017-10-15 15:21:32', '8', '2017-10-15 15:21:32', '8', '0');
INSERT INTO `loginrecord` VALUES ('133', 'admin', '192.168.0.101', '2017-10-15 16:18:06', '8', '2017-10-15 16:18:06', '8', '0');
INSERT INTO `loginrecord` VALUES ('134', 'admin', '192.168.0.101', '2017-10-15 16:26:10', '8', '2017-10-15 16:26:10', '8', '0');
INSERT INTO `loginrecord` VALUES ('135', 'admin', '192.168.0.101', '2017-10-15 16:28:41', '8', '2017-10-15 16:28:41', '8', '0');
INSERT INTO `loginrecord` VALUES ('136', 'admin', '192.168.0.101', '2017-10-15 16:29:42', '8', '2017-10-15 16:29:42', '8', '0');
INSERT INTO `loginrecord` VALUES ('137', 'admin', '192.168.0.101', '2017-10-15 16:32:32', '8', '2017-10-15 16:32:32', '8', '0');
INSERT INTO `loginrecord` VALUES ('138', 'admin', '192.168.0.101', '2017-10-15 16:32:33', '8', '2017-10-15 16:32:33', '8', '0');
INSERT INTO `loginrecord` VALUES ('139', 'admin', '192.168.0.101', '2017-10-15 16:51:33', '8', '2017-10-15 16:51:33', '8', '0');
INSERT INTO `loginrecord` VALUES ('140', 'admin', '192.168.0.101', '2017-10-15 19:37:31', '8', '2017-10-15 19:37:31', '8', '0');
INSERT INTO `loginrecord` VALUES ('141', 'admin', '192.168.0.101', '2017-10-15 19:41:25', '8', '2017-10-15 19:41:25', '8', '0');
INSERT INTO `loginrecord` VALUES ('142', 'admin', '192.168.0.101', '2017-10-15 19:46:22', '8', '2017-10-15 19:46:22', '8', '0');
INSERT INTO `loginrecord` VALUES ('143', 'admin', '192.168.0.101', '2017-10-15 19:48:15', '8', '2017-10-15 19:48:15', '8', '0');
INSERT INTO `loginrecord` VALUES ('144', 'admin', '192.168.0.101', '2017-10-15 20:02:23', '8', '2017-10-15 20:02:23', '8', '0');
INSERT INTO `loginrecord` VALUES ('145', 'admin', '192.168.0.101', '2017-10-15 20:48:28', '8', '2017-10-15 20:48:28', '8', '0');
INSERT INTO `loginrecord` VALUES ('146', 'admin', '192.168.0.101', '2017-10-15 20:49:52', '8', '2017-10-15 20:49:52', '8', '0');
INSERT INTO `loginrecord` VALUES ('147', 'admin', '192.168.0.101', '2017-10-15 20:52:24', '8', '2017-10-15 20:52:24', '8', '0');
INSERT INTO `loginrecord` VALUES ('148', 'admin', '192.168.0.101', '2017-10-15 20:54:31', '8', '2017-10-15 20:54:31', '8', '0');
INSERT INTO `loginrecord` VALUES ('149', 'admin', '192.168.0.101', '2017-10-15 20:57:29', '8', '2017-10-15 20:57:29', '8', '0');
INSERT INTO `loginrecord` VALUES ('150', 'admin', '192.168.0.101', '2017-10-15 21:38:33', '8', '2017-10-15 21:38:33', '8', '0');
INSERT INTO `loginrecord` VALUES ('151', 'admin', '192.168.0.101', '2017-10-15 21:44:52', '8', '2017-10-15 21:44:52', '8', '0');
INSERT INTO `loginrecord` VALUES ('152', 'admin', '192.168.0.105', '2017-10-19 21:43:26', '8', '2017-10-19 21:43:26', '8', '0');
INSERT INTO `loginrecord` VALUES ('153', 'admin', '192.168.0.105', '2017-10-20 21:55:53', '8', '2017-10-20 21:55:53', '8', '0');
INSERT INTO `loginrecord` VALUES ('154', 'admin', '192.168.0.105', '2017-10-21 22:20:41', '8', '2017-10-21 22:20:41', '8', '0');
INSERT INTO `loginrecord` VALUES ('155', 'admin', '192.168.0.105', '2017-10-21 23:08:49', '8', '2017-10-21 23:08:49', '8', '0');
INSERT INTO `loginrecord` VALUES ('156', 'admin', '192.168.0.105', '2017-10-21 23:17:43', '8', '2017-10-21 23:17:43', '8', '0');
INSERT INTO `loginrecord` VALUES ('157', 'admin', '192.168.0.105', '2017-10-21 23:18:29', '8', '2017-10-21 23:18:29', '8', '0');
INSERT INTO `loginrecord` VALUES ('158', 'admin', '192.168.0.105', '2017-10-21 23:54:47', '8', '2017-10-21 23:54:47', '8', '0');
INSERT INTO `loginrecord` VALUES ('159', 'admin', '192.168.0.105', '2017-10-21 23:54:48', '8', '2017-10-21 23:54:48', '8', '0');
INSERT INTO `loginrecord` VALUES ('160', 'admin', '192.168.0.105', '2017-10-22 00:10:50', '8', '2017-10-22 00:10:50', '8', '0');
INSERT INTO `loginrecord` VALUES ('161', '1', '192.168.0.105', '2017-10-22 00:23:40', '9', '2017-10-22 00:23:40', '9', '0');
INSERT INTO `loginrecord` VALUES ('162', 'admin', '192.168.0.105', '2017-10-22 13:21:12', '8', '2017-10-22 13:21:12', '8', '0');
INSERT INTO `loginrecord` VALUES ('163', 'admin', '192.168.0.105', '2017-10-22 14:59:57', '8', '2017-10-22 14:59:57', '8', '0');
INSERT INTO `loginrecord` VALUES ('164', 'admin', '192.168.0.105', '2017-10-22 15:01:42', '8', '2017-10-22 15:01:42', '8', '0');
INSERT INTO `loginrecord` VALUES ('165', 'admin', '192.168.0.105', '2017-10-22 15:10:28', '8', '2017-10-22 15:10:28', '8', '0');
INSERT INTO `loginrecord` VALUES ('166', 'admin', '192.168.0.105', '2017-10-22 15:18:47', '8', '2017-10-22 15:18:47', '8', '0');
INSERT INTO `loginrecord` VALUES ('167', 'admin', '192.168.0.105', '2017-10-22 15:29:13', '8', '2017-10-22 15:29:13', '8', '0');
INSERT INTO `loginrecord` VALUES ('168', 'admin', '192.168.0.105', '2017-10-22 15:32:43', '8', '2017-10-22 15:32:43', '8', '0');
INSERT INTO `loginrecord` VALUES ('169', 'admin', '192.168.0.105', '2017-10-22 18:52:07', '8', '2017-10-22 18:52:07', '8', '0');
INSERT INTO `loginrecord` VALUES ('170', 'admin', '192.168.0.105', '2017-10-22 18:52:28', '8', '2017-10-22 18:52:28', '8', '0');
INSERT INTO `loginrecord` VALUES ('171', 'admin', '192.168.0.105', '2017-10-22 18:53:04', '8', '2017-10-22 18:53:04', '8', '0');
INSERT INTO `loginrecord` VALUES ('172', 'admin', '192.168.0.105', '2017-10-22 18:56:59', '8', '2017-10-22 18:56:59', '8', '0');
INSERT INTO `loginrecord` VALUES ('173', 'admin', '192.168.0.105', '2017-10-22 19:06:37', '8', '2017-10-22 19:06:37', '8', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `c_url` varchar(255) NOT NULL,
  `c_menuName` varchar(255) NOT NULL,
  `c_node` varchar(255) DEFAULT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('3', '', '系统设置', '[root]', '2017-10-22 15:12:32', '8', '2017-10-22 15:12:32', '8', '0');
INSERT INTO `sys_menu` VALUES ('4', '', '权限设置', '[root]', '2017-10-22 15:13:44', '8', '2017-10-22 15:13:44', '8', '0');
INSERT INTO `sys_menu` VALUES ('6', '/menu/calendarManage', '日程管理', '3', '2017-10-22 15:37:41', '0', '2017-10-22 16:40:39', '8', '0');
INSERT INTO `sys_menu` VALUES ('7', '/menu/loginRecordManage', '登录记录', '3', '2017-10-22 15:38:23', '0', '2017-10-22 16:35:51', '8', '0');
INSERT INTO `sys_menu` VALUES ('8', '/menu/userManage', '用户管理', '3', '2017-10-22 15:38:35', '8', '2017-10-22 15:38:35', '8', '0');
INSERT INTO `sys_menu` VALUES ('9', '/menu/permissionManage', '权限管理', '3', '2017-10-22 15:38:53', '8', '2017-10-22 15:38:53', '8', '0');
INSERT INTO `sys_menu` VALUES ('10', '/menu/roleManage', '角色管理', '3', '2017-10-22 15:39:09', '8', '2017-10-22 15:39:09', '8', '0');
INSERT INTO `sys_menu` VALUES ('11', '/menu/menuManage', '菜单管理', '3', '2017-10-22 15:39:21', '8', '2017-10-22 15:39:21', '8', '0');
INSERT INTO `sys_menu` VALUES ('12', '', '系统工具', '[root]', '2017-10-22 15:41:38', '0', '2017-10-22 15:41:46', '8', '0');
INSERT INTO `sys_menu` VALUES ('13', '/menu/uploadFile', '文件上传', '12', '2017-10-22 15:42:15', '8', '2017-10-22 15:42:15', '8', '0');
INSERT INTO `sys_menu` VALUES ('14', '/menu/user_roleManage', '用户关联角色', '4', '2017-10-22 15:42:36', '8', '2017-10-22 15:42:36', '8', '0');
INSERT INTO `sys_menu` VALUES ('15', '/menu/role_permisManage', '角色关联权限', '4', '2017-10-22 15:42:57', '8', '2017-10-22 15:42:57', '8', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'add', '添加', '2017-08-01 11:00:05', '0', '2017-10-11 19:55:20', '8', '0');
INSERT INTO `sys_permission` VALUES ('2', 'del', '删除', '2017-08-01 11:00:05', '0', '2017-10-11 19:55:17', '8', '0');
INSERT INTO `sys_permission` VALUES ('3', 'update', '更新', '2017-08-01 11:00:05', '0', '2017-10-11 19:55:11', '8', '0');
INSERT INTO `sys_permission` VALUES ('4', 'list', '列表显示', '2017-08-01 11:00:05', '0', '2017-10-09 14:13:45', '8', '0');
INSERT INTO `sys_permission` VALUES ('5', 'lock', '锁定', '2017-10-22 13:22:49', '8', '2017-10-22 13:22:49', '8', '0');

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
INSERT INTO `sys_roles` VALUES ('1', 'admin', '系统管理员', '2017-08-01 11:00:05', '0', '2017-10-11 19:55:23', '8', '0');
INSERT INTO `sys_roles` VALUES ('2', 'manege', '管理员', '2017-08-01 11:00:05', '0', '2017-10-11 19:55:26', '8', '0');
INSERT INTO `sys_roles` VALUES ('3', 'normal', '普通用户', '2017-08-01 11:00:05', '0', '2017-10-11 19:55:28', '8', '0');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `n_permisId` bigint(20) NOT NULL,
  `n_roleId` bigint(20) NOT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('3', '3', '1', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_role_permission` VALUES ('4', '4', '1', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_role_permission` VALUES ('10', '1', '1', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_role_permission` VALUES ('11', '2', '1', '2017-08-01 11:00:05', '8', '2017-08-01 11:00:05', '8', '0');
INSERT INTO `sys_role_permission` VALUES ('12', '5', '1', '2017-10-22 13:23:40', '8', '2017-10-22 13:23:40', '8', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `n_userId` int(11) NOT NULL,
  `n_roleId` int(11) NOT NULL,
  `c_createDate` varchar(255) DEFAULT NULL,
  `n_creater` bigint(20) DEFAULT NULL,
  `c_updateDate` varchar(255) DEFAULT NULL,
  `n_updater` bigint(20) DEFAULT NULL,
  `n_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '8', '1', '2017-08-01 11:00:05', '8', '2017-10-15 21:00:03', '8', '0');

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
  `n_status` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('8', 'admin', 'c4ca4238a0b92382', '1', '12', '1', '2017-08-01 11:00:05', '8', '2017-10-21 22:38:03', '8', '0', '1');
INSERT INTO `users` VALUES ('9', '1', 'c4ca4238a0b92382', '1', '111', '0', '2017-10-15 16:29:50', '8', '2017-10-22 13:21:49', '8', '0', '1');
