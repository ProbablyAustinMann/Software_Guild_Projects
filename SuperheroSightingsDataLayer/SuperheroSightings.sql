DROP DATABASE IF EXISTS SuperheroSightings;

CREATE DATABASE SuperheroSightings;

USE SuperheroSightings;

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
LocationId INT NULL,
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
Latitude DECIMAL(11, 7) NULL,
Longitude DECIMAL(11, 7) NULL,
PRIMARY KEY(LocationId)
);

-- Creates Sighting table
CREATE TABLE Sighting
(
SightingId INT NOT NULL AUTO_INCREMENT,
LocationId INT NULL,
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


insert into Hero (HeroId, HeroName, HeroDescription) values (1, 'Gaston', 'Tall Grey Man');
insert into Hero (HeroId, HeroName, HeroDescription) values (2, 'Darlleen', 'Dennys Waitress');
insert into Hero (HeroId, HeroName, HeroDescription) values (3, 'Wren', 'Very Short Young Woman');
insert into Hero (HeroId, HeroName, HeroDescription) values (4, 'Ase', 'Staff Scientist');
insert into Hero (HeroId, HeroName, HeroDescription) values (5, 'Spence', 'High School Student');
insert into Hero (HeroId, HeroName, HeroDescription) values (6, 'Helga', 'CEO of Bank');
insert into Hero (HeroId, HeroName, HeroDescription) values (7, 'Gaultiero', 'Small Old Hispanic Man');
insert into Hero (HeroId, HeroName, HeroDescription) values (8, 'Serge', 'Bottle of Discontinued Soda');
insert into Hero (HeroId, HeroName, HeroDescription) values (9, 'Jermaine', 'Unusually Long Legs');
insert into Hero (HeroId, HeroName, HeroDescription) values (10, 'Ileana', 'Tall Man With Glasses');
insert into Hero (HeroId, HeroName, HeroDescription) values (11, 'Ana', 'Meek Old Lady');
insert into Hero (HeroId, HeroName, HeroDescription) values (12, 'Joycelin', 'Therapist');
insert into Hero (HeroId, HeroName, HeroDescription) values (13, 'Garvin', 'Pizza Delivery Driver');
insert into Hero (HeroId, HeroName, HeroDescription) values (14, 'Rayshell', 'Younc Social Worker');
insert into Hero (HeroId, HeroName, HeroDescription) values (15, 'Othella', 'General Manager of a Bar');
insert into Hero (HeroId, HeroName, HeroDescription) values (16, 'Pierette', 'Made of Metal');
insert into Hero (HeroId, HeroName, HeroDescription) values (17, 'Camel', 'Has Scales');
insert into Hero (HeroId, HeroName, HeroDescription) values (18, 'Charmion', 'Social Worker');
insert into Hero (HeroId, HeroName, HeroDescription) values (19, 'Brit', 'Hockey Coach');
insert into Hero (HeroId, HeroName, HeroDescription) values (20, 'Bill', 'Has Distinct Mustache');
insert into Hero (HeroId, HeroName, HeroDescription) values (21, 'Zarla', 'COvered in Tree Bark');
insert into Hero (HeroId, HeroName, HeroDescription) values (22, 'Tally', 'Has Exo-Skeleton');
insert into Hero (HeroId, HeroName, HeroDescription) values (23, 'Hal', 'Scientist');
insert into Hero (HeroId, HeroName, HeroDescription) values (24, 'Rene', 'Never Wears Pants');
insert into Hero (HeroId, HeroName, HeroDescription) values (25, 'Joey', 'Always Wears a Trench Coat');
insert into Hero (HeroId, HeroName, HeroDescription) values (26, 'Alysia', 'Has No Teeth');
insert into Hero (HeroId, HeroName, HeroDescription) values (27, 'Beale', 'Has One Eye');
insert into Hero (HeroId, HeroName, HeroDescription) values (28, 'Lianna', 'Very Pale Skin');
insert into Hero (HeroId, HeroName, HeroDescription) values (29, 'Barbabra', 'Sometimes On Fire');
insert into Hero (HeroId, HeroName, HeroDescription) values (30, 'Jodi', 'Blue Skin');
insert into Superpower (PowerId, PowerDescription) values (1, 'Super Strength');
insert into Superpower (PowerId, PowerDescription) values (2, 'Ability to Fly');
insert into Superpower (PowerId, PowerDescription) values (3, 'Throws Fireballs');
insert into Superpower (PowerId, PowerDescription) values (4, 'Can Build Anything Quickly');
insert into Superpower (PowerId, PowerDescription) values (5, 'Stretches');
insert into Superpower (PowerId, PowerDescription) values (6, 'Mind Control');
insert into Superpower (PowerId, PowerDescription) values (7, 'Controls Electricity');
insert into Superpower (PowerId, PowerDescription) values (8, 'Shoots Lasers');
insert into Superpower (PowerId, PowerDescription) values (9, 'Can Breathe Underwater');
insert into Superpower (PowerId, PowerDescription) values (10, 'Walks on Water');
insert into Superpower (PowerId, PowerDescription) values (11, 'Secretes Coffee from Nipples');
insert into Superpower (PowerId, PowerDescription) values (12, 'Causes Earthquakes');
insert into Superpower (PowerId, PowerDescription) values (13, 'Changes Skin Color');
insert into Superpower (PowerId, PowerDescription) values (14, 'Can Grow Fingernails Very Fast');
insert into Superpower (PowerId, PowerDescription) values (15, 'Jumps Incredibly High');
insert into Superpower (PowerId, PowerDescription) values (16, 'Has 6ft Arms');
insert into Superpower (PowerId, PowerDescription) values (17, 'Has Third Testicle');
insert into Superpower (PowerId, PowerDescription) values (18, 'Covered in Vines');
insert into Superpower (PowerId, PowerDescription) values (19, 'Can Turn to Stone');
insert into Superpower (PowerId, PowerDescription) values (20, 'Transforms Into a Car');
insert into Superpower (PowerId, PowerDescription) values (21, 'Can See the Future');
insert into Superpower (PowerId, PowerDescription) values (22, 'Heals Fellow Heroes');
insert into Superpower (PowerId, PowerDescription) values (23, 'Shoots Arrows Incredibly Accurately');
insert into Superpower (PowerId, PowerDescription) values (24, 'Can Time Travel');
insert into Superpower (PowerId, PowerDescription) values (25, 'Shoots Snow and Ice');
insert into Superpower (PowerId, PowerDescription) values (26, 'Can Explode');
insert into Superpower (PowerId, PowerDescription) values (27, 'Pilots a Mech');
insert into Superpower (PowerId, PowerDescription) values (28, 'Can Talk to Animals');
insert into Superpower (PowerId, PowerDescription) values (29, 'Turns Into a Dog');
insert into Superpower (PowerId, PowerDescription) values (30, 'Can Eat Anything');
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (1, 'Detroit', '38 Corscot Avenue', -1.3458481, 131.7108641);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (2, 'San Diago', '574 Ronald Regan Way', 63.0331454, 28.4032167);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (3, 'Portland', '5 Prentice Parkway', 25.4106386, 51.1846025);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (4, 'Chicago', '08972 Northland Alley', 52.4555293, 13.339803);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (5, 'Peoria', '9146 Norway Maple Alley', 42.0264858, 43.5525727);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (6, 'Louisville', '20771 Loomis Street', 7.7102381, 3.9190062);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (7, 'Nashville', '93868 North Court', 49.5604375, 13.1979079);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (8, 'Atlanta', '71438 Linden Road', 34.520447, 50.0059337);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (9, 'Jacksonville', '262 Rigney Place', 30.973935, 120.639958);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (10, 'Memphis', '7820 Vidon Parkway', -6.8447302, 108.2427764);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (11, 'Austin', '5 Pankratz Hill', 58.5785836, 16.1948921);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (12, 'Houston', '94 Lerdahl Crossing', 61.5095512, 23.0108503);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (13, 'San Antonio', '360 Monterey Trail', 18.2544504, -76.8865085);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (14, 'Kansas City', '80744 Briar Crest Alley', -31.4325479, -64.1305924);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (15, 'St. Louis', '88864 Coolidge Drive', 53.00942, 17.73989);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (16, 'Indianapolis', '24 Sutteridge Avenue', 56.057734, 24.4027094);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (17, 'Brooklyn', '4659 Shelley Court', -15.2475119, -40.2509918);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (18, 'The Bronx', '51 Pine View Point', -46.5603901, 169.4690405);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (19, 'Long Island', '27164 Swallow Point', '-6.7839', '111.6394');
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (20, 'Toronto', '8 Chive Point', '39.46667', '22.73333');
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (21, 'Quebec', '31554 Susan Park', -34.6161437, -58.5238406);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (22, 'Phoenix', '0 Nancy Hill', 26.641315, 100.222545);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (23, 'Santa Fe', '49 Muir Drive', 56.5385265, 14.1115837);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (24, 'Denver', '200 Fairfield Avenue', 31.871173, 121.181615);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (25, 'Boulder', '706 Barnett Hill', 47.772714, -1.813332);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (26, 'Boston', '1484 Anniversary Court', -17.8519791, 25.8285153);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (27, 'Celevland', '14089 Bobwhite Street', 53.450694, -6.1479779);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (28, 'Lexington', '903 Grover Road', 23.374499, 116.739634);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (29, 'Montgomery', '89 Nelson Court', 51.8417492, 5.8715134);
insert into Location (LocationId, LocationName, Address, Latitude, Longitude) values (30, 'Little Rock', '2 Corry Plaza', 45.1526707, 100.1073667);
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (1, 'Mod Squad', 1, '805-320-7876', 'xholmyard0@pinterest.com');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (2, 'Copyright-Friendly Justice League Copy', 2, '537-632-3994', 'nstubbs1@wp.com');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (3, 'Angry Young Men', 3, '577-174-2955', 'jstuckow2@businessweek.com');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (4, 'WimpSquad', 4, '257-101-2257', 'dbland3@pen.io');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (5, 'Nameless Organization', 5, '860-486-0050', 'hmckmurrie4@mail.ru');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (6, 'SquatchWatch', 6, '123-182-9464', 'rkytley5@bloglines.com');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (7, 'The Pests', 7, '217-272-3294', 'jwilleson6@posterous.com');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (8, 'Red Team', 8, '143-568-7696', 'adallewater7@google.pl');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (9, 'Bronx Boys', 9, '641-514-9175', 'ecrome8@amazonaws.com');
insert into Organization (OrganizationId, OrgName, LocationId, Phone, Email) values (10, 'Avengers But Worse', 10, '702-951-1220', 'mgarmey9@technorati.com');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (1, 1, '2016-02-02', 'Mysterious flying man');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (2, 2, '2013-10-23', 'Saw a man turn blue');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (3, 3, '2015-09-12', 'A young woman climbed up a wall');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (4, 4, '2016-02-09', 'Man caught on fire and ran away');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (5, 5, '2014-11-17', 'Mysterious cold air surrounds woman');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (6, 6, '2018-05-09', 'Man with rocky skin seen');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (7, 7, '2016-06-17', 'Giant robot showdown');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (8, 8, '2015-06-11', 'Woman vanished, then re-appeared');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (9, 9, '2017-09-09', 'Child clapped hands, rainstorm began');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (10, 10, '2016-11-02', 'Snowstorm started by crying man');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (11, 11, '2015-07-09', 'I`m not even sure how to describe this');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (12, 12, '2018-06-24', 'Fastest man alive seen');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (13, 13, '2015-02-22', 'Reptile man');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (14, 14, '2017-05-07', 'Strange inside-out creature');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (15, 15, '2015-08-25', 'Maybe a hero, maybe just a really large man');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (16, 16, '2017-04-26', 'Either hero, or mentally ill man');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (17, 17, '2015-01-06', 'Homeless vagrant read my mind');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (18, 18, '2018-01-18', 'Am I going insane?');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (19, 19, '2015-10-11', 'I still don`t believe this happened');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (20, 20, '2018-01-25', 'I think that tree is human');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (21, 21, '2016-02-29', 'Man wipes another man`s memory');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (22, 22, '2017-09-13', 'Child causes electrical interference');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (23, 23, '2016-03-18', 'Woman turns into a dog');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (24, 24, '2015-01-09', 'Man turns to water');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (25, 25, '2018-04-14', 'The mysterious snake man');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (26, 26, '2017-08-17', 'A scream that shatters windows');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (27, 27, '2017-01-16', 'Are dinosaurs still alive?');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (28, 28, '2015-01-27', 'Another animal transformation case');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (29, 29, '2016-05-18', 'Man explodes');
insert into Sighting (SightingId, LocationId, SightingDate, SightingDescription) values (30, 30, '2014-09-18', 'Magnetic man experience');
insert into HeroPower (HeroId, PowerId) values (1, 1);
insert into HeroPower (HeroId, PowerId) values (2, 2);
insert into HeroPower (HeroId, PowerId) values (3, 3);
insert into HeroPower (HeroId, PowerId) values (4, 4);
insert into HeroPower (HeroId, PowerId) values (5, 5);
insert into HeroPower (HeroId, PowerId) values (6, 6);
insert into HeroPower (HeroId, PowerId) values (7, 7);
insert into HeroPower (HeroId, PowerId) values (8, 8);
insert into HeroPower (HeroId, PowerId) values (9, 9);
insert into HeroPower (HeroId, PowerId) values (10, 10);
insert into HeroPower (HeroId, PowerId) values (11, 11);
insert into HeroPower (HeroId, PowerId) values (12, 12);
insert into HeroPower (HeroId, PowerId) values (13, 13);
insert into HeroPower (HeroId, PowerId) values (14, 14);
insert into HeroPower (HeroId, PowerId) values (15, 15);
insert into HeroPower (HeroId, PowerId) values (16, 16);
insert into HeroPower (HeroId, PowerId) values (17, 17);
insert into HeroPower (HeroId, PowerId) values (18, 18);
insert into HeroPower (HeroId, PowerId) values (19, 19);
insert into HeroPower (HeroId, PowerId) values (20, 20);
insert into HeroPower (HeroId, PowerId) values (21, 21);
insert into HeroPower (HeroId, PowerId) values (22, 22);
insert into HeroPower (HeroId, PowerId) values (23, 23);
insert into HeroPower (HeroId, PowerId) values (24, 24);
insert into HeroPower (HeroId, PowerId) values (25, 25);
insert into HeroPower (HeroId, PowerId) values (26, 26);
insert into HeroPower (HeroId, PowerId) values (27, 27);
insert into HeroPower (HeroId, PowerId) values (28, 28);
insert into HeroPower (HeroId, PowerId) values (29, 29);
insert into HeroPower (HeroId, PowerId) values (30, 30);
insert into HeroOrganization (HeroId, OrganizationId) values (1, 1);
insert into HeroOrganization (HeroId, OrganizationId) values (2, 2);
insert into HeroOrganization (HeroId, OrganizationId) values (3, 3);
insert into HeroOrganization (HeroId, OrganizationId) values (4, 4);
insert into HeroOrganization (HeroId, OrganizationId) values (5, 5);
insert into HeroOrganization (HeroId, OrganizationId) values (6, 6);
insert into HeroOrganization (HeroId, OrganizationId) values (7, 7);
insert into HeroOrganization (HeroId, OrganizationId) values (8, 8);
insert into HeroOrganization (HeroId, OrganizationId) values (9, 9);
insert into HeroOrganization (HeroId, OrganizationId) values (10, 10);
insert into HeroOrganization (HeroId, OrganizationId) values (11, 1);
insert into HeroOrganization (HeroId, OrganizationId) values (12, 2);
insert into HeroOrganization (HeroId, OrganizationId) values (13, 3);
insert into HeroOrganization (HeroId, OrganizationId) values (14, 4);
insert into HeroOrganization (HeroId, OrganizationId) values (15, 5);
insert into HeroOrganization (HeroId, OrganizationId) values (16, 6);
insert into HeroOrganization (HeroId, OrganizationId) values (17, 7);
insert into HeroOrganization (HeroId, OrganizationId) values (18, 8);
insert into HeroOrganization (HeroId, OrganizationId) values (19, 9);
insert into HeroOrganization (HeroId, OrganizationId) values (20, 10);
insert into HeroOrganization (HeroId, OrganizationId) values (21, 1);
insert into HeroOrganization (HeroId, OrganizationId) values (22, 2);
insert into HeroOrganization (HeroId, OrganizationId) values (23, 3);
insert into HeroOrganization (HeroId, OrganizationId) values (24, 4);
insert into HeroOrganization (HeroId, OrganizationId) values (25, 5);
insert into HeroOrganization (HeroId, OrganizationId) values (26, 6);
insert into HeroOrganization (HeroId, OrganizationId) values (27, 7);
insert into HeroOrganization (HeroId, OrganizationId) values (28, 8);
insert into HeroOrganization (HeroId, OrganizationId) values (29, 9);
insert into HeroOrganization (HeroId, OrganizationId) values (30, 10);
insert into HeroSighting (HeroId, SightingId) values (1, 1);
insert into HeroSighting (HeroId, SightingId) values (2, 2);
insert into HeroSighting (HeroId, SightingId) values (3, 3);
insert into HeroSighting (HeroId, SightingId) values (4, 4);
insert into HeroSighting (HeroId, SightingId) values (5, 5);
insert into HeroSighting (HeroId, SightingId) values (6, 6);
insert into HeroSighting (HeroId, SightingId) values (7, 7);
insert into HeroSighting (HeroId, SightingId) values (8, 8);
insert into HeroSighting (HeroId, SightingId) values (9, 9);
insert into HeroSighting (HeroId, SightingId) values (10, 10);
insert into HeroSighting (HeroId, SightingId) values (11, 11);
insert into HeroSighting (HeroId, SightingId) values (12, 12);
insert into HeroSighting (HeroId, SightingId) values (13, 13);
insert into HeroSighting (HeroId, SightingId) values (14, 14);
insert into HeroSighting (HeroId, SightingId) values (15, 15);
insert into HeroSighting (HeroId, SightingId) values (16, 16);
insert into HeroSighting (HeroId, SightingId) values (17, 17);
insert into HeroSighting (HeroId, SightingId) values (18, 18);
insert into HeroSighting (HeroId, SightingId) values (19, 19);
insert into HeroSighting (HeroId, SightingId) values (20, 20);
insert into HeroSighting (HeroId, SightingId) values (21, 21);
insert into HeroSighting (HeroId, SightingId) values (22, 22);
insert into HeroSighting (HeroId, SightingId) values (23, 23);
insert into HeroSighting (HeroId, SightingId) values (24, 24);
insert into HeroSighting (HeroId, SightingId) values (25, 25);
insert into HeroSighting (HeroId, SightingId) values (26, 26);
insert into HeroSighting (HeroId, SightingId) values (27, 27);
insert into HeroSighting (HeroId, SightingId) values (28, 28);
insert into HeroSighting (HeroId, SightingId) values (29, 29);
insert into HeroSighting (HeroId, SightingId) values (30, 30);