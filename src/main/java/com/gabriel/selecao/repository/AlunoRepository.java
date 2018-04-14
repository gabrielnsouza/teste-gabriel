package com.gabriel.selecao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.selecao.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	List<Aluno> findByNomeAlunoContaining(String nomeAluno);

}
