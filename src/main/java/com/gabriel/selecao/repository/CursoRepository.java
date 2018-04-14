package com.gabriel.selecao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.selecao.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	List<Curso> findByNomeCursoContaining(String nomeCurso);

	Curso findById(Long id);

}
