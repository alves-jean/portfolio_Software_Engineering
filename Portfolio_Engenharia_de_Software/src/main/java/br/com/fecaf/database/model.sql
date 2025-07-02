create database db_mural;
use db_mural;

create table tbl_login(
	id int primary key not null auto_increment,
    nome varchar(255) not null,
    usuario varchar(255) not null,
    senha varchar(255) not null,
    tipo_permissao varchar(100) not null,
    unique index (id)
);

create table tbl_mural(
	id int primary key not null auto_increment,
    nome_projeto varchar(255) not null,
    data_inicio date not null,
    data_final date not null,
    id_login int not null,
    unique index (id),

    constraint FK_login_mural
    foreign key (id_login)
    references tbl_login (id)
);

create table tbl_cartao(
	id int primary key not null auto_increment,
    titulo_cartao varchar(255) not null,
    descricao varchar(255) not null,
    prioridade varchar(20) not null,
    situacao varchar(20) not null,
    data_inicio date not null,
    data_final date not null,
    id_mural int not null,
    unique index(id),

    constraint FK_mural_cartao
    foreign key (id_mural)
    references tbl_mural(id)
);

create table tbl_equipe(
	id int primary key not null auto_increment,
    id_login int not null,
    id_mural int not null,
    unique index(id),

    constraint FK_login_equipe
    foreign key (id_login)
    references tbl_login(id),

    constraint FK_mural_equipe
    foreign key (id_mural)
    references tbl_mural(id)
);

create table tbl_financas(
	id int primary key not null auto_increment,
	valor_servico decimal(10,2) not null,
    id_equipe int not null,
    unique index(id),

    constraint FK_equipe_financas
    foreign key (id_equipe)
    references tbl_equipe(id)
);
