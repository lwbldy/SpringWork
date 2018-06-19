

DROP TABLE IF EXISTS `blog_content`;

CREATE TABLE `blog_content` (
  `cid` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) DEFAULT NULL COMMENT '标题',
  `slug` VARCHAR(255) DEFAULT NULL,
  `created` BIGINT(20) DEFAULT NULL COMMENT '创建人id',
  `modified` BIGINT(20) DEFAULT NULL COMMENT '最近修改人id',
  `content` TEXT COMMENT '内容',
  `type` VARCHAR(16) DEFAULT NULL COMMENT '类型',
  `tags` VARCHAR(200) DEFAULT NULL COMMENT '标签',
  `categories` VARCHAR(200) DEFAULT NULL COMMENT '分类',
  `hits` INT(5) DEFAULT NULL,
  `comments_num` INT(5) DEFAULT '0' COMMENT '评论数量',
  `allow_comment` INT(1) DEFAULT '0' COMMENT '开启评论',
  `allow_ping` INT(1) DEFAULT '0' COMMENT '允许ping',
  `allow_feed` INT(1) DEFAULT '0' COMMENT '允许反馈',
  `status` INT(1) DEFAULT NULL COMMENT '状态',
  `author` VARCHAR(100) DEFAULT NULL COMMENT '作者',
  `gtm_create` DATETIME DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cid`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='文章内容';


/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) DEFAULT NULL COMMENT '用户名',
  `name` VARCHAR(100) DEFAULT NULL,
  `password` VARCHAR(50) DEFAULT NULL COMMENT '密码',
  `dept_id` BIGINT(20) DEFAULT NULL,
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT(255) DEFAULT NULL COMMENT '状态 0:禁用，1:正常',
  `user_id_create` BIGINT(255) DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` DATETIME DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME DEFAULT NULL COMMENT '修改时间',
  `sex` BIGINT(32) DEFAULT NULL COMMENT '性别',
  `birth` DATETIME DEFAULT NULL COMMENT '出身日期',
  `pic_id` BIGINT(32) DEFAULT NULL,
  `live_address` VARCHAR(500) DEFAULT NULL COMMENT '现居住地',
  `hobby` VARCHAR(255) DEFAULT NULL COMMENT '爱好',
  `province` VARCHAR(255) DEFAULT NULL COMMENT '省份',
  `city` VARCHAR(255) DEFAULT NULL COMMENT '所在城市',
  `district` VARCHAR(255) DEFAULT NULL COMMENT '所在地区',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;


INSERT  INTO `sys_user`(`user_id`,`username`,`name`,`password`,`dept_id`,`email`,`mobile`,`status`,`user_id_create`,`gmt_create`,`gmt_modified`,`sex`,`birth`,`pic_id`,`live_address`,`hobby`,`province`,`city`,`district`) VALUES (1,'admin','超级管理员','d633268afedf209e1e4ea0f5f43228a8',6,'admin@example.com','17699999999',1,1,'2017-08-15 21:40:39','2017-08-15 21:41:00',96,'2017-12-14 00:00:00',138,'ccc','121;','北京市','北京市市辖区','东城区');

-- 密码是 admin admin

