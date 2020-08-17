drop table if exists users cascade;

create table users(
	id bigint auto_increment not null primary key,
	name varchar(25) not null,
	email varchar(250) not null,
	password varchar(100) not null,
	role varchar(35) not null
)  ENGINE=InnoDB charset=Utf8;

alter table user add CONSTRAINT uq_user_email UNIQUE (email);
alter table user add CONSTRAINT uq_user_email_password UNIQUE (email,password);
alter table users MODIFY COLUMN password varchar(100) NOT NULL;