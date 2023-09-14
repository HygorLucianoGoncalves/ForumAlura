CREATE TABLE usuario (
     id SERIAL PRIMARY KEY NOT NULL ,
     nome TEXT UNIQUE NOT NULL,
     email TEXT UNIQUE NOT NULL ,
     senha TEXT NOT NULL,
     role TEXT NOT NULL
);
