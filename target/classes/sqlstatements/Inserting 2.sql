

SET FOREIGN_KEY_CHECKS = 0; 

TRUNCATE table States; TRUNCATE table Zip_Codes; TRUNCATE table Cities; TRUNCATE table Customers; 
TRUNCATE table Menu_Items; TRUNCATE table Orders_has_Menu_Items; TRUNCATE table Orders;
TRUNCATE table Insurances; TRUNCATE table Vehicles; TRUNCATE table Drivers; 
TRUNCATE table Customers; TRUNCATE table Restaurants; 
TRUNCATE table Week_Days; TRUNCATE table Available_Hours; 
TRUNCATE table Statuses; 
SET FOREIGN_KEY_CHECKS = 1;	

insert into States(code, name)
values
('AK', 'Alaska'),
('AL', 'Alabama'),
('AZ', 'Arizona'),
('AR', 'Arkansas'),
('CA', 'California'),
('CO', 'Colorado'),
('CT', 'Connecticut'),
('DE', 'Delaware'),
('DC', 'District of Columbia'),
('FL', 'Florida'),
('GA', 'Georgia'),
('HI', 'Hawaii'),
('ID', 'Idaho'),
('IL', 'Illinois'),
('IN', 'Indiana'),
('IA', 'Iowa'),
('KS', 'Kansas'),
('KY', 'Kentucky'),
('LA', 'Louisiana'),
('ME', 'Maine'),
('MD', 'Maryland'),
('MA', 'Massachusetts'),
('MI', 'Michigan'),
('MN', 'Minnesota'),
('MS', 'Mississippi'),
('MO', 'Missouri'),
('MT', 'Montana'),
('NE', 'Nebraska'),
('NV', 'Nevada'),
('NH', 'New Hampshire'),
('NJ', 'New Jersey'),
('NM', 'New Mexico'),
('NY', 'New York'),
('NC', 'North Carolina'),
('ND', 'North Dakota'),
('OH', 'Ohio'),
('OK', 'Oklahoma'),
('OR', 'Oregon'),
('PA', 'Pennsylvania'),
('PR', 'Puerto Rico'),
('RI', 'Rhode Island'),
('SC', 'South Carolina'),
('SD', 'South Dakota'),
('TN', 'Tennessee'),
('TX', 'Texas'),
('UT', 'Utah'),
('VT', 'Vermont'),
('VA', 'Virginia'),
('WA', 'Washington'),
('WV', 'West Virginia'),
('WI', 'Wisconsin'),
('WY', 'Wyoming');

insert into Cities (name,States_id)
	values ('	Anchorage	','	1'	),
			('	Huntsville	','	2'	),
			('	Birmingham	','	2'	),
			('	Montgomery	','	2'	),
			('	Mobile	','	2'	),
			('	Phoenix	','	3'	),
			('	Tucson	','	3'	),
			('	Mesa	','	3'	),
			('	Chandler	','	3'	),
			('	Scottsdale	','	3'	),
			('	Gilbert	','	3'	),
			('	Glendale	','	3'	),
			('	Tempe	','	3'	),
			('	Peoria	','	3'	),
			('	Surprise	','	3'	),
			('	Little Rock	','	4'	),
			('	Los Angeles	','	5'	),
			('	San Diego	','	5'	),
			('	San Jose	','	5'	),
			('	San Francisco	','	5'	),
			('	Fresno	','	5'	),
			('	Sacramento	','	5'	),
			('	Long Beach	','	5'	),
			('	Oakland	','	5'	),
			('	Bakersfield	','	5'	),
			('	Anaheim	','	5'	),
			('	Riverside	','	5'	),
			('	Santa Ana	','	5'	),
			('	Stockton	','	5'	),
			('	Irvine	','	5'	),
			('	Chula Vista	','	5'	),
			('	Fremont	','	5'	),
			('	Moreno Valley	','	5'	),
			('	Fontana	','	5'	),
			('	Modesto	','	5'	),
			('	San Bernardino	','	5'	),
			('	Santa Clarita	','	5'	),
			('	Oxnard	','	5'	),
			('	Ontario	','	5'	),
			('	Huntington Beach	','	5'	),
			('	Glendale	','	5'	),
			('	Elk Grove	','	5'	),
			('	Rancho Cucamonga	','	5'	),
			('	Santa Rosa	','	5'	),
			('	Oceanside	','	5'	),
			('	Corona	','	5	'),
			('	Garden Grove	','	5'	),
			('	Hayward	','	5'	),
			('	Salinas	','	5'	),
			('	Lancaster	','	5'	),
			('	Sunnyvale	','	5'	),
			('	Palmdale	','	5'	),
			('	Escondido	','	5'	),
			('	Pomona	','	5'	),
			('	Roseville	','	5'	),
			('	Denver	','	6'	),
			('	Colorado Springs	','	6'	),
			('	Aurora	','	6'	),
			('	Fort Collins	','	6'	),
			('	Lakewood	','	6'	),
			('	Thornton	','	6'	),
			('	Bridgeport	','	7'	),
			('	Washington	','	9'	),
			('	Jacksonville	','	10	'),
			('	Miami	','	10'	),
			('	Tampa	','	10	'),
			('	Orlando	','	10	'),
			('	St. Petersburg	','	10'),
			('	Hialeah	','	10'	),
			('	Port St. Lucie	','	10'	),
			('	Cape Coral	','	10'	),
			('	Tallahassee	','	10'	),
			('	Fort Lauderdale	','	10'),
			('	Pembroke Pines	','	10'),
			('	Hollywood	','	10'	),
			('	Miramar	','	10'	),
			('	Atlanta	','	11'	),
			('	Columbus	','	11'	),
			('	Augusta	','	11'	),
			('	Macon	','	11'	),
			('	Honolulu	','	12'	),
			('	Boise	','	13'	),
			('	Chicago	','	14'	),
			('	Aurora	','	14'	),
			('	Naperville	','	14'	),
			('	Joliet	','	14'	),
			('	Rockford	','	14'),
			('	Indianapolis	','	15'	),
			('	Fort Wayne	','	15'	);
            
