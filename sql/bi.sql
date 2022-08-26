/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : bi

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-08-26 11:30:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuNo` int(255) NOT NULL,
  `studName` char(30) CHARACTER SET utf8 NOT NULL,
  `sex` char(2) CHARACTER SET utf8 NOT NULL,
  `nation` varchar(255) CHARACTER SET utf8 NOT NULL,
  `political` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `school` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `entranceTime` date DEFAULT NULL,
  PRIMARY KEY (`stuNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('101101', '张丰', '男', '汉族', '群众', '1995-05-20', '动物科技学院', '草业科学', '2017-09-01');
INSERT INTO `student` VALUES ('101102', '刘泽民', '男', '汉族', '群众', '1995-08-23', '动物科技学院', '草业科学', '2017-09-01');
INSERT INTO `student` VALUES ('101103', '谢泳桦', '女', '汉族', '共青团员', '1994-12-12', '植物保护学院', '制药工程', '2017-09-01');
INSERT INTO `student` VALUES ('101105', '朱安琪', '女', '汉族', '共青团员', '1995-04-04', '信息工程学院', '信息管理与信息系统', '2017-09-01');
