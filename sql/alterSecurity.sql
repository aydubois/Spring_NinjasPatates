ALTER TABLE Person
    drop column Name,
    add column `username` varchar(45) NOT NULL,
    add column `password` varchar(64) NOT NULL,
    add column `role` varchar(45) NOT NULL,
    add column `enabled` tinyint(1) DEFAULT NULL;