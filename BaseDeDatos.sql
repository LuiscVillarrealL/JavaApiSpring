create database PruebaTecnica;


USE PruebaTecnica;


CREATE TABLE Permisos(
id INT PRIMARY KEY  NOT NULL,
nombre_permiso VARCHAR(10) NOT NULL 
);



CREATE TABLE Usuarios(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
usuario VARCHAR(50) NOT NULL,
pass VARCHAR(100) NOT NULL,
fecha_creacion DATE ,
ult_ingreso DATE,
estado VARCHAR(10) NOT NULL

);




CREATE TABLE Categorias(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
fecha_creacion DATE ,
ult_actualizacion DATE,
estado VARCHAR(10) NOT NULL
);

CREATE TABLE Productos(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
cat_id INT FOREIGN KEY REFERENCES Categorias(id),
costo float,
precio float,
tags text,
estado VARCHAR(10) NOT NULL,
fecha_creacion DATE ,
ult_actualizacion DATE

);


CREATE TABLE Permisos_Usuario(
id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
usuario_id INT  FOREIGN KEY REFERENCES Usuarios(id),
permisos_id INT  FOREIGN KEY REFERENCES Permisos(id),

);
