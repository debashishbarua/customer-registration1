drop database if exists test_db_spring;

create database test_db_spring;

use test_db_spring;

drop table if exists tbl_customer ;
create table tbl_customer(
   cust_id int not null,
   cust_name varchar(200) not null,
   cust_email varchar(50) not null,
   cust_phone_no varchar(10) not null,
   primary key(cust_id)
);