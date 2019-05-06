-- Model de l'aplicació d'agenda
DROP TABLE IF EXISTS MITJANS;
DROP TABLE IF EXISTS CONTACTES;

CREATE TABLE CONTACTES (
    id SERIAL PRIMARY KEY,
    nom TEXT UNIQUE,
    categoria TEXT
);

CREATE TABLE MITJANS (
    id SERIAL PRIMARY KEY,
    id_contacte INTEGER references CONTACTES,
    tipus TEXT,
    referencia TEXT,
    descripcio TEXT
);


-- Algunes entrades de prova
INSERT INTO CONTACTES VALUES (1, 'Agnes Li González', 'família');
INSERT INTO CONTACTES VALUES (2, 'Ramir Rezos Buendía', null);

INSERT INTO MITJANS VALUES (DEFAULT, 1, 'email', 'agnesligonza2003@gmail.com', null);
INSERT INTO MITJANS VALUES (DEFAULT, 1, 'telefon', '663832345', null);
INSERT INTO MITJANS VALUES (DEFAULT, 1, 'telefon', '681289345', 'mare');
INSERT INTO MITJANS VALUES (DEFAULT, 1, 'telefon', '932234512', 'feina');
INSERT INTO MITJANS VALUES (DEFAULT, 1, 'twitter', '@agneslaguay', null);
INSERT INTO MITJANS VALUES (DEFAULT, 2, 'email', 'rezosbuendia@aibiem.com', 'feina');
INSERT INTO MITJANS VALUES (DEFAULT, 2, 'email', 'ramirbuendia@jotmeil.com', null);
INSERT INTO MITJANS VALUES (DEFAULT, 2, 'telefon', '913452341', null);
INSERT INTO MITJANS VALUES (DEFAULT, 2, 'fax', '913452342', null);