insert into Zip_Codes (zip_Code,Cities_id)
	values ('10001','1'),('10002','1'),('10003','1'),
			('20001','2'),('20002','2'),('20003','2'),('20004','2'),('20005','2'),('20006','2'),
			('30001','3'),('30002','3'),('30003','3'),('30004','3'),('30005','3'),
			('40001','4'),('40002','4'),('40003','4'),('40004','4'),('40005','4'),('40006','4'),
			('50001','5'),('50002','5'),('50003','5'),('50004','5'),('50005','5'),('50006','5'),('50007','5'),
			('60001','6'),('60002','6'),('60003','6'),('60004','6'),
			('70001','7'),
			('90001','9'),('90002','9'),
			('10010','10'),('10011','10'),('10012','10'),('10013','10'),('10014','10'),('10015','10'),
			('11010','11'),('11011','11'),('11012','11'),('11013','11'),('11014','11'),('11015','11'),('11016','11'),('11017','11'),('11018','11'),
			('12010','12'),('12011','12'),('12012','12'),('12013','12'),('12014','12'),('12015','12'),('12016','12'),
			('13010','13'),('13011','13'),('13012','13'),('13013','13'),('13014','13'),
			('14010','14'),('14011','14'),('14012','14'),('14013','14'),
			('15010','15'),('15011','15'),('15012','15');
            
insert into Addresses (streetNumber, streetName,Zip_Codes_id)
	values 	('2147','1th','1'),('3550','2nd','1'),('1233','Red','3'),
            ('4810','3rd','7'),('4810','3rd','8'),('8779','Yellow','9'),
            ('2200','Jackson','26'),('2033','Monroe','27'),('9889','Blue','25'),
            ('1918','Lake','39'),('962','Ohio','40'),('962','Ontorio','38'),
            ('7','Roscoe','54'),('287','Melrose','55'),('663','Division','56'),
            ('220','Addison','63'),('4680','Irvin','64'),('4900','Fullerton','65');
            
            insert into Insurances (effective_Date,expiration_Date,liability_Coverage)
values	('20220101','20220701','10'),
		('20220201','20220801','10'),
        ('20220301','20220901','10'),
        ('20220401','20221001','10'),
        ('20220501','20221101','10'),
        ('20220601','20221201','10'),
        ('20220701','20230101','10'),
		('20220801','20230201','10'),
        ('20220901','20230301','10'),
        ('20221001','20230401','10'),
        ('20221101','20230501','10'),
        ('20221201','20230601','10'),
        
		('20220101','20220701','20'),
		('20220201','20220801','20'),
        ('20220301','20220901','20'),
        ('20220401','20221001','20'),
        ('20220501','20221101','20'),
        ('20220601','20221201','20'),
        ('20220701','20230101','20'),
		('20220801','20230201','20'),
        ('20220901','20230301','20'),
        ('20221001','20230401','20'),
        ('20221101','20230501','20'),
        ('20221201','20230601','20');
        
insert into Vehicles (plate_Number,make,model,year,inspection_Expireation_Date,Drivers_id,Insurances_id)
values	('9811LY','Lincoln','MKS','2014','20220801','1','1'),
		('9493LY','Mercedes','Metris','2020','20220801','4','2'),
        ('9505LY','Ford','Expedition','2018','20220801','3','15'),
        ('9753Y','Mercedes','S550','2022','20220801','4','1'),
        ('8725LY','Jaguar','XJE','2023','20220801','5','4');

