CREATE TABLE usuario (
     id SERIAL PRIMARY KEY,
     nome TEXT UNIQUE NOT NULL,
     email TEXT UNIQUE NOT NULL ,
     senha TEXT NOT NULL
);
