DROP DATABASE IF EXISTS HotelReservation;

CREATE DATABASE HotelReservation;

use HotelReservation;

 CREATE TABLE HotelReservation.ReservationInfo
(ReservationID int NOT NULL auto_increment,
PromoID int NULL,
CustomerID int NOT NULL,
DetailsID int NULL,
TotalID int NOT NULL,
StartDate date NOT NULL,
EndDate date NOT NULL,
PRIMARY KEY(ReservationID));

CREATE TABLE HotelReservation.Customer
(CustomerID int NOT NULL auto_increment,
FirstName varchar(30) NOT NULL,
LastName varchar(30) NOT NULL,
Phone varchar(20) NOT NULL,
Email varchar(80) NOT NULL,
BirthDate date NOT NULL,
PRIMARY KEY(CustomerID));

CREATE TABLE HotelReservation.Guest
(GuestID int NOT NULL auto_increment,
FirstName varchar(30) NULL,
LastName varchar(30) NULL,
PRIMARY KEY(GuestID));

CREATE TABLE HotelReservation.ReservationGuest
(ReservationGuestID int NOT NULL auto_increment,
ReservationID int NOT NULL,
GuestID int NOT NULL,
PRIMARY KEY(ReservationGuestID));

CREATE TABLE HotelReservation.Room
(RoomID int NOT NULL auto_increment,
RoomTypeID int NOT NULL,
Floor int NOT NULL,
`Number` int NOT NULL,
PRIMARY KEY (RoomID));

CREATE TABLE HotelReservation.RoomType
(RoomTypeID int NOT NULL auto_increment,
BedSize varchar(15) NOT NULL,
Occupancy int NOT NULL,
PRIMARY KEY (RoomTypeID));

CREATE TABLE HotelReservation.ReservationRoom
(ReservationRoomID int NOT NULL auto_increment,
ReservationID int NOT NULL,
RoomID int NOT NULL,
PRIMARY KEY (ReservationRoomID));

CREATE TABLE HotelReservation.AddOn
(AddOnID int NOT NULL auto_increment,
ItemAdded varchar(60) NULL,
Price decimal(5, 2) NULL,
PRIMARY KEY (AddOnID));

CREATE TABLE HotelReservation.RoomAddOn
(RoomAddOnID int NOT NULL auto_increment,
RoomID int NOT NULL,
AddOnID int NOT NULL,
PRIMARY KEY (RoomAddOnID));

CREATE TABLE HotelReservation.Details
(DetailsID int NOT NULL auto_increment,
PRIMARY KEY (DetailsID));

CREATE TABLE HotelReservation.AddOnDetails
(AddOnID int NOT NULL,
DetailsID int NOT NULL);

CREATE TABLE HotelReservation.Promos
(PromoID int NOT NULL auto_increment,
PromoTypeID int NULL,
StartDate date NULL,
EndDate date NULL,
PRIMARY KEY (PromoID));

CREATE TABLE HotelReservation.PromoType
(PromoTypeID int NOT NULL auto_increment,
`Type` varchar(40) NOT NULL,
`Value` varchar(40) NOT NULL,
 PRIMARY KEY (PromoTypeID));
 
 CREATE TABLE HotelReservation.Total
 (TotalID int NOT NULL auto_increment,
 Tax decimal (4, 2) NOT NULL,
 Total decimal (12, 2) NOT NULL,
 RateChanges decimal(4, 2) NULL,
 PRIMARY KEY (TotalID));
 
