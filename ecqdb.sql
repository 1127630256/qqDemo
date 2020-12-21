/*
Navicat MySQL Data Transfer

Source Server         : mysql8
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : ecqdb

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-12-21 15:39:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ecq_blood
-- ----------------------------
DROP TABLE IF EXISTS `ecq_blood`;
CREATE TABLE `ecq_blood` (
  `BloodId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `BloodType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '血型',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`BloodId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of ecq_blood
-- ----------------------------
INSERT INTO `ecq_blood` VALUES ('1', 'O', 'O型血');
INSERT INTO `ecq_blood` VALUES ('2', 'A', 'A型血');
INSERT INTO `ecq_blood` VALUES ('3', 'B', 'B型血');
INSERT INTO `ecq_blood` VALUES ('4', 'AB', 'AB型血');
INSERT INTO `ecq_blood` VALUES ('5', 'HR-阴', 'HR-阴性血');

-- ----------------------------
-- Table structure for ecq_friend_policy
-- ----------------------------
DROP TABLE IF EXISTS `ecq_friend_policy`;
CREATE TABLE `ecq_friend_policy` (
  `PolicyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `PolicyName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '规则名称',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`PolicyId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='添加好友规则表';

-- ----------------------------
-- Records of ecq_friend_policy
-- ----------------------------

-- ----------------------------
-- Table structure for ecq_friend_ships
-- ----------------------------
DROP TABLE IF EXISTS `ecq_friend_ships`;
CREATE TABLE `ecq_friend_ships` (
  `ShipId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `HostId` bigint(20) NOT NULL COMMENT '主人Id',
  `FriendId` bigint(20) NOT NULL COMMENT '好友id',
  `ShipType` int(11) DEFAULT NULL COMMENT '关系类型',
  `CreateDate` datetime DEFAULT NULL COMMENT '关系创建时间',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`ShipId`) USING BTREE,
  KEY `fk_hostId` (`HostId`) USING BTREE,
  KEY `fk_friendid` (`FriendId`) USING BTREE,
  CONSTRAINT `fk_friendid` FOREIGN KEY (`FriendId`) REFERENCES `ecq_users` (`userid`),
  CONSTRAINT `fk_hostId` FOREIGN KEY (`HostId`) REFERENCES `ecq_users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='好友关系表';

-- ----------------------------
-- Records of ecq_friend_ships
-- ----------------------------
INSERT INTO `ecq_friend_ships` VALUES ('1', '10001', '10003', '1', '2020-12-01 22:33:30', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('2', '10003', '10008', '2', '2020-12-21 01:08:16', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('3', '10008', '10009', '1', '2020-12-21 01:08:39', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('4', '10009', '10003', '2', '2020-12-21 01:08:48', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('5', '10008', '10003', '1', '2020-12-21 01:09:20', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('6', '10008', '10003', '2', '2020-12-21 01:09:39', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('7', '10008', '10008', '1', '2020-12-21 01:09:57', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('8', '10007', '10009', '2', '2020-12-21 01:10:19', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('9', '10007', '10008', '1', '2020-12-21 01:11:11', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('10', '10007', '10007', '1', '2020-12-21 01:12:19', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('11', '10007', '10008', '1', '2020-12-21 01:12:27', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('12', '10007', '10010', '1', '2020-12-21 01:13:59', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('13', '10007', '10011', '1', '2020-12-21 01:17:06', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('14', '10007', '10014', '2', '2020-12-21 01:17:31', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('15', '10007', '10015', '1', '2020-12-21 01:17:50', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('16', '10007', '10016', '1', '2020-12-21 01:18:11', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('17', '10007', '10016', '2', '2020-12-21 01:18:34', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('18', '10007', '10017', '2', '2020-12-21 01:18:56', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('19', '10007', '10018', '2', '2020-12-21 01:19:14', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('20', '10007', '10019', '2', '2020-12-21 01:19:36', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('21', '10007', '10020', '2', '2020-12-21 01:20:06', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('22', '10007', '10021', '2', '2020-12-21 01:20:25', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('23', '10007', '1', '1', '2020-12-21 01:20:46', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('24', '10007', '10001', '2', '2020-12-21 01:21:00', '好友');
INSERT INTO `ecq_friend_ships` VALUES ('25', '10007', '10003', '2', '2020-12-21 01:21:14', '好友');

-- ----------------------------
-- Table structure for ecq_messages
-- ----------------------------
DROP TABLE IF EXISTS `ecq_messages`;
CREATE TABLE `ecq_messages` (
  `MessageId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `FromId` bigint(20) NOT NULL COMMENT '发送者ID',
  `ToId` bigint(20) NOT NULL COMMENT '接收者ID',
  `Message` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息文本',
  `MessageType` int(11) NOT NULL COMMENT '消息类型',
  `MessageState` int(11) NOT NULL COMMENT '消息状态',
  `SendTime` timestamp NOT NULL COMMENT '消息发送时间',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`MessageId`) USING BTREE,
  KEY `fk_fromId` (`FromId`) USING BTREE,
  KEY `fk_toId` (`ToId`) USING BTREE,
  KEY `fk_messageType` (`MessageType`) USING BTREE,
  KEY `fk_messageState` (`MessageState`) USING BTREE,
  CONSTRAINT `fk_fromId` FOREIGN KEY (`FromId`) REFERENCES `ecq_users` (`userid`),
  CONSTRAINT `fk_messageState` FOREIGN KEY (`MessageState`) REFERENCES `ecq_message_state` (`stateid`),
  CONSTRAINT `fk_messageType` FOREIGN KEY (`MessageType`) REFERENCES `ecq_message_type` (`typeid`),
  CONSTRAINT `fk_toId` FOREIGN KEY (`ToId`) REFERENCES `ecq_users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='消息记录表';

-- ----------------------------
-- Records of ecq_messages
-- ----------------------------
INSERT INTO `ecq_messages` VALUES ('1', '10008', '10001', '有空一起踢球', '1', '1', '2000-01-13 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('2', '10003', '1', '如果你因为错过太阳而流泪，那么你也将错过月亮和星星', '1', '2', '2002-02-02 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('3', '10009', '10010', '床前明月光，疑是地上霜！', '1', '1', '2003-02-09 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('4', '1', '10001', '无耻之徒，赶快充钱！反正我血亏！', '1', '1', '2004-04-25 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('5', '1', '10007', '你的皮肤好好卖啊！', '1', '2', '2005-02-28 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('6', '10010', '10009', '生日快乐！', '1', '2', '2008-02-04 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('7', '1', '10003', '奥运联名皮肤开售了，快充钱啊！', '1', '1', '2008-08-08 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('8', '10010', '1', '我的音乐会门票也开售了，快来抢购啊！', '1', '1', '2013-03-04 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('9', '10003', '10009', '兄弟，你的诗写的是真滴好！', '1', '2', '2020-12-05 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('10', '10009', '10003', '那必然的，充钱了', '1', '2', '2020-12-06 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('11', '10003', '10009', '牛皮，你是富二代吗', '1', '2', '2020-12-07 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('12', '10009', '10003', '不是，我偷偷赊的账', '1', '2', '2020-12-08 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('13', '10003', '10009', '偷？', '1', '2', '2020-12-09 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('14', '10009', '10003', '读书人的事，怎么能叫偷呢？？', '1', '2', '2020-12-10 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('15', '10003', '10009', '鲁迅会告你侵权的！！！', '1', '2', '2020-12-11 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('16', '10009', '10003', '没事，我家开法院的！', '1', '2', '2020-12-17 00:00:00', null);
INSERT INTO `ecq_messages` VALUES ('17', '10011', '10009', '祝大哥：吉时吉月喜如风，丰年丰月如风筝，争福争财争长寿，寿山寿海寿长生，生福生财生贵子，子孝孙贤代代荣，荣华富贵年年有，有钱有势有前程！！有！前！程！！！', '1', '1', '2020-12-17 13:00:00', null);

-- ----------------------------
-- Table structure for ecq_message_state
-- ----------------------------
DROP TABLE IF EXISTS `ecq_message_state`;
CREATE TABLE `ecq_message_state` (
  `StateId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `StateName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '消息状态',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`StateId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='消息状态表';

-- ----------------------------
-- Records of ecq_message_state
-- ----------------------------
INSERT INTO `ecq_message_state` VALUES ('1', '未读', '未读消息');
INSERT INTO `ecq_message_state` VALUES ('2', '已读', '已读消息');

-- ----------------------------
-- Table structure for ecq_message_type
-- ----------------------------
DROP TABLE IF EXISTS `ecq_message_type`;
CREATE TABLE `ecq_message_type` (
  `TypeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `TypeName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '消息类型',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`TypeId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='消息类型表';

-- ----------------------------
-- Records of ecq_message_type
-- ----------------------------
INSERT INTO `ecq_message_type` VALUES ('1', '文本', '文本消息');
INSERT INTO `ecq_message_type` VALUES ('2', '图片', '图片消息');
INSERT INTO `ecq_message_type` VALUES ('3', '语音', '语音消息');

-- ----------------------------
-- Table structure for ecq_ship_type
-- ----------------------------
DROP TABLE IF EXISTS `ecq_ship_type`;
CREATE TABLE `ecq_ship_type` (
  `ShipTypeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系类型，自动编号',
  `ShipName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '好友关系',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`ShipTypeId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='好友关系类型表';

-- ----------------------------
-- Records of ecq_ship_type
-- ----------------------------
INSERT INTO `ecq_ship_type` VALUES ('1', '普通', '普通好友');
INSERT INTO `ecq_ship_type` VALUES ('2', '特别关心', '特别关心好友');
INSERT INTO `ecq_ship_type` VALUES ('3', '陌生', '陌生人');
INSERT INTO `ecq_ship_type` VALUES ('4', '拉黑', '黑名单好友');
INSERT INTO `ecq_ship_type` VALUES ('5', '情侣', '情侣');

-- ----------------------------
-- Table structure for ecq_star
-- ----------------------------
DROP TABLE IF EXISTS `ecq_star`;
CREATE TABLE `ecq_star` (
  `StarId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `StarName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '星座名称',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`StarId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='星座表';

-- ----------------------------
-- Records of ecq_star
-- ----------------------------
INSERT INTO `ecq_star` VALUES ('1', '白羊座', '3.21-4.20');
INSERT INTO `ecq_star` VALUES ('2', '金牛座', '4.21-5.21');
INSERT INTO `ecq_star` VALUES ('3', '双子座', '5.22-6.21');
INSERT INTO `ecq_star` VALUES ('4', '巨蟹座', '6.22-7.22');
INSERT INTO `ecq_star` VALUES ('5', '狮子座', '7.23-8.23');
INSERT INTO `ecq_star` VALUES ('6', '处女座', '8.24-9.23');
INSERT INTO `ecq_star` VALUES ('7', '天枰座', '9.24-10.23');
INSERT INTO `ecq_star` VALUES ('8', '天蝎座', '10.24-11.22');
INSERT INTO `ecq_star` VALUES ('9', '射手座', '11.23-12.21');
INSERT INTO `ecq_star` VALUES ('10', '魔羯座', '12.22-1.20');
INSERT INTO `ecq_star` VALUES ('11', '水瓶座', '1.21-2.19');
INSERT INTO `ecq_star` VALUES ('12', '双鱼座', '2.20-3.20');

-- ----------------------------
-- Table structure for ecq_state
-- ----------------------------
DROP TABLE IF EXISTS `ecq_state`;
CREATE TABLE `ecq_state` (
  `StateId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `StateName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态名',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态描述',
  PRIMARY KEY (`StateId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户状态表';

-- ----------------------------
-- Records of ecq_state
-- ----------------------------
INSERT INTO `ecq_state` VALUES ('1', 'online', '在线');
INSERT INTO `ecq_state` VALUES ('2', 'busy', '忙碌');
INSERT INTO `ecq_state` VALUES ('3', 'hidden', '隐身');
INSERT INTO `ecq_state` VALUES ('4', 'noOnline', '离线');

-- ----------------------------
-- Table structure for ecq_users
-- ----------------------------
DROP TABLE IF EXISTS `ecq_users`;
CREATE TABLE `ecq_users` (
  `UserId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID自动编号',
  `NickName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '昵称',
  `LoginPwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '登录密码',
  `State` int(11) NOT NULL COMMENT '用户当前状态',
  `FacePath` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像路径',
  `RgeDate` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  `Age` int(11) DEFAULT NULL COMMENT '年龄',
  `Sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `Star` int(11) NOT NULL COMMENT '星座',
  `Blood` int(11) NOT NULL COMMENT '血型',
  `RealName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '真实姓名',
  `FriendPolicy` int(11) DEFAULT NULL COMMENT '好友添加的规则',
  `Memo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`UserId`) USING BTREE,
  KEY `fk_Star` (`Star`) USING BTREE,
  KEY `fk_blood` (`Blood`) USING BTREE,
  KEY `fk_state` (`State`) USING BTREE,
  CONSTRAINT `fk_Star` FOREIGN KEY (`Star`) REFERENCES `ecq_star` (`starid`),
  CONSTRAINT `fk_blood` FOREIGN KEY (`Blood`) REFERENCES `ecq_blood` (`bloodid`),
  CONSTRAINT `fk_state` FOREIGN KEY (`State`) REFERENCES `ecq_state` (`stateid`)
) ENGINE=InnoDB AUTO_INCREMENT=10023 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

-- ----------------------------
-- Records of ecq_users
-- ----------------------------
INSERT INTO `ecq_users` VALUES ('1', '麻花疼', '1', '1', null, '1999-02-01 00:00:00', '49', '男', '8', '1', '麻花真的疼', null, '111');
INSERT INTO `ecq_users` VALUES ('10001', '司徒李', 'stl', '1', null, '2000-01-01 00:00:00', '30', '男', '9', '3', '李司徒', null, '111');
INSERT INTO `ecq_users` VALUES ('10003', '泰戈尔', 'tge', '2', null, '2006-02-26 00:00:00', '159', '男', '2', '1', '拉宾德拉纳特·泰戈尔', null, '111');
INSERT INTO `ecq_users` VALUES ('10007', '梅西', 'mx', '4', null, '2001-04-05 00:00:00', '33', '男', '4', '2', '里奥·梅西', null, '111');
INSERT INTO `ecq_users` VALUES ('10008', '居里夫人', 'jlfr', '3', null, '2020-12-17 00:00:00', '153', '女', '8', '4', '玛丽·居里', null, '111');
INSERT INTO `ecq_users` VALUES ('10009', '青莲居居', 'lb', '4', null, '2019-09-10 00:00:00', '1319', '男', '11', '4', '李白', null, '111');
INSERT INTO `ecq_users` VALUES ('10010', '欧阳娜娜', 'oynn', '3', null, '2000-06-15 00:00:00', '20', '女', '3', '2', '娜比', null, '111');
INSERT INTO `ecq_users` VALUES ('10011', '貂小蝉', 'dxc', '2', null, '2020-12-17 00:00:00', '0', '女', '7', '3', '貂蝉', null, '111');
INSERT INTO `ecq_users` VALUES ('10014', '梦歆婷', '123456', '2', null, '2020-12-21 01:06:26', '20', '女', '3', '4', '梦歆婷', null, '111');
INSERT INTO `ecq_users` VALUES ('10015', ' 水月幽', '123456', '3', null, '2020-12-21 01:07:44', '21', '女', '8', '5', ' 水月幽', null, '111');
INSERT INTO `ecq_users` VALUES ('10016', '巧克莉', '123456', '1', null, '2020-12-21 01:08:25', '20', '女', '4', '3', '巧克莉', null, '111');
INSERT INTO `ecq_users` VALUES ('10017', '夜星辰', '123456', '4', null, '2020-12-21 01:09:44', '19', '男', '5', '2', '夜星辰', null, '111');
INSERT INTO `ecq_users` VALUES ('10018', '恋丝田', '123456', '2', null, '2020-12-21 01:10:26', '20', '女', '9', '4', '恋丝田', null, '111');
INSERT INTO `ecq_users` VALUES ('10019', '闪银', '123456', '3', null, '2020-12-21 01:12:03', '20', '男', '8', '3', '闪银', null, '111');
INSERT INTO `ecq_users` VALUES ('10020', '雪莹', '123456', '4', null, '2020-12-21 01:12:48', '21', '女', '4', '4', '雪莹', null, '111');
INSERT INTO `ecq_users` VALUES ('10021', '粉色吻痕', '123456', '4', null, '2020-12-21 01:13:46', '20', '女', '6', '5', '粉色吻痕', null, '111');
INSERT INTO `ecq_users` VALUES ('10022', 'Admin', '123456', '1', 'null', '2020-12-21 11:27:55', '20', '1', '1', '1', 'xuetang9', null, 'test');
