drop table if exists chamados_tecnicos.users cascade;

create table chamados_tecnicos.users(
	id bigint auto_increment not null primary key,
	username varchar(25) not null,
	email varchar(250) not null,
	password varchar(100) not null,
	role varchar(35) not null
)  ENGINE=InnoDB charset=Utf8;

alter table chamados_tecnicos.users add CONSTRAINT uq_user_email UNIQUE (email);
alter table chamados_tecnicos.users add CONSTRAINT uq_user_name_password UNIQUE (username,password);