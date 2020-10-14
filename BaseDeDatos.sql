create database PruebaTecnica;


USE PruebaTecnica;


CREATE TABLE Usuarios(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
usuario VARCHAR(50) NOT NULL,
pass VARCHAR(20) NOT NULL,
fecha_creacion DATE ,
ult_ingreso DATE,
nivel VARCHAR(10),
estado VARCHAR(10)

);


CREATE TABLE Productos(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
cat_id INT FOREIGN KEY REFERENCES Usuarios(id),
costo float,
precio float,
tags text,
estado VARCHAR(10),
fecha_creacion DATE ,
ult_actualizacion DATE

);


CREATE TABLE Categorias(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
fecha_creacion DATE ,
ult_actualizacion DATE,
estado VARCHAR(10)
);




