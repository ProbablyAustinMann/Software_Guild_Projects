DROP DATABASE IF EXISTS SuperheroSightingsTest;

CREATE DATABASE SuperheroSightingsTest;

USE SuperheroSightingsTest;

-- Creates Hero table
CREATE TABLE Hero
(
HeroId INT NOT NULL AUTO_INCREMENT,
HeroName VARCHAR(50) NOT NULL,
HeroDescription VARCHAR(300) NOT NULL,
PRIMARY KEY(HeroId)
);

-- Creates Power table
CREATE TABLE Superpower
(
PowerId INT NOT NULL AUTO_INCREMENT,
PowerDescription VARCHAR(300) NOT NULL,
PRIMARY KEY(PowerId)
);

-- Creates Organization table
CREATE TABLE Organization
(
OrganizationId INT NOT NULL AUTO_INCREMENT,
OrgName VARCHAR(80) NOT NULL,
LocationId INT NOT NULL,
Phone VARCHAR(20) NOT NULL,
Email VARCHAR(50) NOT NULL,
PRIMARY KEY(OrganizationId)
);

-- Creates Location table
CREATE TABLE Location
(
LocationId INT NOT NULL AUTO_INCREMENT,
LocationName VARCHAR(30) NOT NULL,
Address VARCHAR(80) NOT NULL,
Latitude DECIMAL(9, 6) NULL,
Longitude DECIMAL(9, 6) NULL,
PRIMARY KEY(LocationId)
);

-- Creates Sighting table
CREATE TABLE Sighting
(
SightingId INT NOT NULL AUTO_INCREMENT,
LocationId INT NOT NULL,
SightingDate DATE NOT NULL,
SightingDescription VARCHAR(300) NOT NULL,
PRIMARY KEY(SightingId)
);

-- Creates a bridge between Hero and Power
CREATE TABLE HeroPower
(
HeroId INT NOT NULL,
PowerId INT NOT NULL
);

-- Creates a bridge between Hero and Organization
CREATE TABLE HeroOrganization
(
HeroId INT NOT NULL,
OrganizationId INT NOT NULL
);

-- Creates a bridge between Hero and Sighting
CREATE TABLE HeroSighting
(
HeroId INT NOT NULL,
SightingId INT NOT NULL
);

-- Establishes Foreign Key relationships
ALTER TABLE Sighting ADD CONSTRAINT FOREIGN KEY(LocationId) REFERENCES Location(LocationId);
ALTER TABLE HeroPower ADD CONSTRAINT FOREIGN KEY(HeroId) REFERENCES Hero(HeroId);
ALTER TABLE HeroPower ADD CONSTRAINT FOREIGN KEY(PowerId) REFERENCES Superpower(PowerId);
ALTER TABLE HeroOrganization ADD CONSTRAINT FOREIGN KEY(HeroId) REFERENCES Hero(HeroId);
ALTER TABLE HeroOrganization ADD CONSTRAINT FOREIGN KEY(OrganizationId) REFERENCES Organization(OrganizationId);
ALTER TABLE HeroSighting ADD CONSTRAINT FOREIGN KEY(HeroId) REFERENCES Hero(HeroId);
ALTER TABLE HeroSighting ADD CONSTRAINT FOREIGN KEY(SightingId) REFERENCES Sighting(SightingId);
ALTER TABLE Organization ADD CONSTRAINT FOREIGN KEY(LocationID) REFERENCES Location(LocationId);

