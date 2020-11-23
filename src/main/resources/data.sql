insert into product(id,name,description,price,size) values(1,'Phone','communication',5,'M');
insert into product(id,name,description,price,size) values(2,'bluetooth','audio',6,'S');
insert into product(id,name,description,price,size) values(3,'earphone','media',7,'L');
insert into user(id,first_name,last_name,email) values(1,'Ram','Verma','rv@gmail.com');
insert into user(id,first_name,last_name,email) values(2,'Raghav','Sharma','rs@gmail.com');
insert into user(id,first_name,last_name,email) values(3,'Rohan','Singh','rs123@gmail.com');
insert into orders(id,product_id,user_id,quantity,lst_upd_ts) values(1,1,1,50,current_timestamp);
insert into orders(id,product_id,user_id,quantity,lst_upd_ts) values(2,2,2,500,current_timestamp);
