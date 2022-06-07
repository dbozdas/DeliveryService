SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0; 
Delete from Drivers
where id=1;

SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0; 
Delete from Customers
where date_Of_Birth<'20040101' ;

SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0; 
Delete from Drivers
where rating<2.00 ;

SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0; 
Delete from Cities
where name='Chicago' ;

SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0; 
Delete from Zip_Codes
where zip_Code='10001' ;