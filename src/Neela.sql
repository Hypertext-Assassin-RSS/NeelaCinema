DROP DATABASE IF EXISTS Neela;
CREATE DATABASE IF NOT EXISTS Neela;
SHOW DATABASES ;
USE Neela;
//------------------------------------------------------
DROP TABLE IF EXISTS Customer_Detail;
CREATE TABLE Customer_Detail (
    ID varchar(255) NOT NULL,
    Name varchar(255) NOT NULL,
    Contact varchar(255) NOT NULL,
    PRIMARY KEY (ID)
);
DESCRIBE Customer_Detail;
//------------------------------------------------------
DROP TABLE IF EXISTS Reservation_Detail;
CREATE TABLE IF NOT EXISTS Reservation_Detail(
   reservation_no VARCHAR(16),
   customer_id VARCHAR(45) NOT NULL ,
   PRIMARY KEY (reservation_no),
   FOREIGN KEY (customer_id) REFERENCES Customer_Detail(id) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Reservation_Detail;
//-----------------------------------------------------
DROP TABLE IF EXISTS Reservation;
CREATE TABLE IF NOT EXISTS Reservation(
   reservation_no VARCHAR(16),
   customer_id VARCHAR(45) NOT NULL ,
   customer_name VARCHAR(45),
   total double,
   CONSTRAINT PRIMARY KEY (reservation_no),
   CONSTRAINT FOREIGN KEY (customer_id) REFERENCES Customer_Detail(id) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Reservation;
//------------------------------------------------------
DROP TABLE IF EXISTS Tickets;
CREATE TABLE IF NOT EXISTS Tickets(
   tickets_id VARCHAR(16) NOT NULL,
   reservation_no VARCHAR(45),
   expire_date VARCHAR(45),
   ticket_QTY int,
   total double,
   CONSTRAINT PRIMARY KEY (tickets_id),
   CONSTRAINT FOREIGN KEY (reservation_no) REFERENCES Reservation(reservation_no) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Tickets;
//-------------------------------------------------------
DROP TABLE IF EXISTS Vehicle;
CREATE TABLE IF NOT EXISTS Vehicle(
   vehicle_no VARCHAR(16) NOT NULL,
   customer_id VARCHAR(45) NOT NULL,
   vehicle_type VARCHAR(45),
   PRIMARY KEY (vehicle_no),
   FOREIGN KEY (customer_id) REFERENCES Customer_Detail(ID) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Vehicle;
//-------------------------------------------------------
DROP TABLE IF EXISTS Parking;
CREATE TABLE IF NOT EXISTS Parking(
   parking_no VARCHAR(16) NOT NULL,
   vehicle_no VARCHAR(16) NOT NULL,
   customer_id VARCHAR(45) NOT NULL,
   vehicle_type VARCHAR(15),
   CONSTRAINT PRIMARY KEY (parking_no),
   FOREIGN KEY (vehicle_no) REFERENCES Vehicle(vehicle_no) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Parking;
//-------------------------------------------------------
DROP TABLE IF EXISTS Owner;
CREATE TABLE IF NOT EXISTS Owner(
   owner_id VARCHAR(15),
   owner_name VARCHAR(45) NOT NULL DEFAULT 'Unknown',
   owner_address TEXT,
   owner_contact_no VARCHAR(10),
   CONSTRAINT PRIMARY KEY (owner_id)
);
SHOW TABLES ;
DESCRIBE Owner;
//------------------------------------------------------
DROP TABLE IF EXISTS Employ;
CREATE TABLE IF NOT EXISTS Employ(
   employ_id VARCHAR(15),
   employ_name VARCHAR(45) NOT NULL DEFAULT 'Unknown',
   employ_address TEXT,
   employ_contact_no VARCHAR(10),
   CONSTRAINT PRIMARY KEY (employ_id)
);
SHOW TABLES ;
DESCRIBE Employ;
//------------------------------------------------------
DROP TABLE IF EXISTS Section;
CREATE TABLE IF NOT EXISTS Section(
   section_name VARCHAR(45) NOT NULL DEFAULT 'Unknown',
   contact_no VARCHAR(10),
   employ_count int,
   CONSTRAINT PRIMARY KEY (section_name)
);
SHOW TABLES ;
DESCRIBE Section;
//------------------------------------------------------
DROP TABLE IF EXISTS Package;
CREATE TABLE IF NOT EXISTS Package(
   package_id VARCHAR(15),
   package_name VARCHAR(30),
   package_details VARCHAR(65),
   package_price double,
   CONSTRAINT PRIMARY KEY (package_id)
);
SHOW TABLES ;
DESCRIBE Package;
//------------------------------------------------------
DROP TABLE IF EXISTS Studio;
CREATE TABLE IF NOT EXISTS Studio(
   studio_no VARCHAR(45) NOT NULL DEFAULT 'Unknown',
   studio_name VARCHAR(10),
   CONSTRAINT PRIMARY KEY (studio_no)
);
SHOW TABLES ;
DESCRIBE Studio;
//------------------------------------------------------
DROP TABLE IF EXISTS FIlm;
CREATE TABLE IF NOT EXISTS FIlm(
   film_name VARCHAR(45) NOT NULL DEFAULT 'Unknown',
   studio_no VARCHAR(10),
   CONSTRAINT PRIMARY KEY (film_name),
   CONSTRAINT FOREIGN KEY (studio_no) REFERENCES Studio(studio_no) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE FIlm;
//------------------------------------------------------
DROP TABLE IF EXISTS Schedule;
CREATE TABLE IF NOT EXISTS Schedule(
   film_name VARCHAR(45) NOT NULL DEFAULT 'Unknown',
   studio_name VARCHAR(10),
   studio_no VARCHAR(10),
   date_time VARCHAR(30),
   CONSTRAINT FOREIGN KEY (studio_no) REFERENCES Studio(studio_no) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Schedule;
//------------------------------------------------------






