drop database if exists giftDB; 
create database giftDB; use giftDB; #remember!!!
CREATE TABLE gifts_table( 
	recipient varchar (255), 
	gift varchar(255),
	URL varchar(255) 
);