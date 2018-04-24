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
/*
CREATE TABLE [IF NOT EXISTS] `表名` (
	`字段1` 数据类型 [字段属性|约束] [索引] [注释],#
	`字段2` 数据类型 [字段属性|约束] [索引] [注释],
	...
	`字段n` 数据类型 [字段属性|约束] [索引] [注释]
)[表类型] [CHARSET='字符集名'] [COMMENT='注释'];
*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
	`id` INT(4) UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '编号',	#主键约束+自动增长+无符号数，不设负值(Int数据类型特有，zerofill 宽度不足以零填充)
	`userName` VARCHAR(20) NOT NULL UNIQUE KEY COMMENT '用户名',	#非空+唯一约束
	`password` VARCHAR(200) NOT NULL COMMENT '密码',
	`gender` CHAR(4) DEFAULT '保密' COMMENT '性别',					#默认约束(默认值：保密)
	`phone` VARCHAR(13) COMMENT '联系电话'
)CHARSET='UTF-8' COMMENT='用户表';
SHOW TABLES;
#查看表结构
DESCRIBE `user`;
/*
#修改表
#alter table `旧表名` rename [TO] `新表名`;
#alter table `表名` add `字段名` 数据类型 [属性];
#alter table `表名` change `原字段名` `新字段名` 数据类型 [属性];
#alter table `表名` drop `字段名`;
*/
#查看默认存储引擎
SHOW VARIABLES LIKE 'storage_engine';
SHOW ENGINES;
/*
#添加主键约束
ALTER TABLE `表名` ADD CONSTRAINT `自定义的主键名` PRIMARY KEY `表名`(`主键字段`);
#添加外键约束
ALTER TABLE `表名` ADD CONSTRAINT `自定义的外键名` FOREIGN KEY (`外键字段`) REFERENCES `关联表名`(`关联字段，一般为从表主键字段`);
*/
SELECT * FROM `user` ORDER BY `username`;
#增加数据
INSERT INTO `user` (`userName`,`password`,`gender`) VALUES ('admin','123456','女');
