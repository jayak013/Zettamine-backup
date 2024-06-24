create table sales_order(
	order_id int,
	item_num int not null,
	material_num varchar(5) not null,
	item_val numeric(7,2) not null,
	order_dt date not null,
	constraint pk_id primary key(order_id,item_num));
	
select * from sales_order;
	
insert into sales_order values(201,1,'M-01',4000,'2019-02-23');
insert into sales_order values(203,1,'M-02',4300,'2019-03-23');
insert into sales_order values(221,3,'M-05',5400,'2019-03-23');
insert into sales_order values(209,1,'M-06',3200,'2019-02-23');
insert into sales_order values(215,2,'M-01',6500,'2018-02-23');
insert into sales_order values(209,4,'M-02',8500,'2018-03-23');
insert into sales_order values(201,3,'M-03',7700,'2019-02-23');
insert into sales_order values(207,3,'M-05',9700,'2018-02-23');
insert into sales_order values(221,2,'M-10',1200,'2019-02-23');
insert into sales_order values(245,1,'M-10',8600,'2018-02-23');
insert into sales_order values(218,1,'M-05',7400,'2019-03-23');
insert into sales_order values(216,1,'M-03',8600,'2018-02-23');
insert into sales_order values(261,3,'M-01',3300,'2019-02-23');
insert into sales_order values(241,4,'M-04',7500,'2019-02-23');
insert into sales_order values(261,2,'M-04',8700,'2019-02-23');
insert into sales_order values(241,1,'M-01',3400,'2019-02-23');

