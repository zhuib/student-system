/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : db_student

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-07-11 20:52:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_classinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_classinfo`;
CREATE TABLE `tb_classinfo` (
  `cid` int(11) NOT NULL,
  `sclass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_classinfo
-- ----------------------------
INSERT INTO `tb_classinfo` VALUES ('1', '一班');
INSERT INTO `tb_classinfo` VALUES ('2', '二班');

-- ----------------------------
-- Table structure for tb_examkinds
-- ----------------------------
DROP TABLE IF EXISTS `tb_examkinds`;
CREATE TABLE `tb_examkinds` (
  `exam` varchar(20) DEFAULT NULL,
  `checka` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_examkinds
-- ----------------------------
INSERT INTO `tb_examkinds` VALUES ('英语', '考试');
INSERT INTO `tb_examkinds` VALUES ('语文', '考试');
INSERT INTO `tb_examkinds` VALUES ('数学', '考试');
INSERT INTO `tb_examkinds` VALUES ('政治', '考查');

-- ----------------------------
-- Table structure for tb_gradeinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_gradeinfo`;
CREATE TABLE `tb_gradeinfo` (
  `gid` int(11) DEFAULT NULL,
  `grade` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_gradeinfo
-- ----------------------------
INSERT INTO `tb_gradeinfo` VALUES ('1', '一班');
INSERT INTO `tb_gradeinfo` VALUES ('2', '二班');
INSERT INTO `tb_gradeinfo` VALUES ('3', '三班');

-- ----------------------------
-- Table structure for tb_gradeinfo_sub
-- ----------------------------
DROP TABLE IF EXISTS `tb_gradeinfo_sub`;
CREATE TABLE `tb_gradeinfo_sub` (
  `sid` int(11) NOT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `sclass` varchar(20) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `math` varchar(20) DEFAULT NULL,
  `chinese` varchar(20) DEFAULT NULL,
  `english` varchar(20) DEFAULT NULL,
  `politics` varchar(20) DEFAULT NULL,
  `chemistry` varchar(20) DEFAULT NULL,
  `physics` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_gradeinfo_sub
-- ----------------------------
INSERT INTO `tb_gradeinfo_sub` VALUES ('1', '初一', '一班', '赵一', '90', '80', '90', '80', '60', '75');
INSERT INTO `tb_gradeinfo_sub` VALUES ('2', '初一', '二班', '王一', '60', '75', '76', '90', '85', '95');
INSERT INTO `tb_gradeinfo_sub` VALUES ('3', '初一', '一班', '蔡一', '70', '60', '80', '94', '68', '60');
INSERT INTO `tb_gradeinfo_sub` VALUES ('4', '初二', '三班', '赵二', '78', '65', '44', '49', '77', '78');
INSERT INTO `tb_gradeinfo_sub` VALUES ('5', '初二', '三班', '王二', '98', '75', '69', '85', '46', '42');
INSERT INTO `tb_gradeinfo_sub` VALUES ('6', '初二', ' 二班', '蔡二', '44', '85', '66', '69', '98', '95');
INSERT INTO `tb_gradeinfo_sub` VALUES ('7', '初三', '二班', '赵三', '55', '91', '39', '32', '59', '91');
INSERT INTO `tb_gradeinfo_sub` VALUES ('8', '初三', '二班', '王三', '62', '45', '84', '79', '79', '61');
INSERT INTO `tb_gradeinfo_sub` VALUES ('9', '初三', '一班', '蔡三', '89', '11', '98', '99', '84', '99');

-- ----------------------------
-- Table structure for tb_studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_studentinfo`;
CREATE TABLE `tb_studentinfo` (
  `sid` int(20) DEFAULT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `sclass` varchar(20) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_studentinfo
-- ----------------------------
INSERT INTO `tb_studentinfo` VALUES ('2', '初一', '二班', '王一', '女', '13', '广州', '12345678910');
INSERT INTO `tb_studentinfo` VALUES ('3', '初一', '三班', '蔡一', '男', '13', '北京', '12344567788');
INSERT INTO `tb_studentinfo` VALUES ('4', '初二', '一班', '赵二', '男', '14', '广州', '12345687545');
INSERT INTO `tb_studentinfo` VALUES ('5', '初二', '二班', '王二', '女', '14', '广州', '15148745566');
INSERT INTO `tb_studentinfo` VALUES ('6', '初二', '三班', '蔡二', '男', '14', '上海', '14857864566');
INSERT INTO `tb_studentinfo` VALUES ('8', '初三', '二班', '王三', '男', '15', '广州', '12896521222');
INSERT INTO `tb_studentinfo` VALUES ('9', '初三', '一班', '张三', '男', '15', '北京', '1546782946');

-- ----------------------------
-- Table structure for tb_subject
-- ----------------------------
DROP TABLE IF EXISTS `tb_subject`;
CREATE TABLE `tb_subject` (
  `cid` int(11) NOT NULL,
  `course` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_subject
-- ----------------------------
INSERT INTO `tb_subject` VALUES ('1', '数学');
INSERT INTO `tb_subject` VALUES ('2', '英语');
INSERT INTO `tb_subject` VALUES ('3', '政治');
INSERT INTO `tb_subject` VALUES ('4', '物理');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `tid` int(11) NOT NULL,
  `tgrade` varchar(20) DEFAULT NULL,
  `tclass` varchar(20) DEFAULT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('1', '初一', '二班', '李老师', '女', '物理', '15489856488');
INSERT INTO `tb_teacher` VALUES ('2', '初三', '一班', '张老师', '男', '化学', '11234589555');
INSERT INTO `tb_teacher` VALUES ('3', '初一', '三班', '王老师', '男', '语文', '12545646552');
INSERT INTO `tb_teacher` VALUES ('4', '初二', '一班', '方老师', '女', '政治', '45456456441');
INSERT INTO `tb_teacher` VALUES ('5', '初一', '二班', '刘老师', '女', '数学', '52121315451');
INSERT INTO `tb_teacher` VALUES ('6', '初三', '三班', '邓老师', '男', '英语', '45644856415');
INSERT INTO `tb_teacher` VALUES ('7', '初三', '八班', '李老师·', '男', '物理', '156487923');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '张辉滨', '123', '1548947');
INSERT INTO `tb_user` VALUES ('2', '刘牧云', '123', '1546565');
INSERT INTO `tb_user` VALUES ('3', '陈昌浩', '123', '4165465');
INSERT INTO `tb_user` VALUES ('4', 'root', 'root', '1546285');
