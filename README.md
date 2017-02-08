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
cn.itcast.jdbc.dao.refactor 通过反射简化代码
	MyDaoTemplate 将增删改查抽象为update和find
	RowMapper 将结果集交给子类处理

事务：
TxTest.java
SavePointTest

连接池：
自定义连接池
	MyConnectionHandler
	MyDataSource
	MyJdbcUtils
DBCP连接池：
	commons-collections-3.1.jar
	commons-pool.jar
	commons-dbcp-1.2.2.jar
	JdbcDbcpUtils
c3p0连接池：	
	c3p0-0.9.2-pre1.jar
	mchange-commons-0.2.jar
spring框架，使用别人提供的数据源：
	JdbcTemplate
	NamedJdbcTemplate NamedParameterJdbcTemplate在JdbcTemplate的基础上，sql语句中的?改为了命名参数
	SimpleJdbcTemplate在NamedParameterJdbcTemplate的基础上添加了泛型和可变长度参数支持
	UserDaoSpringImpl 使用spring框架实现增删改查例子


