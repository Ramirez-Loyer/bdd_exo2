--1.1 Générer votre base de donées à l'aide du script Shop.sql

DROP DATABASE IF EXISTS Shop; 
CREATE DATABASE Shop;
USE Shop;


-----Construction de la base de données--------

CREATE TABLE T_Articles (
	IdArticle		int(4)		PRIMARY KEY AUTO_INCREMENT,
	Description		varchar(30)	NOT NULL,
	Brand			varchar (30) NOT NULL, 
	UnitaryPrice	float(8) 		NOT NULL
) ENGINE = InnoDB;

	
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Souris", "Logitoch", 65);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Clavier", "Microhard", 49.5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Système d'exploitation", "Fenetres Vistouille", 150);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Tapis souris", "Chapeau Bleu", 5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Clé USB 8 To", "Syno", 8);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Laptop", "PH", 1199);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("CD x 500", "CETME", 250);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("DVD-R x 100", "CETME", 99);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("DVD+R x 100", "CETME", 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Batterie Laptop", "PH", 80);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Casque Audio", "Syno", 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("WebCam", "Logitech", 755);


SELECT * FROM T_Articles;
-- 1.2 Effectuer les requêtes permettant d'afficher toutes les tables en base
show tables; 

-- 1.3 Trouver un moyen pour décrire une table
DESCRIBE T_Articles;

-- 1.4 Ajouter à la table des articles des ocurrences de votre choix
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Clavier USB", "Logitech", 27.99);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Cable HDMI", "Snowkids", 12);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Apple Watch Series 9", "Appli", 399);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Apple AirPods Pro", "Apple", 239);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Caméra Surveillance WiFi", "Imou", 20.89);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Cable", "Apple", 26.50);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("IPhone 14", "Apple", 969.80);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ("Mac Book Air", "Apple", 1599.80);

-- 1.5 Modifier un article avant de vérifier si c'est pris en compte

UPDATE Articles SET Brand= "Logitech", UnitaryPrice= 85 WHERE IdArticle=1;
UPDATE T_Articles SET Brand= "Apple", UnitaryPrice= 399.99 WHERE IdArticle=15;


SELECT * FROM t_articles;

-- 1.6 Suprimer un article puis vérifier

DELETE FROM T_Articles WHERE IdArticle = 2; 

-- 1.7 Sélectionner tous les articles dont le prix est supérieur à 100

SELECT * FROM T_Articles WHERE UnitaryPrice >= 100;

-- 1.8 Sélectionner les articles dont le prix est compris entre 50 et 150

SELECT * FROM T_Articles WHERE UnitaryPrice BETWEEN 50 AND 150; 

-- 1.9 Afficher les articles dans l'orde croissant des prix

SELECT * FROM T_Articles WHERE UnitaryPrice ORDER BY UnitaryPrice; 

-- 1.10 Afficher uniquement la description des articles

SELECT Description FROM T_Articles;

-- 1.11 Choissez une requête particulièrement intéressante à présenter

SELECT Description FROM T_Articles WHERE Brand = "Apple" ORDER BY UnitaryPrice;   


-- 1.12 Ajouter la table des catégories à votre base de données et insérez-en

CREATE TABLE T_Categories (
	IdCategory 		INT (4) 	PRIMARY KEY AUTO_INCREMENT,
	CatName 		VARCHAR(30) NOT NULL, 
	Description 	VARCHAR (100) NOT NULL
); 
	
show tables;	

ALTER TABLE T_Articles ADD COLUMN IdCategory INT(4);
ALTER TABLE T_Articles ADD FOREIGN KEY (IdCategory) REFERENCES T_Categories(IdCategory)(4);

INSERT INTO T_Categories(CatName, description) VALUES ("PC","ordinater portable ou pc");
INSERT INTO T_Categories(CatName, description) VALUES ("téléphone","portable");
INSERT INTO T_Categories(CatName, description) VALUES ("cables","electrique");
INSERT INTO T_Categories(CatName, description) VALUES ("périphérique","informatique");
INSERT INTO T_Categories(CatName, description) VALUES ("accessoire","personnel");
INSERT INTO T_Categories(CatName, description) VALUES ("logiciel","informatique");


SELECT * FROM T_Categories;

UPDATE T_Articles set IdCategory=5 where IdArticle=1;
UPDATE T_Articles set IdCategory=5 where IdArticle=2;
UPDATE T_Articles set IdCategory=6 where IdArticle=3;
UPDATE T_Articles set IdCategory=5 where IdArticle=4;
UPDATE T_Articles set IdCategory=4 where IdArticle=5;
UPDATE T_Articles set IdCategory=1 where IdArticle=6;
UPDATE T_Articles set IdCategory=5 where IdArticle=7;
UPDATE T_Articles set IdCategory=4 where IdArticle=8;
UPDATE T_Articles set IdCategory=4 where IdArticle=9;
UPDATE T_Articles set IdCategory=5 where IdArticle=10;
UPDATE T_Articles set IdCategory=5 where IdArticle=11;
UPDATE T_Articles set IdCategory=4 where IdArticle=12;
UPDATE T_Articles set IdCategory=4 where IdArticle=13;
UPDATE T_Articles set IdCategory=3 where IdArticle=14;
UPDATE T_Articles set IdCategory=5 where IdArticle=15;
UPDATE T_Articles set IdCategory=5 where IdArticle=16;
UPDATE T_Articles set IdCategory=4 where IdArticle=17;
UPDATE T_Articles set IdCategory=3 where IdArticle=18;
UPDATE T_Articles set IdCategory=2 where IdArticle=19;
UPDATE T_Articles set IdCategory=1 where IdArticle=20;




SELECT * FROM T_Categories;
	
-- 1.13

SELECT * FROM T_Articles WHERE IdArticle BETWEEN 11 AND 16 ORDER BY UnitaryPrice ASC;

	


