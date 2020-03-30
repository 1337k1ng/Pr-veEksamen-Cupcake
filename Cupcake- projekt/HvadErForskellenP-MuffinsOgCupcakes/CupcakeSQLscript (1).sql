-- noinspection SqlDialectInspectionForFile
-- noinspection SqlNoDataSourceInspectionForFile
CREATE SCHEMA IF NOT EXISTS CupcakeDB;
USE CupcakeDB;

DROP SCHEMA IF exists CupcakeDB;
Create schema CupcakeDB;
Use CupcakeDB;


Drop table if exists Bruger;
CREATE TABLE Bruger (
  brugerId int AUTO_INCREMENT not null,
  navn varchar(255),
  email varchar(255),
  password varchar(255),
  saldo double, 
  rolle varchar(255),
  PRIMARY KEY (brugerId)
);

Drop table if exists Cupcake;
CREATE TABLE Cupcake (
  cupcakeId int AUTO_INCREMENT not null,
  bund varchar(255),
  top varchar(255),
  pris double,
  PRIMARY KEY (cupcakeId)
);



Drop table if exists Ordre;
CREATE TABLE Ordre (
  ordreId int AUTO_INCREMENT,
  brugerId int,
  PRIMARY KEY (ordreId),
  FOREIGN KEY (brugerId) REFERENCES Bruger(brugerId)
);

Drop table if exists Indhold;
CREATE TABLE Indhold (
  ordreId int,
  cupcakeId int,
  FOREIGN KEY (ordreId) REFERENCES Ordre(ordreId),
  FOREIGN KEY (cupcakeId) REFERENCES Cupcake(CupcakeId)
);

Drop table if exists Tidspunkt;
CREATE TABLE Tidspunkt (
  ordreId int,
  dato varchar(255),
  PRIMARY KEY (ordreId),
  FOREIGN KEY (ordreId) REFERENCES Ordre(ordreId)
);


insert into Bruger(navn, email) values ("joe", "hehe@gmail.dk");
insert into Cupcake(top, bund) values("kiks", "choko"); 
insert into Ordre(brugerId) values (1); /* En ordre skal bruge et brugerId, som er under user. */
insert into Indhold(ordreId, cupcakeId) values (1,1); /* Indhold skal bruge ordre og cupcake ids */
insert into Tidspunkt(ordreId, dato) values (1, "09-01-2017");

select * from Bruger, Cupcake, Ordre, Indhold, Tidspunkt;

