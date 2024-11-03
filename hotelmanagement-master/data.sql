create database hotelmanagementsystem;

show databases;

use hotelmanagementsystem;

insert into login values ('admin','12345');
create table login(username varchar(25),password varchar(25));
create table room(numerohab varchar(10), dispo varchar(20),estado varchar (20), precio varchar(20),tipo varchar (20));
create table customer(id varchar (20), numero varchar(30), nombre varchar(30), genero varchar(15),pais varchar(20),hab varchar (10),time varchar(80),deposito varchar(20));
ALTER TABLE customer MODIFY id VARCHAR(50);

