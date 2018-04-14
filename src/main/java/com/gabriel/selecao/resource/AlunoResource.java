package com.gabriel.selecao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.selecao.model.Aluno;
import com.gabriel.selecao.repository.AlunoRepository;
import com.gabriel.selecao.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@CrossOrigin
	@GetMapping
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Aluno> criar(@Valid @RequestBody Aluno aluno, HttpServletResponse response) {
		Aluno alunoSalvo = alunoService.salvar(aluno);		
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
	}
	
	@CrossOrigin
	@GetMapping("/pesquisar")
	public List<Aluno> pesquisar(String nomeAluno){
		if(nomeAluno == null || nomeAluno.equals("")) {
			return listar();
		}else {
			return alunoRepository.findByNomeAlunoContaining(nomeAluno);
		}
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Aluno buscarPorId(@PathVariable Long id) {
		return alunoRepository.findOne(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		alunoRepository.delete(id);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @Valid @RequestBody Aluno aluno){
		Aluno alunoSalvo = alunoService.atualizar(id, aluno);
		return ResponseEntity.ok(alunoSalvo);
	}	
	
}
