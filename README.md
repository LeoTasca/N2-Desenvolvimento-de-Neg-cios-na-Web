# N2-Desenvolvimento-de-Negócios-na-Web

Para compilar e executar essa aplicação você precisa:
- instalar uma IDE, ex. Spring Tool Suite;
- instalar o java, wildfly na máquina;
- clonar esse projeto para uma pasta na sua máquina;
- abrir o projeto dentro da IDE;
- alterar username e password do banco de dados no arquivo ClienteDAO.java;
- configurar o wildfly na IDE;
- iniciar o servidor do wildfly;
- iniciar o projeto dentro desse servidor;

Para utilizar essa aplicação você precisa:
- ter o MySQL instalado na máquina;
- ter o MySQL Workbench instalado;
- configurar o MySQL;
- criar um banco de dados no Workbench;
- rodar essa query no Workbench:

CREATE DATABASE `academia`;

USE `academia`;
create table `clientes`(
 id INT NOT NULL AUTO_INCREMENT,
 matricula INT NOT NULL,
 nome VARCHAR(120) NOT NULL,
 bairro VARCHAR(120), 
 cidade VARCHAR(120),
 cep VARCHAR(120),
 estado VARCHAR(120),
 logradouro VARCHAR(120),
 numero VARCHAR(20) NOT NULL,
 modalidade VARCHAR(120) NOT NULL,
 descricao VARCHAR(120) NOT NULL,
 PRIMARY KEY (id)
)
