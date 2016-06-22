drop table if exists employee;
create table if not exists employee (
    id int unsigned not null auto_increment primary key,
    id_person int unsigned not null,
    experiance int,
    salary double,
    key key_person (id_person),
    constraint fk_person foreign key (id_person) references person (id)
)  engine=innodb charset=utf8 auto_increment=1;