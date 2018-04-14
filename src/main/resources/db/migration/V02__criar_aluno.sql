CREATE TABLE aluno(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome_aluno VARCHAR(50) NOT NULL,
	numero_matricula integer,
	semestre integer NOT NULL,
	status VARCHAR(20),
	curso_id BIGINT(20),
	FOREIGN KEY (curso_id) REFERENCES curso(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


