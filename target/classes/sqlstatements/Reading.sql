select*From States;
select*From Cities;
select*From Zip_Codes;
select*From Addresses;
select*From Customers;
select*From Restaurants;
select*From Drivers;
select*From States;
select*From Statuses;
select*From Week_Days;
select*From Available_Hours;
select*From Orders;
select*From Orders_has_Menu_Items;
select*From Menu_Items;
select*From Insurances;


SELECT Drivers.first_Name  from Drivers Inner Join Addresses ON Drivers.Addresses_id=Addresses.id Where Addresses.streetName='2nd';


SELECT Drivers.first_Name, Drivers.last_Name From Drivers 
Inner Join Addresses ON Drivers.Addresses_id=Addresses.id 
Inner Join Zip_Codes ON Addresses.Zip_Codes_id=Zip_Codes.id 
Inner Join Cities ON Zip_Codes.Cities_id=Cities.id
Inner Join States On Cities.States_id=States.id
Where States.name='Alaska';


SELECT Count(States.name),States.name From Drivers 
Inner Join Addresses ON Drivers.Addresses_id=Addresses.id 
Inner Join Zip_Codes ON Addresses.Zip_Codes_id=Zip_Codes.id 
Inner Join Cities ON Zip_Codes.Cities_id=Cities.id
Inner Join States On Cities.States_id=States.id group by States.name;

SELECT Count(States.name),States.name From Customers 
Inner Join Addresses ON Customers.Addresses_id=Addresses.id 
Inner Join Zip_Codes ON Addresses.Zip_Codes_id=Zip_Codes.id 
Inner Join Cities ON Zip_Codes.Cities_id=Cities.id
Inner Join States On Cities.States_id=States.id group by States.name;

SELECT Count(States.name),States.name From Restaurants 
Inner Join Addresses ON Restaurants.Addresses_id=Addresses.id 
Inner Join Zip_Codes ON Addresses.Zip_Codes_id=Zip_Codes.id 
Inner Join Cities ON Zip_Codes.Cities_id=Cities.id
Inner Join States On Cities.States_id=States.id group by States.name;

SELECT Count(Menu_Items.name), Menu_Items.name From Orders
Join Orders_has_Menu_Items ON Orders.id=Orders_has_Menu_Items.Orders_id
Join Menu_Items ON Orders_has_Menu_Items.Menu_Items_id=Menu_Items.id
Group by Menu_Items.name 
Having Count(Menu_Items.name)>2;

SELECT MAX(Menu_Items.price), Menu_Items.name From Orders
Join Orders_has_Menu_Items ON Orders.id=Orders_has_Menu_Items.Orders_id
Join Menu_Items ON Orders_has_Menu_Items.Menu_Items_id=Menu_Items.id
Group by Menu_Items.name
Order by MAX(Menu_Items.price) DESC; 
