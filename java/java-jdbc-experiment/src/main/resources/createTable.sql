create database marking;
use marking;

set foreign_key_checks = 0;

drop table if exists pursishnoma;
create table if not exists pursishnoma(
	id_pursishnoma int unsigned not null auto_increment primary key,
	id_muallim int unsigned,
	id_savol int unsigned,
	baho int unsigned,
	key key_muallim(id_muallim),
	key key_savol(id_savol),
	constraint fk_muallim foreign key key_muallim(id_muallim) references muallim(id_muallim), 
	constraint fk_savol foreign key key_savol(id_savol) references savol(id_savol)
) engine = innodb charset = utf8 auto_increment = 1;

create table if not exists muallim (
    id_muallim int unsigned not null auto_increment primary key,
    surname varchar(100),
    name varchar(100),
    patronymic varchar(100)
)  engine=innodb charset=utf8 auto_increment=1;


drop table if exists savol;
create table if not exists savol (
    id_savol int unsigned not null auto_increment primary key,
    name varchar(200)
)  engine=innodb charset=utf8 auto_increment=1;

set foreign_key_checks = 1;