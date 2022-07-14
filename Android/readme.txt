Android端代码 负责收集用户健康信息并将其存储到MySQL数据库。
数据库创建代码如下：
建立数据库：CREATE DATEBASE signin_db
建立数据表：USE signin_db（使用signin_db数据库）
	CREATE TABLE signin_table(date_time date_time,name text,temp text,temp1 text,temp2 text,temp3 text,temp4 text,temp8 text,temp5 text,location text,temp6 text,temp9 text,temp7 text)default charset=utf8;
