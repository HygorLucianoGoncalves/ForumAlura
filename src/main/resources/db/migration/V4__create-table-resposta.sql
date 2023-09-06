CREATE TABLE resposta (
      id SERIAL PRIMARY KEY,
      mensagem TEXT NOT NULL,
      data_criacao TIMESTAMP NOT NULL,
      topico_id INT,
      autor_id INT,
      solucao BOOLEAN NOT NULL,
      FOREIGN KEY (topico_id) REFERENCES topico (id),
      FOREIGN KEY (autor_id) REFERENCES usuario (id)
);
