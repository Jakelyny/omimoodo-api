CREATE TABLE usuario(
    id serial primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(255) not null,
    cpf varchar(14) not null unique,
    telefone varchar(20) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    ativo boolean,
    adm boolean
);

CREATE TABLE conteudo (
    id serial PRIMARY KEY,
    titulo varchar(200) NOT NULL,
    texto text NOT NULL,
    autor varchar(200) NOT NULL,
    imagem text,
    ativo boolean,
    data_criacao date
);

