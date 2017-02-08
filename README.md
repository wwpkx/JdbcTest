jdbc test

主要以itcast 李勇jdbc为主

数据库结构：
使用Mysql Query Browser创建了数据库jdbc和table
CREATE TABLE `jdbc`.`user` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT '',
  `birthday` DATE NOT NULL DEFAULT 0,
  `money` FLOAT NOT NULL DEFAULT 0,
  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

文件说明：
jdbc操作模板：
JdbcUtils
JdbcUtilsSing
CRUD 增删改查操作
SQLInject 演示sql注入，查询时。PreparedStatement和Statement
DateTest 输入时间和返回时间处理
ClobTest 大文本处理
BlobTest 二进制文件操作
PsTest 存储过程，现在已经有业务逻辑层代替
BatchTest 批处理，可以大幅度提升大量增、删、改的速度
ScrollTest 可滚动的结果集
OtherApi 可更新的结果集
DBMD 数据库元信息
ParameterMetaTest 参数元信息
ResultSetMetaDataTest 利用结果集元数据将查询结果封装为map
ORMTest 利用Java反射技术将查询结果封装为对象

cn.itcast.jdbc.domain 实体，对应数据库的表
cn.itcast.jdbc.dao 数据访问层
cn.itcast.jdbc.dao.DaoFactory 使用配置文件配置数据库信息
cn.itcast.jdbc.service 业务层

事务：
TxTest.java
SavePointTest

连接池：


