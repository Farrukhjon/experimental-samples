DROP DATABASE IF EXISTS eshopdb;
CREATE DATABASE eshopdb CHAR SET = UTF8;

use eshopdb;

drop table if exists customer;
create table if not exists customer (
id int unsigned primary key auto_increment,
first_name varchar(20),
middle_name varchar(20),
last_name varchar(20),
order_id int unsigned,
constraint foreign key (order_id) references orders(id) on delete no action
) engine=innodb auto_increment=1 char set = utf8;

drop table if exists orders;
create table if not exists orders(
id int unsigned primary key auto_increment,
number int not null
) engine=innodb auto_increment=1 char set = utf8;



