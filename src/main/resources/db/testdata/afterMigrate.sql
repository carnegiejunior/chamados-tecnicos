set foreign_key_checks = 0;

delete from users;

set foreign_key_checks = 1;

alter table users auto_increment = 1;

insert into users (username,email,password,role) values ('carnegie','carnegiejunior@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','ADMINISTRATOR');
