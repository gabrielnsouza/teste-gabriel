package com.gabriel.selecao.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.selecao.model.Aluno;
import com.gabriel.selecao.model.Curso;
import com.gabriel.selecao.repository.AlunoRepository;
import com.gabriel.selecao.repository.CursoRepository;
import com.gabriel.selecao.service.exception.CursoInexistenteException;

@Service
public class AlunoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno salvar(Aluno aluno) {
		Curso curso = cursoRepository.findById(aluno.getCurso().getId());
		if(curso == null) {
			throw new CursoInexistenteException();
		}
		aluno.setCurso(curso);
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizar(Long id, Aluno aluno) {
		Aluno alunoSalvo = alunoRepository.findOne(id);
		Curso curso = cursoRepository.findById(aluno.getCurso().getId());
		if(curso != null) {
			aluno.setCurso(curso);
		}
		
		BeanUtils.copyProperties(aluno, alunoSalvo, "codigo");
		return alunoRepository.save(alunoSalvo);	
	}	

}
