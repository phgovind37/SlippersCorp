insert into functionality(id,functionality_name)
values(1,'employees'),(2,'vendors'),(3,'product categories'),(4,'mensproducts'),(5,'womensproducts'),(6,'kidsproducts'),(7,'orders'),
(8,'reports');
-- ('mens produts'),('womens products'),('kids products')

INSERT INTO authority (id,functionality_id,authority_name,authority_display_text)
	VALUES  
		-- (1,1,'ROLE_ACADEMICYEAR_ALL','ROLE_ACADEMICYEAR_ALL'),
		(1,1,'ROLE_EMPLOYEES_MANAGE','ROLE_EMPLOYEES_MANAGE'),
		(2,1,'ROLE_EMPLOYEES_LIST','ROLE_EMPLOYEES_LIST'),
		(3,1,'ROLE_EMPLOYEES_NEW','ROLE_EMPLOYEES_NEW'),
		(4,1,'ROLE_EMPLOYEES_EDIT','ROLE_EMPLOYEES_EDIT'),
		(5,1,'ROLE_EMPLOYEES_DELETE','ROLE_EMPLOYEES_DELETE'),
		(6,1,'ROLE_EMPLOYEES_VIEW','ROLE_EMPLOYEES_VIEW'),
		
		(7,2,'ROLE_VENDORS_MANAGE','ROLE_VENDORS_MANAGE'),
	    (8,2,'ROLE_VENDORS_LIST','ROLE_VENDORS_LIST'),
	    (9,2,'ROLE_VENDORS_NEW','ROLE_VENDORS_NEW'), 
	    (10,2,'ROLE_VENDORS_EDIT','ROLE_VENDORS_EDIT'),
	    (11,2,'ROLE_VENDORS_DELETE','ROLE_VENDORS_DELETE'),
	    (12,2,'ROLE_VENDORS_VIEW','ROLE_VENDORS_VIEW'),
		
		(13,3,'ROLE_PRODUCTCATEGORY_MANAGE','ROLE_PRODUCTCATEGORY_MANAGE'),
	    (14,3,'ROLE_PRODUCTCATEGORY_LIST','ROLE_PRODUCTCATEGORY_LIST'),
	    (15,3,'ROLE_PRODUCTCATEGORY_NEW','ROLE_PRODUCTCATEGORY_NEW'),
	    (16,3,'ROLE_PRODUCTCATEGORY_EDIT','ROLE_PRODUCTCATEGORY_EDIT'),
	    (17,3,'ROLE_PRODUCTCATEGORY_DELETE','ROLE_PRODUCTCATEGORY_DELETE'),
	    (18,3,'ROLE_PRODUCTCATEGORY_VIEW','ROLE_PRODUCTCATEGORY_VIEW'),
	    
	    (19,4,'ROLE_MENSPRODUCTS_MANAGE','ROLE_MENSPRODUCTS_MANAGE'),	 
	    (20,4,'ROLE_MENSPRODUCTS_LIST','ROLE_MENSPRODUCTS_LIST'),
	    (21,4,'ROLE_MENSPRODUCTS_NEW','ROLE_MENSPRODUCTS_NEW'),
	    (22,4,'ROLE_MENSPRODUCTS_EDIT','ROLE_MENSPRODUCTS_EDIT'),
	    (23,4,'ROLE_MENSPRODUCTS_DELETE','ROLE_MENSPRODUCTS_DELETE'),
	    (24,4,'ROLE_MENSPRODUCTS_VIEW','ROLE_MENSPRODUCTS_VIEW'),
	    
	    (25,5,'ROLE_WOMENSPRODUCTS_MANAGE','ROLE_WOMENSPRODUCTS_MANAGE'),	 
	    (26,5,'ROLE_WOMENSPRODUCTS_LIST','ROLE_WOMENSPRODUCTS_LIST'),
	    (27,5,'ROLE_WOMENSPRODUCTS_NEW','ROLE_WOMENSPRODUCTS_NEW'),
	    (28,5,'ROLE_WOMENSPRODUCTS_EDIT','ROLE_WOMENSPRODUCTS_EDIT'),
	    (29,5,'ROLE_WOMENSPRODUCTS_DELETE','ROLE_WOMENSPRODUCTS_DELETE'),
	    (30,5,'ROLE_WOMENSPRODUCTS_VIEW','ROLE_WOMENSPRODUCTS_VIEW'),
	    
	    (31,6,'ROLE_KIDSPRODUCTS_MANAGE','ROLE_KIDSPRODUCTS_MANAGE'),	 
	    (32,6,'ROLE_KIDSPRODUCTS_LIST','ROLE_KIDSPRODUCTS_LIST'),
	    (33,6,'ROLE_KIDSPRODUCTS_NEW','ROLE_KIDSPRODUCTS_NEW'),
	    (34,6,'ROLE_KIDSPRODUCTS_EDIT','ROLE_KIDSPRODUCTS_EDIT'),
	    (35,6,'ROLE_KIDSPRODUCTS_DELETE','ROLE_KIDSPRODUCTS_DELETE'),
	    (36,6,'ROLE_KIDSPRODUCTS_VIEW','ROLE_KIDSPRODUCTS_VIEW'),
	    
	    (37,7,'ROLE_ORDERS_MANAGE','ROLE_ORDERS_MANAGE'),	 
	    (38,7,'ROLE_ORDERS_LIST','ROLE_ORDERS_LIST'),
	    (39,7,'ROLE_ORDERS_NEW','ROLE_ORDERS_NEW'),
	    (40,7,'ROLE_ORDERS_EDIT','ROLE_ORDERS_EDIT'),
	    (41,7,'ROLE_ORDERS_DELETE','ROLE_ORDERS_DELETE'),
	    (42,7,'ROLE_ORDERS_VIEW','ROLE_ORDERS_VIEW'),
	    
	    (43,8,'ROLE_PRODUCTREPORTS_MANAGE','ROLE_PRODUCTREPORTS_MANAGE'),
	    (44,8,'ROLE_ORDERREPORTS_MANAGE','ROLE_ORDERREPORTS_MANAGE'); 
	    
