set foreign_key_checks = 0;

delete from users;
delete from provedores;

set foreign_key_checks = 1;

alter table users auto_increment = 1;
alter table provedores auto_increment = 1;

insert into users (username,email,password,role) values ('admin','admin@admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','ADMIN');

insert into provedores(nome,cnpj) values ('Geek Telecom','35431676000114');



