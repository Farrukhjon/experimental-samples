drop table if exists person;
create table if not exists person(
	id int unsigned not null auto_increment primary key,
	surname varchar(100),
	name varchar(100),
	patronymic varchar(100),
	id_address int unsigned default null,
	key key_address(id_address),
	constraint fk_address foreign key key_address(id_address) references address(id)
) engine = innodb auto_increment = 1 charset = utf8;
