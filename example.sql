/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-12-08 17:25:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for act_evt_log
-- ----------------------------
DROP TABLE IF EXISTS `act_evt_log`;
CREATE TABLE `act_evt_log` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_evt_log
-- ----------------------------

-- ----------------------------
-- Table structure for act_ge_bytearray
-- ----------------------------
DROP TABLE IF EXISTS `act_ge_bytearray`;
CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ge_bytearray
-- ----------------------------

-- ----------------------------
-- Table structure for act_ge_property
-- ----------------------------
DROP TABLE IF EXISTS `act_ge_property`;
CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ge_property
-- ----------------------------
INSERT INTO `act_ge_property` VALUES ('next.dbid', '1', '1');
INSERT INTO `act_ge_property` VALUES ('schema.history', 'create(5.22.0.0)', '1');
INSERT INTO `act_ge_property` VALUES ('schema.version', '5.22.0.0', '1');

-- ----------------------------
-- Table structure for act_hi_actinst
-- ----------------------------
DROP TABLE IF EXISTS `act_hi_actinst`;
CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_hi_actinst
-- ----------------------------

-- ----------------------------
-- Table structure for act_hi_attachment
-- ----------------------------
DROP TABLE IF EXISTS `act_hi_attachment`;
CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_hi_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for act_hi_comment
-- ----------------------------
DROP TABLE IF EXISTS `act_hi_comment`;
CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_hi_comment
-- ----------------------------

-- ----------------------------
-- Table structure for act_hi_detail
-- ----------------------------
DROP TABLE IF EXISTS `act_hi_detail`;
CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_hi_detail
-- ----------------------------

-- ----------------------------
-- Table structure for act_hi_identitylink
-- ----------------------------
DROP TABLE IF EXISTS `act_hi_identitylink`;
CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_hi_identitylink
-- ----------------------------

-- ----------------------------
-- Table structure for act_hi_procinst
-- ----------------------------
DROP TABLE IF EXISTS `act_hi_procinst`;
CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_hi_procinst
-- ----------------------------

-- ----------------------------
-- Table structure for act_hi_taskinst
-- ----------------------------
DROP TABLE IF EXISTS `act_hi_taskinst`;
CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_hi_taskinst
-- ----------------------------

-- ----------------------------
-- Table structure for act_hi_varinst
-- ----------------------------
DROP TABLE IF EXISTS `act_hi_varinst`;
CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_hi_varinst
-- ----------------------------

-- ----------------------------
-- Table structure for act_id_group
-- ----------------------------
DROP TABLE IF EXISTS `act_id_group`;
CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_id_group
-- ----------------------------

-- ----------------------------
-- Table structure for act_id_info
-- ----------------------------
DROP TABLE IF EXISTS `act_id_info`;
CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_id_info
-- ----------------------------

-- ----------------------------
-- Table structure for act_id_membership
-- ----------------------------
DROP TABLE IF EXISTS `act_id_membership`;
CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_id_membership
-- ----------------------------

-- ----------------------------
-- Table structure for act_id_user
-- ----------------------------
DROP TABLE IF EXISTS `act_id_user`;
CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_id_user
-- ----------------------------

-- ----------------------------
-- Table structure for act_procdef_info
-- ----------------------------
DROP TABLE IF EXISTS `act_procdef_info`;
CREATE TABLE `act_procdef_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_procdef_info
-- ----------------------------

-- ----------------------------
-- Table structure for act_re_deployment
-- ----------------------------
DROP TABLE IF EXISTS `act_re_deployment`;
CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_re_deployment
-- ----------------------------

-- ----------------------------
-- Table structure for act_re_model
-- ----------------------------
DROP TABLE IF EXISTS `act_re_model`;
CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_re_model
-- ----------------------------

-- ----------------------------
-- Table structure for act_re_procdef
-- ----------------------------
DROP TABLE IF EXISTS `act_re_procdef`;
CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_re_procdef
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_event_subscr
-- ----------------------------
DROP TABLE IF EXISTS `act_ru_event_subscr`;
CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ru_event_subscr
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_execution
-- ----------------------------
DROP TABLE IF EXISTS `act_ru_execution`;
CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ru_execution
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_identitylink
-- ----------------------------
DROP TABLE IF EXISTS `act_ru_identitylink`;
CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ru_identitylink
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_job
-- ----------------------------
DROP TABLE IF EXISTS `act_ru_job`;
CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ru_job
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_task
-- ----------------------------
DROP TABLE IF EXISTS `act_ru_task`;
CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ru_task
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_variable
-- ----------------------------
DROP TABLE IF EXISTS `act_ru_variable`;
CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ru_variable
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_menu` VALUES ('16', '', '工作流', '[root]', '2017-12-07 19:09:08', '8', '2017-12-07 19:09:08', '8', '0');
INSERT INTO `sys_menu` VALUES ('17', '/menu/workflow/deployManage', '部署管理', '16', '2017-12-07 19:09:37', '0', '2017-12-08 09:38:09', '8', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
  `c_email` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('8', 'admin', 'c4ca4238a0b92382', 'pjchenyang@qq.com', '1', '12', '1', '2017-08-01 11:00:05', '8', '2017-11-26 16:12:31', '8', '0', '1');
INSERT INTO `users` VALUES ('9', '1', 'c4ca4238a0b92382', '1323', '1', '111', '0', '2017-10-15 16:29:50', '8', '2017-11-26 15:49:12', '8', '0', '0');
