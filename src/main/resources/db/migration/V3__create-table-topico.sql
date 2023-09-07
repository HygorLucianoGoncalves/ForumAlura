CREATE TABLE topico (
                        id SERIAL PRIMARY KEY,
                        titulo VARCHAR(255) UNIQUE NOT NULL,
                        mensagem TEXT UNIQUE NOT NULL,
                        data_criacao TIMESTAMP NOT NULL,
                        status VARCHAR(20) NOT NULL,
                        autor_id INT,
                        curso_id INT,
                        FOREIGN KEY (autor_id) REFERENCES usuario (id),
                        FOREIGN KEY (curso_id) REFERENCES curso (id)
);
