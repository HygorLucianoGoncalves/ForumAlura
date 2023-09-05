CREATE TABLE usuario (
     id SERIAL PRIMARY KEY,
     nome TEXT NOT NULL,
     email TEXT UNIQUE NOT NULL ,
     senha TEXT NOT NULL
);