insert into Statuses(status_Name)
values
('Your order is placed'),
('Your order is accepted'),
('Your order is being prepared'),
('Your order is ready for delivery'),
('Your order is on the way'),
('Driver is arrived'),
('Your Order is delivered');

insert into Week_Days(days_Name)
values
('Sunday'),
('Monday'),
('Tuesday'),
('Wednesday'),
('Thursayday'),
('Friday'),
('Saturday');

insert into Drivers (first_Name,last_Name,date_Of_Birth,rating,email,phone_Number,Addresses_id)
values	('Driver 1 ','L1',19890719,'5.00','driver1@gmail.com','3121234598','2'),
		('Driver 2','L2',19880311,'4.00','driver2@gmail.com','3125672354','5'),
        ('Driver 3','L3',19981020,'3.00','driver3@gmail.com','3125436524','8'),
        ('Driver 4','L4',20001117,'2.00','driver4@gmail.com','7739753565','11'),
        ('Driver 5','L5',19650401,'1.00','driver5@gmail.com','6301458765','13'),
		('Driver 6','L6',19750727,'4.50','driver6@gmail.com','7734914574','4');
        
insert into Available_Hours(shift_Start_Time,shift_End_Time,Week_Days_id,Drivers_id)
values
('07:00:00','12:00:00','1','1'),
('07:00:00','12:00:00','2','1'),
('07:00:00','12:00:00','3','1'),
('07:00:00','12:00:00','4','1'),
('07:00:00','12:00:00','5','1'),

('07:00:00','12:00:00','1','4'),
('07:00:00','12:00:00','2','4'),
('07:00:00','12:00:00','3','4'),
('07:00:00','12:00:00','6','4'),
('07:00:00','12:00:00','7','4'),

('12:00:00','17:00:00','1','2'),
('12:00:00','17:00:00','2','2'),
('12:00:00','17:00:00','3','2'),
('12:00:00','17:00:00','4','2'),
('12:00:00','17:00:00','5','2'),

('12:00:00','17:00:00','1','5'),
('12:00:00','17:00:00','2','5'),
('12:00:00','17:00:00','3','5'),
('12:00:00','17:00:00','6','5'),
('12:00:00','17:00:00','7','5'),

('17:00:00','22:00:00','1','3'),
('17:00:00','22:00:00','2','3'),
('17:00:00','22:00:00','3','3'),
('17:00:00','22:00:00','4','3'),
('17:00:00','22:00:00','5','3'),

('17:00:00','22:00:00','1','6'),
('17:00:00','22:00:00','2','6'),
('17:00:00','22:00:00','3','6'),
('17:00:00','22:00:00','6','6'),
('17:00:00','22:00:00','7','6');

insert into Customers (first_Name,last_Name,email,phone_Number,date_Of_Birth,Addresses_id)
values	('Deniz','Bozdas','dbozdas@gmail.com','3125029463',19890719,'1'),
		('Ezgi','Bozdas','ezbozdas@gmail.com','7734914574',19880311,'4'),
        ('Vildan','Mayul','vmayul@gmail.com','3121234567',19981020,'7'),
        ('Sura','Sal','ssal@gmail.com','7731236790',20001117,'10'),
        ('Veysel','Hasanov','vhasanov@gmail.com','6300984576',19650401,'13');
	
	
insert into Restaurants(name,phone_Number,rating,Addresses_id)
values	('Turquoise Restaurant','7735493523','4.9','3'),
		('Bordeaux Lounge','7735493570','4.7','6'),
        ('Sea And Olive','8465497098','3.9','9'),
        ('Istanbul','2245493545','3.1','12'),
        ('Morton','7085493545','2.0','15');
        
insert into Menu_Items(name,price,size,special_Inst)
values 	('Soup','9.00','',''),
		('Bread','2.00','',''),
        ('Beef Kebab','19.00','',''),
        ('Chicken Kebab','17.00','',''),
        ('Lamb Kebab','22.00','',''),
        ('Risotto','25.00','',''),
        ('Salmon','23.00','',''),
        ('Mix Vegie','7.00','Small','Vegan'),
        ('Mix Vegie','7.00','Medium','Vegan');
        
insert into Orders (order_Date,special_Instrictions,Customers_id,Restaurants_id,Drivers_id,Statuses_id)
values	('20220101','','1','1','1','1'),
		('20220101','','2','2','2','4'),
        ('20220101','','3','3','3','2'),
        ('20220101','CurbSide Delivery','4','4','4','5'),
        ('20220101','Gluten Free','5','5','5','6');
        
insert into Orders_has_Menu_Items (Orders_id,Menu_Items_id)
values	('1','1'),('1','3'),('1','4'),('1','5'),
		('2','3'),('2','4'),('2','5'),('2','6'),('2','7'),
        ('3','1'),
        ('4','1'),('4','2'),('4','3'),
        ('5','4'), ('5','5'), ('5','8');
        




            