insert into role(id,tenant_id,role_name) values
(1,1,'SUPER_ADMIN'),(2,2,'ADMIN'),(3,3,'USER');

insert into user(id,tenant_id,user_name,password,role_id) values
 (1,1,'jesus','jesus',2),
 (1,1,'govind','govind',3);

insert into roleauthoritymapping(id,tenant_id,role_id,authority_id)
values (1,1,2,1),(2,1,2,2),(3,1,2,3),(4,1,2,4),(5,1,2,5),
		(6,1,2,7),(7,1,2,8),(8,1,2,9),(9,1,2,10),(10,1,2,11),
		(11,1,2,13),(12,1,2,14),(13,1,2,15),(14,1,2,16),(15,1,2,17),
		(16,1,2,19),(17,1,2,20),(18,1,2,21),(19,1,2,22),(20,1,2,23),
		(21,1,2,25),(22,1,2,26),(23,1,2,27),(24,1,2,28),(25,1,2,29),
		(26,1,2,31),(27,1,2,32),(28,1,2,33),(29,1,2,34),(30,1,2,35),
		(31,1,3,13),(32,1,3,14),(33,1,3,15),(34,1,3,16),(35,1,3,17),
		(36,1,3,19),(37,1,3,20),(38,1,3,21),(39,1,3,22),(40,1,3,23),
		(41,1,3,25),(42,1,3,26),(43,1,3,27),(44,1,3,28),(45,1,3,29),
		(46,1,3,31),(47,1,3,32),(48,1,3,33),(49,1,3,34),(50,1,3,35),
		(51,1,2,37),(52,1,2,38),(53,1,2,39),(54,1,2,40),(55,1,2,41),
		(56,1,3,37),(57,1,3,38),(58,1,3,39),(59,1,3,40),(60,1,3,41),
		(61,1,2,43),(62,1,3,43),(63,1,3,6),(64,1,3,12),(65,1,2,44),(66,1,3,44);
		

insert into country(name)
	values 
		("Australia"),("Bangladesh"), ("Bermuda"),
		("Canada"), ("India"), ("New Zealand"),
		("Pakistan"), ("South Africa"), ("Sri Lanka"),
		("United Kingdom"), ("West Indies");

insert into state(name, country_id) 
	  values 
	  ("Tasmania",1),("Victoria", 1),("Chittagong Div.", 2),("Dhaka Div.", 2),("Andhra Pradesh", 5),
	  ("Andaman and Nicobar",5),("Arunachal Pradesh",5),("Assam",5),("Bihar", 5),("Chandigarh",5),
	  ("Chhattisgarh",5),("Dadra and Nagar Haveli",5),("Daman and Diu",5),("Goa",5),("Delhi",5),
	  ("Gujarat",5),("Haryana",5),("Himachal Pradesh",5),("Jammu and Kashmir",5),("Jharkhand",5),
      ("Karnataka",5),("Kerala",5),("Lakshadweep",5),("Madhya Pradesh",5),("Maharashtra",5),("Manipur",5),
      ("Meghalaya",5),("Mizoram",5),("Nagaland",5),("Orissa",5),("Pondicherry",5),("Punjab",5),
      ("Rajasthan",5),("Sikkim",5),("Tamil Nadu",5),("Uttaranchal",5),("Uttar Pradesh",5),("West Bengal",5),
	  ("Somerset", 10), ("Yorkshire", 10);
	  
insert into address(line1,city,state_id,country_id,pin)	 
      values('narasapur,W.G.Dt','Narasapur',5,5,534275);
      
insert into organization(name,address_id) values('slipperscorp',1);
	  