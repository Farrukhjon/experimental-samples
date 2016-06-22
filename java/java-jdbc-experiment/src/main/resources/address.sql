drop table if exists address;
create table if not exists address(
	id int unsigned not null auto_increment primary key,
	email varchar(100),
	phone varchar(100)
) engine = innodb auto_increment = 1 charset = utf8;
