package com.gabriel.selecao.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.selecao.model.Curso;
import com.gabriel.selecao.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso atualizar(Long id, Curso curso) {
		Curso cursoSalvo = cursoRepository.findOne(id);
		
		BeanUtils.copyProperties(curso, cursoSalvo, "codigo");
		return cursoRepository.save(cursoSalvo);	
	}
	
	public Curso salvar(Curso curso) {
		// TODO Auto-generated method stub
		return cursoRepository.save(curso);
	}

}