ALTER TABLE HotelReservation.ReservationInfo add constraint FOREIGN KEY (PromoID) REFERENCES HotelReservation.Promos(PromoID);
ALTER TABLE HotelReservation.ReservationInfo add constraint FOREIGN KEY (CustomerID) REFERENCES HotelReservation.Customer(CustomerID);
ALTER TABLE HotelReservation.ReservationInfo add constraint FOREIGN KEY (DetailsID) REFERENCES HotelReservation.Details(DetailsID);
ALTER TABLE HotelReservation.ReservationInfo add constraint FOREIGN KEY (TotalID) REFERENCES HotelReservation.Total(TotalID);
ALTER TABLE HotelReservation.ReservationGuest add constraint FOREIGN KEY (ReservationID) REFERENCES HotelReservation.ReservationInfo(ReservationID);
ALTER TABLE HotelReservation.ReservationGuest add constraint FOREIGN KEY (GuestID) REFERENCES HotelReservation.Guest(GuestID);
ALTER TABLE HotelReservation.Room add constraint FOREIGN KEY (RoomTypeID) REFERENCES HotelReservation.RoomType(RoomTypeID);
ALTER TABLE HotelReservation.ReservationRoom add constraint FOREIGN KEY (ReservationID) REFERENCES HotelReservation.ReservationInfo(ReservationID);
ALTER TABLE HotelReservation.ReservationRoom add constraint FOREIGN KEY (RoomID) REFERENCES HotelReservation.Room(RoomID);
ALTER TABLE HotelReservation.RoomAddOn add constraint FOREIGN KEY (RoomID) REFERENCES HotelReservation.Room(RoomID);
ALTER TABLE HotelReservation.RoomAddOn add constraint FOREIGN KEY (AddOnID) REFERENCES HotelReservation.AddOn(AddOnID);
ALTER TABLE HotelReservation.AddOnDetails add constraint FOREIGN KEY (AddOnID) REFERENCES HotelReservation.AddOn(AddOnID);
ALTER TABLE HotelReservation.AddOnDetails add constraint FOREIGN KEY (DetailsID) REFERENCES HotelReservation.Details(DetailsID);
ALTER TABLE HotelReservation.Promos add constraint FOREIGN KEY(PromoTypeID) REFERENCES HotelReservation.PromoType(PromoTypeID);

INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (1, 'Greer', 'Devenport', '678-429-4765', 'gdevenport0@imdb.com', '1964-11-04');
INSERT INTO  HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (2, 'Rosa', 'Paumier', '508-999-9335', 'rpaumier1@cbslocal.com', '1982-11-04');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (3, 'Sybil', 'Shenfisch', '809-922-1396', 'sshenfisch2@hatena.ne.jp', '1982-10-30');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (4, 'Mechelle', 'Dublin', '869-211-4869', 'mdublin3@chronoengine.com', '1973-01-26');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (5, 'Earl', 'Debill', '401-481-1591', 'edebill4@tinyurl.com', '1968-06-29');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (6, 'Lurlene', 'Lempke', '599-922-3874', 'llempke5@aol.com', '1972-06-02');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (7, 'Perrine', 'Stelljes', '172-999-2213', 'pstelljes6@reuters.com', '1967-06-15');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (8, 'Astrid', 'Greenshiels', '368-835-1717', 'agreenshiels7@ycombinator.com', '1970-07-11');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (9, 'Lucian', 'Coudray', '923-554-6468', 'lcoudray8@nps.gov', '1983-10-15');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (10, 'Dore', 'Remon', '625-502-6231', 'dremon9@nbcnews.com', '1980-04-18');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (11, 'Kin', 'Hallin', '111-446-7004', 'khallina@skype.com', '1961-02-24');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (12, 'Richmound', 'Moorcroft', '742-688-5442', 'rmoorcroftb@bravesites.com', '1976-01-10');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (13, 'Sasha', 'Matanin', '669-141-8528', 'smataninc@godaddy.com', '1980-08-02');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (14, 'Moore', 'Parmby', '971-912-1660', 'mparmbyd@newsvine.com', '1974-10-19');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (15, 'Cynde', 'Vidler', '834-381-0339', 'cvidlere@hugedomains.com', '1991-04-14');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (16, 'Fidelio', 'Alliott', '845-468-4061', 'falliottf@domainmarket.com', '1976-01-19');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (17, 'Coretta', 'Klemmt', '778-580-3110', 'cklemmtg@digg.com', '1970-09-27');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (18, 'Filbert', 'Doidge', '643-957-3612', 'fdoidgeh@geocities.jp', '1977-09-27');
INSERT INTO HotelReservation.Customer (CustomerID, FirstName, LastName, Phone, Email, BirthDate) VALUES (19, 'Elfreda', 'Saladin', '304-229-8200', 'esaladini@elegantthemes.com', '1965-06-07');

INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (1, 'Bobinette', 'Milhench');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (2, 'Fairleigh', 'Kaveney');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (3, 'Sanson', 'Allchin');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (4, 'Clemmy', 'Avieson');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (5, 'Morty', 'Custy');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (6, 'Noe', 'Acory');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (7, 'Skye', 'Antonioni');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (8, 'Ingmar', 'Bottby');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (9, 'Hobard', 'Mesnard');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (10, 'Troy', 'O''Glessane');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (11, 'Allissa', 'Farlowe');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (12, 'Grenville', 'Thomerson');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (13, 'Gipsy', 'Worrall');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (14, 'Kirk', 'McCrudden');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (15, 'Kirby', 'Moryson');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (16, 'Fergus', 'Pennington');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (17, 'Morley', 'Fallows');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (18, 'Brant', 'Verillo');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (19, 'Sandy', 'Blaschke');
INSERT INTO HotelReservation.Guest (GuestID, FirstName, LastName) VALUES (20, 'Colet', 'Duckers');

INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (1, 'Queen Size Bed', 20.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (2, 'King Size Bed', 30.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (3, 'Jacuzzi Bathtub', 25.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (4, 'Beer', 5.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (5, 'Bottle of Champagne', 30.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (6, 'Movie Channels', 10.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (7, 'Parking Garage Access', 30.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (8, 'Continental Breakfast', 10.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (9, 'Gym Access', 10.00);
INSERT INTO HotelReservation.AddOn (AddOnID, ItemAdded, Price) VALUES (10, 'Valet Parking', 20.00);

INSERT INTO HotelReservation.RoomType (RoomTypeID, BedSize, Occupancy) VALUES (1, 'Full', 2);
INSERT INTO HotelReservation.RoomType (RoomTypeID, BedSize, Occupancy) VALUES (2, 'Full', 2);
INSERT INTO HotelReservation.RoomType (RoomTypeID, BedSize, Occupancy) VALUES (3, 'Queen', 3);
INSERT INTO HotelReservation.RoomType (RoomTypeID, BedSize, Occupancy) VALUES (4, 'Queen', 3);
INSERT INTO HotelReservation.RoomType (RoomTypeID, BedSize, Occupancy) VALUES (5, 'King', 4);
INSERT INTO HotelReservation.RoomType (RoomTypeID, BedSize, Occupancy) VALUES (6, 'King', 4);

INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (1, 1, 1, 1);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (2, 1, 1, 2);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (3, 1, 1, 3);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (4, 1, 1, 4);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (5, 2, 1, 5);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (6, 2, 2, 1);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (7, 2, 2, 2);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (8, 2, 2, 3);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (9, 3, 2, 4);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (10, 3, 2, 5);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (11, 3, 3, 1);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (12, 3, 3, 2);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (13, 4, 3, 3);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (14, 4, 3, 4);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (15, 4, 3, 5);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (16, 4, 4, 1);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (17, 5, 4, 2);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (18, 5, 4, 3);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (19, 5, 4, 4);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (20, 5, 4, 5);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (21, 6, 5, 1);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (22, 6, 5, 2);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (23, 6, 5, 3);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (24, 6, 5, 4);
INSERT INTO HotelReservation.Room (RoomID, RoomTypeID, Floor, `Number`) VALUES (25, 6, 5, 5);

INSERT INTO HotelReservation.PromoType (PromoTypeID, `Type`, `Value`) VALUES (1, 'Flat-Rate', '$50 Off');
INSERT INTO HotelReservation.PromoType (PromoTypeID, `Type`, `Value`) VALUES (2, 'Percentage', '10% Off');
INSERT INTO HotelReservation.PromoType (PromoTypeID, `Type`, `Value`) VALUES (3, 'Free Item', 'Free Champagne');

INSERT INTO HotelReservation.Promos (PromoID, PromoTypeID, StartDate, EndDate) VALUES (1, 1, '2014-01-01', '2014-12-31');
INSERT INTO HotelReservation.Promos (PromoID, PromoTypeID, StartDate, EndDate) VALUES (2, 1, '2015-01-01', '2015-12-31');
INSERT INTO HotelReservation.Promos (PromoID, PromoTypeID, StartDate, EndDate) VALUES (3, 2, '2016-01-01', '2017-12-31');
INSERT INTO HotelReservation.Promos (PromoID, PromoTypeID, StartDate, EndDate) VALUES (4, 2, '2017-01-01', '2017-12-31');
INSERT INTO HotelReservation.Promos (PromoID, PromoTypeID, StartDate, EndDate) VALUES (5, 3, '2018-01-01', '2018-12-31');

INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(1, 6.00, 164.30, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(2, 6.00, 106.00, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(3, 6.00, 159.00, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(4, 6.00, 190.80, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(5, 6.00, 230.90, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(6, 6.00, 90.10, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(7, 6.00, 56.00, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(8, 6.00, 63.60, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(9, 6.00, 24.20, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(10, 6.00, 87.80, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(11, 6.00, 95.40, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(12, 6.00, 95.40, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(13, 6.00, 74.20, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(14, 6.00, 111.30, NULL);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(15, 6.00, 151.58, 00.10);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(16, 6.00, 93.28, 00.10);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(17, 6.00, 116.60, 00.10);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(18, 6.00, 116.60, 00.10);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(19, 6.00, 151.58, 00.10);
INSERT INTO HotelReservation.Total (TotalID, Tax, Total, RateChanges) VALUES(20, 6.00, 116.60, 00.10);

INSERT INTO HotelReservation.Details (DetailsID) VALUES(1);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(2);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(3);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(4);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(5);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(6);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(7);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(8);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(9);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(10);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(11);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(12);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(13);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(14);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(15);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(16);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(17);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(18);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(19);
INSERT INTO HotelReservation.Details (DetailsID) VALUES(20);

INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (2, 1);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (3, 1);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (7, 3);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (10, 3);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (1, 4);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (6, 4);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (2, 6);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (4, 6);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (9, 8);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (1, 9);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (2, 10);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (2, 11);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (8, 11);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (1, 13);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (2, 14);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (3, 14);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (1, 15);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (9, 15);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (5, 16);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (2, 16);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (5, 18);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (2, 19);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (5, 19);
INSERT INTO HotelReservation.AddOnDetails (AddOnID, DetailsID) VALUES (5, 20);

INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(1, NULL, 1, 1, 1, '2010-12-08', '2010-12-10');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(2, NULL, 2, 2, 2, '2011-07-12', '2011-07-14');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(3, NULL, 3, 3, 3, '2011-07-12', '2012-07-14');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(4, NULL, 4, 4, 4, '2014-12-05', '2014-12-08');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(5, 1, 5, 5, 5, '2014-12-26', '2014-12-31');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(6, NULL, 6, 6, 6, '2015-05-28', '2015-05-29');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(7, 1, 7, 7, 7, '2015-07-10', '2015-07-12');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(8, NULL, 8, 8, 8, '2015-08-07', '2015-08-08');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(9, 1, 9, 9, 9, '2015-11-10', '2015-11-11');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(10, 1, 10, 10, 10, '2015-12-21', '2015-12-23');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(11, NULL, 11, 11, 11, '2016-03-07', '2016-03-08');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(12, 2, 12, 12, 12, '2016-08-25', '2016-08-27');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(13, NULL, 13, 13, 13, '2016-09-30', '2016-10-01');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(14, NULL, 14, 14, 14, '2016-12-07', '2016-12-08');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(15, 2, 15, 15, 15, '2017-07-05', '2017-07-07');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(16, 3, 16, 16, 16, '2018-02-19', '2018-02-20');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(17, NULL, 17, 17, 17, '2018-05-06', '2018-05-08');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(18, 3, 18, 18, 18, '2018-07-26', '2018-07-28');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(19, 3, 18, 19, 19, '2018-09-05', '2018-09-07');
INSERT INTO HotelReservation.ReservationInfo (ReservationID, PromoID, CustomerID, DetailsID, TotalID, StartDate, EndDate) VALUES(20, 3, 19, 20, 20, '2018-10-08', '2018-10-10');

INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (1, 1);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (1, 2);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (2, 3);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (2, 4);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (3, 5);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (4, 6);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (5, 7);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (7, 8);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (7, 9);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (9, 10);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (9, 11);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (10, 12);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (12, 13);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (12, 14);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (14, 15);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (16, 16);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (18, 17);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (18, 18);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (18, 19);
INSERT INTO HotelReservation.ReservationGuest (ReservationID, GuestID) VALUES (20, 20);

INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (1, 17);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (2, 1);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (3, 3);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (4, 10);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (5, 2);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (6, 25);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (7, 4);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (8, 5);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (9, 9);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (10, 18);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (11, 19);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (12, 6);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (13, 11);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (14, 12);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (15, 13);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (16, 20);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (17, 6);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (18, 7);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (19, 24);
INSERT INTO HotelReservation.ReservationRoom (ReservationID, RoomID) VALUES (20, 8);


