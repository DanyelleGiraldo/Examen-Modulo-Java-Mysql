create database sgpzf;
use sgpzf;

create table stack(
    id int primary key,
    name varchar(50)
);

create table skill(
    id int primary key,
    name VARCHAR(50) not null
);

create table stack_skill(
    idskill int,
    idstack int,
    idstatus int,
    Foreign Key (idskill) REFERENCES skill(id),
    Foreign Key (idstack) REFERENCES stack(id),
    primary key(idskill, idstack)
);

create table country(
    id int PRIMARY KEY,
    name VARCHAR(50)
);

create table region(
    id int PRIMARY KEY,
    name VARCHAR(50),
    idcountry int,
    Foreign Key (idcountry) REFERENCES country(id)
);

create table city(
    id int PRIMARY KEY,
    name varchar(50) not null,
    idregion int not null,
    Foreign Key (idregion) REFERENCES region(id)
);

create table gender(
    id int primary key,
    name varchar(50)
);
create table persons(
    id int PRIMARY KEY,
    name varchar(50),
    lastname varchar(50),
    idcity int,
    Foreign Key (idcity) REFERENCES city(id),
    address varchar(50),
    age int,
    email varchar(100),
    idgender int,
    Foreign Key (idgender) REFERENCES gender(id)
);

create table persons_skill(
    id int PRIMARY KEY,
    registration_date DATE,
    iperson int,
    Foreign Key (iperson) REFERENCES persons(id),
    idskill int,
    Foreign Key (idskill) REFERENCES skill(id)
);
