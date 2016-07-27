SET FOREIGN_KEY_CHECKS=0;
drop table if exists employee;
create table if not exists employee (
    id int unsigned not null primary key auto_increment,
    firstName varchar(120),
    lastName varchar(120),
    birthDate date,
    salary double,
    depId int unsigned not null,
    roleId int unsigned not null,
    foreign key (depId) references departament(id),
    foreign key (roleId) references role(id)
)  engine=innodb default charset=utf8 auto_increment=1 collate = utf8_general_ci;


drop table if exists departament;
create table if not exists departament (
    id int unsigned not null primary key auto_increment,
    name varchar(120),
    managerId int unsigned not null,
    foreign key(managerId) references manager(id)
)  engine=innodb default charset=utf8 auto_increment=1 collate = utf8_general_ci;


drop table if exists manager;
create table if not exists manager (
    id int unsigned not null primary key auto_increment,
    employeeId int unsigned not null,
    foreign key(employeeId) references employee(id)
)  engine=innodb default charset=utf8 auto_increment=1 collate = utf8_general_ci;



drop table if exists role;
create table if not exists role(
    id int unsigned not null primary key auto_increment,
    name varchar(120)
)  engine=innodb default charset=utf8 auto_increment=1 collate = utf8_general_ci;

SET FOREIGN_KEY_CHECKS=0;


insert into role(name) values
                    ('Project Manager'),
                    ('Team Lead'),
                    ('Sr. Developer'),
                    ('Middle Developer'),
                    ('Developer'),
                    ('QA');

insert into manager(employeeId) values
     (1);

insert into departament(name, managerId) values
           ('IT', 1),
           ('Accountant', 2),
           ('Finance', 3),
           ('Marketing', 4),
           ('Sale', 5);

insert into employee(firstName, lastName, birthDate, salary, roleId, depId) values
                                            ('Ali', 'Valizoda', '1972-07-10', 1000, 1, 1),
                                            ('Vali', 'Ganizoda', '1973-11-08', 450, 2, 1),
                                            ('Vali', 'Hasanzoda', '1963-10-09', 750, 2, 1),
                                            ('Jomi', 'Hasanzoda', '1993-01-01', 750, 2, 1),
                                            ('Gani', 'Komili', '1984-11-10', 820, 3, 1),
                                            ('Sami', 'Tursunzoda', '1985-11-10', 1000, 4, 1),
                                            ('Jomi', 'Rudaki', '1975-11-10', 560, 5, 1);
                                            
  
  
  
  