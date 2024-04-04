create database hotel;

use hotel;

show databases;
-- -----------------------------------------------------------------------------------------------

create table login(username varchar(25) unique,password varchar(25));

insert into login values('buddewar','865790');

select * from login;
-- ----------------------------------------------------------------------------------------------

create table room(roomno varchar(20),avilability varchar(20),cleaning_status varchar(20),price varchar(20),bed_type varchar(20));

select * from hotel.room;
-- select * from room;

ALTER TABLE hotel.room ADD type_of_room varchar(20);
-- ---exercise--
-- delete from hotel.room;
-- ------------------------------------------------------------------------------------------

create table employee(emp_ID varchar(20) unique,name varchar(20),age varchar(10),gender varchar(20),job varchar(20),salary varchar(20),phone varchar(20) unique,aadhar varchar(15),email varchar(30));

drop table employee;

select * from hotel.employee;
-- select * from employee;

create table driver(driver_ID varchar(20) unique,name varchar(20),age varchar(10),gender varchar(20),car_Model varchar(20),salary varchar(20),availability varchar(20),location varchar(20),phone varchar(20) unique);

select * from hotel.driver;
-- -------------------------------------------------------------------------

create table adminLogin(username varchar(20),password varchar(20));

select * from hotel.adminLogin;

insert into adminLogin values('admin','86579');


-- ------------------------------------------------------------------------ 
create table department(department varchar(100),budget varchar(15));

insert into department values('Accountant','100000');
insert into department values('House Keeping','100000');
insert into department values('Food Service','150000');
insert into department values('Kitchen','15000');
insert into department values('Security','50000');
insert into department values('Office','70000');
insert into department values('Travels','20000');
insert into department values('Electricity','30000');
insert into department values('Maintenance','10000');


select * from department;
-- ------------------------------------------------------------------------------------------

create table customer(name varchar(30),documentID varchar(30),Phone_Number varchar(15),Gender varchar(12),Address varchar(40),Alloccated_ROOM_NO varchar(5),Check_IN_TIME varchar(80),Advance varchar(10),NumberOfStay varchar(5));

alter table customer rename column Phone_Number to ID_NUMBER;
select * from customer;






-- -------------------------------------------------------------------------------


