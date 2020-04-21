create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.inventory(inventoryid int primary key auto_increment, inventory_name varchar(40), inventorycost int, inventorytot int);
create table if not exists ims.orders(orderid int primary key auto_increment, customerid int, orderamount int, ordercost int, FOREIGN KEY(customerid) REFERENCES customers(id));
