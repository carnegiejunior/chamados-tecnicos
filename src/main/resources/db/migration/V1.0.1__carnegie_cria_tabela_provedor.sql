drop table if exists chamados_tecnicos.provedores cascade;


create table chamados_tecnicos.provedores(
	id bigint auto_increment not null primary key,
	nome varchar(50 ) not null,
	cnpj varchar( 20) not null
)  ENGINE=InnoDB charset=Utf8;



alter table chamados_tecnicos.provedores add CONSTRAINT uq_provedores_name_cnpj UNIQUE (nome,cnpj);
