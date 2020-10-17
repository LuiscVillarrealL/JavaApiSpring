create database PruebaTecnica;


USE PruebaTecnica;


CREATE TABLE permisos(
id INT PRIMARY KEY  NOT NULL,
nombre_permiso VARCHAR(10) NOT NULL 
);



CREATE TABLE usuarios(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
usuario VARCHAR(50) NOT NULL,
pass VARCHAR(100) NOT NULL,
fecha_creacion DATE ,
ult_ingreso DATE,
estado VARCHAR(10) NOT NULL

);

CREATE TABLE permisos_usuario(
id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
usuario_id INT  FOREIGN KEY REFERENCES usuarios(id),
permisos_id INT  FOREIGN KEY REFERENCES permisos(id),

);



CREATE TABLE categorias(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
fecha_creacion DATE ,
ult_actualizacion DATE,
estado VARCHAR(10) NOT NULL
);


CREATE TABLE productos(

id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
nombre VARCHAR(50) NOT NULL,
costo float,
precio float,
tags text,
estado VARCHAR(10) NOT NULL,
fecha_creacion DATE ,
ult_actualizacion DATE

);

CREATE TABLE categorias_productos(
id INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
categoria_id INT  FOREIGN KEY REFERENCES categorias(id),
productos_id INT  FOREIGN KEY REFERENCES productos(id)
)



