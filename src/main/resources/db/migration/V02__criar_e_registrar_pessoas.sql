-- algamoneyapi.Pessoa definition

CREATE TABLE Pessoa (
  codigo bigint NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  email varchar(50) ,
  telefone varchar(50) ,
  cpf varchar(50) ,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO Pessoa (nome,email) VALUES ('Lucas','lucas@gmail.com');
INSERT INTO Pessoa (nome,email) VALUES ('Matheus','matheus@gmail.com');
INSERT INTO Pessoa (nome,email) VALUES ('Ana','ana@gmail.com');
INSERT INTO Pessoa (nome,email) VALUES ('Leticia','leticia@gmail.com');


