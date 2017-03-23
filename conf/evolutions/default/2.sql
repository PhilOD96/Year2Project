# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups



insert into category (id,name) values ( 1,'Electronics' );
insert into category (id,name) values ( 2,'Books' ) ;
insert into category (id,name) values ( 3,'Games' ) ;
insert into category (id,name) values ( 4,'instruments' ) ;
insert into category (id,name) values ( 5,'mobiles' ) ;






insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 1,'THinkPad X260','Electronics',20000.00,'Lenovo',10);
insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 2,'MacBook','Electronics',20000.00,'Lenovo',10);
insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 3,'THinkPad X260','Electronics',20000.00,'Lenovo',10);

insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 4,'100 years of solitude','Books',9.99,'Penguin',10);
insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 5,'100 years of solitude','Books',9.99,'Lenovo',10);
insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 6,'100 years of solitude','Books',9.99,'Lenovo',10);


insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 7,'Resident Evil 7 Bio Hazard','Games',69.99,'Ps4',25);
insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 8,'Final Fantasy VII','Games',79.99,'Ps4',10);
insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 9,'Metal Gear Solis','Games',59.99,'Ps4',10);

insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 10,'Martin D 17','Instruments',1069.99,'Martin',10);
insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 11,'Gibson F-5','Instruments',1069.99,'Gibson',10);
insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 12,'Ritter Royal Flora Aurum','Instruments',1009.99,'Ritter Royal',10);


insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 13,'IPhone','mobiles',9.99,'Lenovo',10);

insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 14,'IPhone','mobiles',9.99,'Lenovo',10);

insert into product (product_id, product_Name,category,product_price, manufacturer, quantity) 
values ( 15,'IPhone','mobiles',9.99,'Lenovo',10);



insert into user (email,name,password,role) values ('admin@products.com', 'Alice Admin', 'password', 'admin');
insert into user (email,name,password,role) values ('manager@products.com', 'Matthew Manager', 'password', 'manager');
insert into user (email,name,password,role) values ('customer@products.com', 'Cian Customer', 'password', 'customer');



insert into category_product (category_id,product_product_id) values (1,1);
insert into category_product (category_id,product_product_id) values (1,2);
insert into category_product (category_id,product_product_id) values (1,3);

insert into category_product (category_id,product_product_id) values (2,4);
insert into category_product (category_id,product_product_id) values (2,5);
insert into category_product (category_id,product_product_id) values (2,6);

insert into category_product (category_id,product_product_id) values (3,7);
insert into category_product (category_id,product_product_id) values (3,8);
insert into category_product (category_id,product_product_id) values (3,9);

insert into category_product (category_id,product_product_id) values (4,10);
insert into category_product (category_id,product_product_id) values (4,11);
insert into category_product (category_id,product_product_id) values (4,12);

insert into category_product (category_id,product_product_id) values (5,13);
insert into category_product (category_id,product_product_id) values (5,14);
insert into category_product (category_id,product_product_id) values (5,15);
 
