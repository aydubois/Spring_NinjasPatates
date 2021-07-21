
LOCK TABLES `Chouille` WRITE;
/*!40000 ALTER TABLE `Chouille` DISABLE KEYS */;

INSERT INTO `Chouille` (`Id_Chouille`, `Thematic`, `Date`, `Id_Location`, `Id_Person_Sam`, `Id_Person_Bouncer`,`code`)
VALUES
	(1,'raclette','1997-04-10 00:00:00',4,2,12,'ABC123'),
	(2,'deguise','2021-08-15 00:00:00',8,12,10,'ABC124'),
	(3,'jeux societe','2000-04-10 00:00:00',9,5,1,'ABC125'),
	(4,'beuverie','2004-02-25 00:00:00',7,6,5,'ABC126'),
	(5,'raclette','2025-02-28 00:00:00',5,6,7,'ABC127'),
	(6,'apéro dinatoire','2001-01-01 00:00:00',4,2,1,'ABC128'),
	(7,'date','2011-11-11 00:00:00',2,4,8,'ABC129'),
	(8,'tartiflette','2000-05-15 00:00:00',10,6,2,'ABC130'),
	(9,'halloween','2017-12-22 00:00:00',11,11,11,'ABC131'),
	(10,'noel','2007-09-14 00:00:00',10,12,10,'ABC132'),
	(11,'paques','2012-12-11 00:00:00',5,5,3,'ABC133'),
	(12,'raclette','2015-01-18 00:00:00',4,2,12,'ABC134'),
	(13,'raclette','2020-07-06 00:00:00',1,4,8,'ABC135'),
	(14,'raclette','2020-12-09 00:00:00',8,12,2,'ABC136'),
	(15,'raclette','2021-10-28 00:00:00',12,2,4,'ABC137');

/*!40000 ALTER TABLE `Chouille` ENABLE KEYS */;
UNLOCK TABLES;





# Affichage de la table Location
# ------------------------------------------------------------

LOCK TABLES `Location` WRITE;
/*!40000 ALTER TABLE `Location` DISABLE KEYS */;

INSERT INTO `Location` (`Id_Location`, `Adress`, `Max_Pers`, `Id_Person_Host`)
VALUES
	(1,'Tours',12,2),
	(2,'Bordeaux',8,5),
	(3,'Nantes',6,4),
	(4,'Marseille',6,5),
	(5,'Lyon',15,8),
	(6,'Paris',4,11),
	(7,'Fondette',21,7),
	(8,'Rochecorbon',12,12),
	(9,'Joué-les-Tours',7,11),
	(10,'Chambray-les-Tours',7,9),
	(11,'Tours Nord',5,4),
	(12,'Tours Sud',4,8);

/*!40000 ALTER TABLE `Location` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table Person
# ------------------------------------------------------------

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;

INSERT INTO `Person` (`Id_Person`, `Name`)
VALUES
	(1,'Rémi'),
	(2,'Rémo'),
	(3,'PY'),
	(4,'PYL'),
	(5,'JY'),
	(6,'Audrey'),
	(7,'Cédric'),
	(8,'Cédrog'),
	(9,'Dorothée'),
	(10,'Ponyo'),
	(11,'Marley'),
	(12,'Mr. Mouche');

/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table Persons_Chouilles
# ------------------------------------------------------------

LOCK TABLES `Persons_Chouilles` WRITE;
/*!40000 ALTER TABLE `Persons_Chouilles` DISABLE KEYS */;

INSERT INTO `Persons_Chouilles` (`Id_Person`, `Id_Chouille`)
VALUES
	(1,1),
	(1,2),
	(1,4),
	(1,12),
	(2,2),
	(2,3),
	(2,5),
	(2,12),
	(3,2),
	(3,3),
	(3,12),
	(4,1),
	(4,3),
	(4,7),
	(4,12),
	(5,2),
	(5,8),
	(5,10),
	(5,12),
	(6,7),
	(7,3);

/*!40000 ALTER TABLE `Persons_Chouilles` ENABLE KEYS */;
UNLOCK TABLES;

# Affichage de la table Item
# ------------------------------------------------------------

LOCK TABLES `Item` WRITE;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;

INSERT INTO `Item` (`Id_Item`, `type`, `Quantity`, `Measure`, `Unit`, `Percentage_Consumed`, `Id_Person`, `Id_Chouille`)
VALUES
	(11,'Bière Leffe',12,0.33,'L',70,3,12),
	(12,'Rhum',1,0.70,'L',50,5,10),
	(13,'Vin cubi',1,4.00,'L',75,8,7),
	(14,'Bière',2,1.00,'L',100,5,8),
	(15,'Bière Grim',6,0.33,'L',100,2,10),
	(16,'Rhum ',1,2.00,'L',80,10,1),
	(17,'Vin',2,0.70,'L',100,2,5),
	(18,'bonbon',1,150.00,'G',100,6,7),
	(19,'chips',2,180.00,'G',50,1,1),
	(20,'gateau',2,80.00,'G',90,6,6),
	(21,'Bière Gallia',12,0.33,'L',70,3,12),
	(22,'Bière Leffe',2,0.25,'L',0,1,12),
	(23,'Bière Chouffe',12,0.33,'L',10,2,12),
	(24,'Bière Leffe',6,0.33,'L',20,4,12),
	(25,'Bière Grim',12,0.25,'L',70,3,2),
	(26,'Bière Leffe',12,0.33,'L',50,5,7),
	(27,'Bière 1664',9,0.33,'L',70,3,14),
	(28,'Bière Leffe',1,0.33,'L',40,2,2),
	(29,'Bière Blanche',10,0.25,'L',70,1,2),
	(30,'Bière Leffe',12,0.33,'L',90,4,3),
	(31,'Bière Kaarmeliet',1,1.00,'L',0,3,3),
	(32,'Bière Kaarmeliet',40,1.00,'L',10,2,13),
	(33,'Bière Leffe',1,0.33,'L',40,5,2);

/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
UNLOCK TABLES;
