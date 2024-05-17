/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 14/01/2024 12:48:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`            int(0)                                                        NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '用户名',
    `password`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
    `email`         varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
    `role`          varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '角色',
    `register_time` datetime(0)                                                   NOT NULL COMMENT '注册时间',
    `update_time`   datetime(0)                                                   NOT NULL COMMENT '更新时间',
    `user_pic`      varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
    `nickname`      varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '昵称',
    `biography`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个人简介',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `unique_username` (`username`) USING BTREE,
    UNIQUE INDEX `unique_email` (`email`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account`
VALUES (2, 'hunter', '$2a$10$mrQFg7Y/18v1WNl3ESQGDeGqz9ed/kU5NeQQca2Zkq.NrgLMjjGqW', '123456@qq.com', 'user',
        '2024-01-06 23:38:59', '2024-01-10 15:17:43',
        'hello.png', 'hunter', 'hello');
INSERT INTO `account`
VALUES (3, 'hello', '$2a$10$ob4eJWvTNo6fvgJeAQiTeujduYSQBIJmCrvH5/KAIomWexnn8mflW', '1234567@qq.com', 'user',
        '2024-01-08 14:53:26', '2024-01-09 11:14:49', '大萨达', 'hunter', '123423');
INSERT INTO `account`
VALUES (4, 'hunt', '$2a$10$Zwn5VHg9SK2nuae7J58ek.Z/qD6xml2D4GTKQvHCiJF0aGJ0P/y42', '123456@outlook.com', 'user',
        '2024-01-10 16:26:20', '2024-01-10 16:26:20', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`
(
    `id`          int(0) UNSIGNED                                                 NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `title`       varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    NOT NULL COMMENT '文章标题',
    `content`     varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章内容',
    `cover_img`   varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '文章封面',
    `state`       varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NULL DEFAULT '草稿' COMMENT '文章状态: 只能是[已发布] 或者 [草稿]',
    `category_id` int(0) UNSIGNED                                                 NULL DEFAULT NULL COMMENT '文章分类ID',
    `create_user` int(0) UNSIGNED                                                 NOT NULL COMMENT '创建人ID',
    `create_time` datetime(0)                                                     NOT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                                     NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 25
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article`
VALUES (12, '风景画', '<p>阿萨德213</p>', '', '已发布', 34, 2, '2024-01-10 13:40:44', '2024-01-10 16:21:43');
INSERT INTO `article`
VALUES (13, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '草稿', 34, 2,
        '2024-01-10 15:25:17', '2024-01-10 15:25:17');
INSERT INTO `article`
VALUES (14, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 33, 2,
        '2024-01-10 15:28:19', '2024-01-10 15:28:19');
INSERT INTO `article`
VALUES (15, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 37, 2,
        '2024-01-10 15:28:35', '2024-01-10 15:28:35');
INSERT INTO `article`
VALUES (16, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 37, 2,
        '2024-01-10 15:28:36', '2024-01-10 15:28:36');
INSERT INTO `article`
VALUES (17, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 37, 2,
        '2024-01-10 15:28:37', '2024-01-10 15:28:37');
INSERT INTO `article`
VALUES (18, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 37, 2,
        '2024-01-10 15:28:37', '2024-01-10 15:28:37');
INSERT INTO `article`
VALUES (19, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 37, 2,
        '2024-01-10 15:28:38', '2024-01-10 15:28:38');
INSERT INTO `article`
VALUES (20, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 37, 2,
        '2024-01-10 15:28:38', '2024-01-10 15:28:38');
INSERT INTO `article`
VALUES (21, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 37, 2,
        '2024-01-10 15:28:39', '2024-01-10 15:28:39');
INSERT INTO `article`
VALUES (22, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 37, 2,
        '2024-01-10 15:28:50', '2024-01-10 15:28:50');
INSERT INTO `article`
VALUES (23, '陕西旅游攻略', '兵马俑,华清池,法门寺,华山...爱去哪去哪...',
        'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 38, 2,
        '2024-01-10 15:28:56', '2024-01-10 15:28:56');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`             int(0) UNSIGNED                                              NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `category_name`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
    `category_alias` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类别名',
    `create_user`    int(0) UNSIGNED                                              NOT NULL COMMENT '创建人ID',
    `create_time`    datetime(0)                                                  NOT NULL COMMENT '创建时间',
    `update_time`    datetime(0)                                                  NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `fk_category_user` (`create_user`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 40
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category`
VALUES (30, '人文', 'rwdsad', 2, '2024-01-10 13:37:17', '2024-01-10 16:27:41');
INSERT INTO `category`
VALUES (32, '健康类', '身体保健、健康生活、养生之道', 2, '2024-01-10 13:38:50', '2024-01-10 13:38:50');
INSERT INTO `category`
VALUES (33, '美食类', '美味佳肴、烹饪秘笈、美食天堂', 2, '2024-01-10 13:39:03', '2024-01-10 13:39:03');
INSERT INTO `category`
VALUES (34, '旅游类', '行万里路、旅行探险、风景如画', 2, '2024-01-10 13:39:13', '2024-01-10 13:39:13');
INSERT INTO `category`
VALUES (35, '时尚类', '潮流前沿、时尚达人、穿搭指南', 2, '2024-01-10 13:39:22', '2024-01-10 13:39:22');
INSERT INTO `category`
VALUES (36, '文学类', '诗情画意、文字之美、读书乐园', 2, '2024-01-10 13:39:30', '2024-01-10 13:39:30');
INSERT INTO `category`
VALUES (37, '艺术类', '创意之窗、艺术天地、美轮美奂', 2, '2024-01-10 13:39:42', '2024-01-10 13:39:42');
INSERT INTO `category`
VALUES (38, '教育类', '学无止境、教育资讯、培养未来', 2, '2024-01-10 13:39:51', '2024-01-10 13:39:51');
INSERT INTO `category`
VALUES (40, 'ds', 'dsa', 2, '2024-01-10 16:27:46', '2024-01-10 16:27:46');
