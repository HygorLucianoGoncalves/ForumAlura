CREATE TABLE resposta (
      id SERIAL PRIMARY KEY,
      mensagem TEXT NOT NULL,
      topico_id INTEGER REFERENCES topico(id),
      data_criacao TIMESTAMP NOT NULL,
      autor_id INTEGER REFERENCES usuario(id),
      solucao BOOLEAN
);
