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

import com.gabriel.selecao.model.Curso;
import com.gabriel.selecao.repository.CursoRepository;
import com.gabriel.selecao.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoResource {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private CursoService cursoService;

	@CrossOrigin
	@GetMapping
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/pesquisar")
	public List<Curso> pesquisar(String nomeCurso){
		if(nomeCurso == null || nomeCurso.equals("")) {
			return listar();
		}else {
			return cursoRepository.findByNomeCursoContaining(nomeCurso);
		}
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Curso> criar(@Valid @RequestBody Curso curso, HttpServletResponse response) {
		Curso cursoSalvo = cursoService.salvar(curso);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Curso buscarPorId(@PathVariable Long id) {
		return cursoRepository.findOne(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		cursoRepository.delete(id);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Curso> atualizar(@PathVariable Long id, @Valid @RequestBody Curso curso){
		Curso cursoSalvo = cursoService.atualizar(id, curso);
		return ResponseEntity.ok(cursoSalvo);
	}	
	
}
