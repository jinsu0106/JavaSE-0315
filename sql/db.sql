drop database if exists db_test;

create database db_test;

drop table if exists db_test.user;
create table db_test.user
(
  id       int auto_increment primary key comment 'id PK',
  username varchar(255) not null comment 'username NN',
  password varchar(255) not null comment 'password NN'
) comment 'user table';

select *
from db_test.user;


drop database db_cmd;

create database db_cmd;

