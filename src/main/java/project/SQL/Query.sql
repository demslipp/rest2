create database service;

create type grade as enum ('JUNIOR', 'MIDDLE', 'SENIOR');

create table Employee
(
    Id        serial primary key,
    Lastname  CHARACTER VARYING(30),
    Firstname character varying(30),
    Grade     public.grade
);

drop table Task;

create table Task(
    Id serial primary key,
    Task_name character varying(30),
    Difficult INTEGER,
    Time INTEGER,
    Cost INTEGER
);

create table assignment(
  id serial primary key,
  task_id INTEGER references Task(Id),
  employee_id INTEGER references Employee(Id)
);



