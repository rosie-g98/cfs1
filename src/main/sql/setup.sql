-- drop tutte le tabelle
drop table if exists user;
drop table if exists musica;
drop table if exists genere;
drop table if exists film;
drop table if exists categoria;
drop table if exists mood;

-- CREAZIONE TABELLA MOOD
create table mood(
	mood_id integer primary key auto_increment,
	nome varchar(20) not null
);

-- INSERIMENTO IN MOOD
insert into mood (nome) values
    ('triste'),('felice'),('innamorato'),
    ('attivo'), ('coraggioso'), ('rilassato'), 
    ('creativo');

 
-- CREAZIONE TABELLA USER
create table user(
	user_id integer primary key auto_increment,
	email varchar(40) not null,
	password varchar(20) not null,
    mood_id integer,
	FOREIGN KEY (mood_id) REFERENCES mood(mood_id),
    UNIQUE(email)
);

-- INSERIMENTO IN USER
insert into user (email, password) values
    ('antonellacastria1@gmail.com', 'password'),
    ('rosyguarnaccia.rm@gmail.com', 'password'),
    ('turanovaleria16@gmail.com', 'password'),
    ('caulafede@gmail.com', 'password');


-- Tabella genere
CREATE TABLE genere (
    genere_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL
);

-- INSERIMENTO IN GENERE
INSERT INTO genere (name) VALUES ('Pop'), ('Indie'), ('Rock'), 
('Rap'), ('Raggaeton'), ('Elettronica');
 

-- Tabella musica
CREATE TABLE musica (
    musica_id INT AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    cantante VARCHAR(100) NOT NULL,
    genere_id INT NOT NULL,
    lingua VARCHAR(3) NOT NULL,
    mood_id INT NOT NULL,
    FOREIGN KEY (genere_id) REFERENCES genere(genere_id),
    FOREIGN KEY (mood_id) REFERENCES mood(mood_id)
);

-- INSERIMENTO CANZONI
INSERT INTO musica ( titolo, cantante, genere_id, lingua, mood_id) values
("Non sei Tu", "Gazzelle", 2, "ITA", 1), 
("Pesto", "Calcutta", 2, "ITA", 1),
("Il posto più freddo", "I Cani", 2, "ITA", 1),
("Medicine","Daughter", 2, "ENG", 1),
("Exile","Taylor Swift ft. Bon Iver", 2, "ENG", 1),
("Another Love", "Tom Odell", 2,"ENG",1),
("Let Me Down", "Slowly Alec Benjamin", 1, "ENG", 1),
("Dance The Night", "Dua Lipa", 1, "ENG", 2),
("SESSO E SAMBA","Tony Effe ft. Gaia",1,"ITA", 4),
("Paprika","Ghali", 1, "ITA", 2),
("Balliamo sul mondo", "Ligabue", 3, "ITA", 4),
("Gioia Infinita","Negrita",3, "ITA", 2),
("Faccio un casino", "Coez", 2, "ITA", 3),
("Happy Together", "The Turtles", 2, "ENG", 3),
("Viva la vida", "Coldplay", 3, "ENG", 7),
("Nel blu dipinto di blu", "Domenico Modugno", 1, "ITA", 7),
("Innuendo", "Queen", 3, "ENG", 7),
("Vivere", "Vasco Rossi", 3, "ITA", 5),
("Unstoppable", "Sia", 1, "ENG", 5),
("Try", "Pink", 1, "ENG", 5),
("Don't stop me now", "Queen", 3, "ENG", 4),
("Strawberry Swing", "Coldplay", 3, "ENG", 6),
("La stagione dell’amore", "Franco Battiato", 1,"ITA",6 ); 


-- Tabella categoria
CREATE TABLE categoria (
    categoria_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(25) NOT NULL
);

-- INSERIMENTO IN CATEGORIA FILM
INSERT INTO categoria (nome) VALUES ('Commedia'), ('Thriller'), ('Romantico'), 
('Drammatico'), ('Azione'), ('Fantasy');
 

-- Tabella film
CREATE TABLE film (
    film_id INT AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    regista VARCHAR(100) NOT NULL,
    categoria_id INT NOT NULL,
    lingua VARCHAR(3) NOT NULL,
    anno DATE, 
    mood_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(categoria_id),
    FOREIGN KEY (mood_id) REFERENCES mood(mood_id)
);


-- INSERIMENTO IN FILM
INSERT INTO film (titolo, regista, categoria_id, lingua, anno, mood_id) VALUES 
('Tutti tranne te','Will Gluck', 1 ,'ENG','2023-12-22', 3),
('Shutter Island','Martin Scorsese',2, 'ENG','2010-01-01',5),
('Alice in Wonderland','Tim Burton', 6, 'ENG','2010-01-01',2),
('Harry Potter e il prigioniero di Azkaban','Alfonso Cuarón', 6, 'ENG','2004-06-04',5),
('Perfetti Sconosciuti','Paolo Genovese', 3, 'ENG','2016-01-01',3),
("La La Land", "Damien Chazelle", 3,"ENG","2016-01-01",2),
("The Grand Budapest Hotel", "Wes Anderson",3, "ENG", "2014-01-01",2),
("Mamma Mia!", "Phyllida Lloyd", 1,"ENG","2008-01-01", 2),
("Into the Wild", "Sean Penn", 4, "ENG","2007-01-01", 1),
("The Fast and the Furious: Tokyo Drift", "Justin Lin", 5, "ENG","2006-07-14", 4);

commit;
