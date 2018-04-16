CREATE DATABASE myschool;
SHOW DATABASES;
USE myschool;
#创建用户表格
/*
comment '字段注释'
comment='表注释'
charset=utf8 字符编码
engine=InnoDB/MyISAM 存储引擎
避免DOS窗口乱码，先执行 set names gbk;
*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
	`id` INT(8) PRIMARY KEY AUTO_INCREMENT ,
	`userName` VARCHAR(20) NOT NULL UNIQUE KEY,
	`password` VARCHAR(100) NOT NULL,
	`gender` CHAR(2) COMMENT '性别',
	`phone` VARCHAR(13)
)COMMENT='用户表';
SHOW TABLES;
#查看表结构
DESCRIBE `user`;
#修改表
#alter table rename/add/change/drop
#查看默认存储引擎
SHOW VARIABLES LIKE 'storage_engine';
SHOW ENGINES;
SELECT * FROM `user` ORDER BY `username`;
INSERT INTO `user` (`userName`,`password`,`gender`) VALUES ('boy','123456','女');













