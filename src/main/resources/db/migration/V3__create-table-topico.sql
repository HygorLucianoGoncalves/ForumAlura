CREATE TABLE topico (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(255),
                        mensagem TEXT,
                        data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        status VARCHAR(255) DEFAULT 'NAO_RESPONDIDO',
                        autor_id INT,
                        curso_id INT,
                        FOREIGN KEY (autor_id) REFERENCES usuario(id),
                        FOREIGN KEY (curso_id) REFERENCES curso(id)
);
