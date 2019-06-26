CREATE DATABASE comics;

CREATE TABLE leitor (
email varchar(50) NOT NULL,
nome varchar(50) NOT NULL,
votou boolean NOT NULL,
PRIMARY KEY (email)
);

CREATE TABLE editora (
id int(10) unsigned NOT NULL AUTO_INCREMENT,
nome varchar(50) NOT NULL,
votos int NOT NULL DEFAULT 0,
PRIMARY KEY (id)
);

CREATE TABLE comic (
id int(10) unsigned NOT NULL AUTO_INCREMENT,
nome varchar(50) NOT NULL,
votos int NOT NULL DEFAULT 0,
idEditora int(10) unsigned NOT NULL,
PRIMARY KEY (id),
KEY fk_editora (idEditora),
CONSTRAINT fk_editora FOREIGN KEY (idEditora) REFERENCES editora (id)
);

INSERT INTO editora(nome, votos) VALUES ("DC", 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Batman", 1, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Superman", 1, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Flash", 1, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Laterna verde", 1, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Robin/Asa Noturna", 1, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Arqueiro Verde", 1, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Mulher Maravilha", 1, 0);

INSERT INTO editora(nome, votos) VALUES ("Marvel", 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Homem-Aranha", 2, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Capitão América", 2, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Dr. Destino", 2, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Hulk", 2, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Wolverine", 2, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Thor", 2, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Homem de Ferro", 2, 0);

INSERT INTO editora(nome, votos) VALUES ("Image", 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Marko Grayson (Invencible)", 3, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Morning Glories", 3, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Hack/Slash", 3, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Sex Criminals", 3, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Lazarus", 3, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Saga", 3, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Spawn", 3, 0);

INSERT INTO editora(nome, votos) VALUES ("OUTRA", 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Hellboy - Dark Horse", 4, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Flash Gordon - King Features Syndicate", 4, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Fantasma - King Features Syndicate", 4, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Homem-Borracha - Quality Comics", 4, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Shazam (Capitão Marvel)", 4, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Spirit - Eisner-Iger Studio", 4, 0);
INSERT INTO comic (nome, idEditora, votos) VALUES ("Besouro Verde - Helnit Comics", 4, 0);
