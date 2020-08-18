drop table if exists chamados_tecnicos.chamados cascade;

create table chamados_tecnicos.chamados(
	id bigint auto_increment not null primary key,
	provedor_id bigint not null
)  ENGINE=InnoDB charset=Utf8;

alter table chamados_tecnicos.chamados add CONSTRAINT fk_provedor_id foreign key (provedor_id) references chamados_tecnicos.provedores (id);
