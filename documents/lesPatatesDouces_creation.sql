drop database if exists `chouillePlanner`;

create database if not exists `chouillePlanner`;

use chouillePlanner;

create table if not exists `Person` (
	`Id_Person` int unsigned auto_increment,
	`Name` varchar(25) not null,
	primary key (`Id_Person`)
);

create table if not exists `Location` (
	`Id_Location` int unsigned auto_increment,
	`Adress` varchar(255) not null,
	`Max_Pers` int unsigned,
	`Id_Person_Host` int unsigned,
	primary key (`Id_Location`),
	foreign key (`Id_Person_Host`)
		references Person(`Id_Person`)
);

create table if not exists `Chouille` (
	`Id_Chouille` int unsigned auto_increment,
	`Thematic` varchar(50),
	`Date` timestamp not null,
	`Id_Location` int unsigned,
	`Id_Person_Sam` int unsigned,
	`Id_Person_Bouncer` int unsigned,
	`code` varchar(25) not null,
	primary key (`Id_Chouille`),
	foreign key (`Id_Location`)
		references Location(`Id_Location`),
	foreign key (`Id_Person_Sam`)
		references Person(`Id_Person`),
	foreign key (`Id_Person_Bouncer`)
		references Person(`Id_Person`),
    constraint unique chouille_code (code)   
);

create table if not exists `Persons_Chouilles` (
	`Id_Person` int unsigned,
	`Id_Chouille` int unsigned,
	primary key (`Id_Person`, `Id_Chouille`),
	foreign key (`Id_Person`)
		references Person(`Id_Person`), 
	foreign key (`Id_Chouille`)
		references Chouille(`Id_Chouille`)
);

create table if not exists `Item` (
	`Id_Item` int unsigned auto_increment,
	`type` varchar(50) not null,
	`Quantity` int unsigned not null,
	`Measure` decimal(10,2) unsigned,
	`Unit` enum ('G', 'L'),
	`Percentage_Consumed` int unsigned,
	`Id_Person` int unsigned,
	`Id_Chouille` int unsigned,
	primary key (`Id_Item`),
	foreign key (`Id_Person`)
		references Person(`Id_Person`),
	foreign key (`Id_Chouille`)
		references Chouille(`Id_Chouille`)
);