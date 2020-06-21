/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : classmastersys

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-06-12 21:12:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Aname` varchar(12) NOT NULL,
  `Apassword` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`Aname`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cid` char(4) NOT NULL DEFAULT '',
  `Cname` varchar(100) NOT NULL,
  `Cintroduction` varchar(100) DEFAULT NULL,
  `Type` varchar(100) DEFAULT NULL,
  `belongcoll` varchar(100) DEFAULT NULL,
  `belongpro` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Cid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1001', 'C语言', 'C语言', '必修', '电子信息学院', '软件工程');
INSERT INTO `course` VALUES ('1002', '数据分析', 'python', '选修', '电子信息学院', '网络工程');
INSERT INTO `course` VALUES ('1003', '网络安全', '网络安全', '必修', '电子信息学院', '网络工程');
INSERT INTO `course` VALUES ('1004', '网络协议', '网络协议', '必修', '电子信息学院', '网络工程');
INSERT INTO `course` VALUES ('1005', '大学英语', '大学英语', '必修', '外国语学院', '英语');
INSERT INTO `course` VALUES ('1006', '计算机网络', '计算机网络', '必修', '电子信息学院', '网络工程');
INSERT INTO `course` VALUES ('1007', '软件工程', '软件工程', '必修', '电子信息学院', '软件工程');
INSERT INTO `course` VALUES ('1008', '操作系统', '操作系统', '必修', '电子信息学院', '网络工程');

-- ----------------------------
-- Table structure for courseplan
-- ----------------------------
DROP TABLE IF EXISTS `courseplan`;
CREATE TABLE `courseplan` (
  `Courseclass` varchar(12) NOT NULL,
  `coursetime` varchar(12) DEFAULT NULL,
  `courseweek` varchar(12) DEFAULT NULL,
  `cid` char(4) DEFAULT NULL,
  `tid` char(4) DEFAULT NULL,
  `classroom` varchar(6) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `Totalnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`Courseclass`) USING BTREE,
  KEY `cid` (`cid`) USING BTREE,
  KEY `tid` (`tid`) USING BTREE,
  CONSTRAINT `courseplan_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`Cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `courseplan_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `teacher` (`Tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of courseplan
-- ----------------------------
INSERT INTO `courseplan` VALUES ('大学英语', '12,34', '3', '1005', '0006', 'C教203', '5', '25', '30');
INSERT INTO `courseplan` VALUES ('操作系统1班', '78', '4', '1008', '0002', 'A教304', '5', '40', '40');
INSERT INTO `courseplan` VALUES ('数据分析1班', '34', '1', '1002', '0002', 'D教401', '5', '40', '40');
INSERT INTO `courseplan` VALUES ('网络协议1班', '12', '5', '1004', '0003', 'D教104', '5', '40', '40');
INSERT INTO `courseplan` VALUES ('网络安全1班', '34', '2', '1003', '0003', 'A教301', '5', '40', '40');
INSERT INTO `courseplan` VALUES ('计算机网络1班', '78', '2', '1006', '0004', 'A教302', '5', '40', '40');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` char(12) COLLATE utf8_bin NOT NULL,
  `cid` char(4) COLLATE utf8_bin DEFAULT NULL,
  `grade` int(3) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('3', '171003600117', '1001', '75', '5');
INSERT INTO `grade` VALUES ('5', '171003600118', '0011', '79', '5');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` char(4) DEFAULT NULL,
  `sid` char(12) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `cid` (`cid`) USING BTREE,
  KEY `sid` (`sid`) USING BTREE,
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`Cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student` (`Sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('86', '1001', '171003600117');
INSERT INTO `sc` VALUES ('94', '1005', '171003600117');
INSERT INTO `sc` VALUES ('95', '1003', '171003600117');
INSERT INTO `sc` VALUES ('96', '1006', '171003600117');
INSERT INTO `sc` VALUES ('98', '1008', '171003600118');
INSERT INTO `sc` VALUES ('99', '1008', '171003600117');
INSERT INTO `sc` VALUES ('100', '1008', '161003600119');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Sid` char(12) NOT NULL DEFAULT '',
  `Sname` varchar(20) NOT NULL,
  `Sidcard` char(18) NOT NULL,
  `Ssex` varchar(18) DEFAULT NULL,
  `Spassword` varchar(50) NOT NULL,
  `Sage` char(2) NOT NULL,
  `Classr` varchar(50) DEFAULT NULL,
  `profession` varchar(50) DEFAULT NULL,
  `college` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Sid`) USING BTREE,
  KEY `class` (`Classr`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('161003600119', '高翰', '1253333388877788', '男', '00000', '23', '网络1612', '网络工程', '电子信息学院');
INSERT INTO `student` VALUES ('171003600117', '沈建翌', '333344444555555555', '男', '123456', '21', '网络1711', '网络工程', '电子信息学院');
INSERT INTO `student` VALUES ('171003600118', '马冬梅', '6546546531316546', '女', '123456', '21', '国贸1712', '国际贸易', '商学院');
INSERT INTO `student` VALUES ('201507024125', '王境泽', '1405819961012622', '男', '123456', '22', '物联1711', '物联网', '电子信息学院');
INSERT INTO `student` VALUES ('201507024128', '李佳明', '8885456456498512', '女', '000000', '21', '网络1711', '网络工程', '电子信息学院');
INSERT INTO `student` VALUES ('201507024129', '严莉', '1525659875656223', '女', '000000', '24', '网络1611', '网络工程', '电子信息学院');
INSERT INTO `student` VALUES ('201807021196', '高丽丽', '1253333388877788', '女', '00000', '23', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807022128', '张明', '8885456456498512', '女', '000000', '21', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807023159', '张牛牛', '1525659875656223', '男', '000000', '24', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807024155', '秦汉', '1405819961012621', '男', '123456', '22', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807025126', '马超杨', '1253333388877788', '男', '00000', '23', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807025128', '黄焕', '8885456456498512', '男', '000000', '21', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807025129', '关琳', '1525659875656223', '女', '000000', '24', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807025135', '王泽', '1405819961012621', '男', '123456', '22', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807026156', '陈丽', '1253333388877788', '女', '00000', '23', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807027128', '李心', '8885456456498512', '女', '000000', '21', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807028149', '沈学东', '1525659875656223', '男', '000000', '24', '市销1611', '市场营销', '商学院');
INSERT INTO `student` VALUES ('201807029185', '王翰宇', '1405819961012621', '男', '123456', '22', '市销1611', '市场营销', '商学院');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Tid` char(4) NOT NULL DEFAULT '',
  `Tname` varchar(20) NOT NULL,
  `Tpassword` varchar(12) NOT NULL,
  `Tsex` varchar(10) DEFAULT NULL,
  `Introduction` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Tid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('0002', '张三', '123456', '男', '儒雅随和');
INSERT INTO `teacher` VALUES ('0003', '王勤', '123456', '女', '认真仔细');
INSERT INTO `teacher` VALUES ('0004', '陈艳艳', '123456', '女', '和蔼可亲');
INSERT INTO `teacher` VALUES ('0006', '李伟', '123456', '男', '无');
