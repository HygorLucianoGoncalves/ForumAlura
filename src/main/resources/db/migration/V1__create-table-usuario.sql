CREATE TABLE usuario (
     id UUID PRIMARY KEY,
     nome TEXT NOT NULL,
     email TEXT UNIQUE NOT NULL ,
     senha TEXT NOT NULL
);
