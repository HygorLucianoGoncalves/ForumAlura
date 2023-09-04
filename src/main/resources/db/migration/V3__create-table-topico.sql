CREATE TABLE topico (
    id SERIAL PRIMARY KEY,
    titulo TEXT NOT NULL UNIQUE ,
    mensagem TEXT NOT NULL UNIQUE ,
    data_criacao TIMESTAMP NOT NULL,
    status TEXT NOT NULL,
    autor_id INTEGER REFERENCES usuario(id),
    curso_id INTEGER REFERENCES curso(id)
);
