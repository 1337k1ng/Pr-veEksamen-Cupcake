-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

CREATE SCHEMA IF NOT EXISTS CupcakeDB;


USE CupcakeDB;


CREATE TABLE Bruger (
  id int AUTO_INCREMENT,
  navn varchar(255),
  email varchar(255),
  password varchar(255),
  saldo int,
  rolle varchar(255),
  PRIMARY KEY (id)

);


CREATE TABLE Ordre (
  ordreId int AUTO_INCREMENT,
  id int,
  PRIMARY KEY (ordreId),
    FOREIGN KEY (id) REFERENCES Bruger(id)
);


CREATE TABLE Indhold (
  ordreId int,
  cupcakeId int,
  antal int,
  PRIMARY KEY (ordreId, cupcakeId),
  FOREIGN KEY (ordreId) REFERENCES Ordre(ordreId)

);


CREATE TABLE Tidspunkt (
  ordreId int,
  Dato varchar(255),
  PRIMARY KEY (ordreId),
    FOREIGN KEY (ordreId) REFERENCES Ordre(ordreId)
);



CREATE TABLE Bund (
  bundId int auto_increment not null,
  navn varchar(255),
  pris int,
  PRIMARY KEY (bundId)
);


CREATE TABLE Top (
  topId int auto_increment not null,
  navn varchar(255),
  pris int,
  PRIMARY KEY (topId)
);


CREATE TABLE Cupcake (
  cupcakeId int auto_increment not null,
  bundId int,
  topId int,
  PRIMARY KEY (cupcakeId),
  FOREIGN KEY (bundId) REFERENCES Bund(bundId),
  FOREIGN KEY (topId) REFERENCES Top(topId)

);

ALTER TABLE Indhold
ADD FOREIGN KEY (cupcakeId) REFERENCES Cupcake(cupcakeId);