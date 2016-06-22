drop table if exists user;
create table if not exists user(
	id int unsigned not null auto_increment primary key,
	id_employee int unsigned not null,
	username varchar(100),
	password varchar(100),
	key key_employee(id_employee),
	constraint fk_employee foreign key key_employee(id_employee) references employee(id)
) engine = innodb charset=utf8 auto_increment = 1;