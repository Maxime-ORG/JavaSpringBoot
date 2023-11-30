CREATE TABLE personnage (
    id            INT PRIMARY KEY,
    nom           VARCHAR(45),
    points_de_vie INT,
    types         VARCHAR(45)
);

INSERT INTO personnage VALUES(1, 'Ordinateur portable' , 350, 'Guerrier');
INSERT INTO personnage VALUES(2, 'Aspirateur Robot' , 500, 'Magicien');
INSERT INTO personnage VALUES(3, 'Table de Ping Pong' , 750, 'Magicien');