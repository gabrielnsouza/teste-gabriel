package com.gabriel.selecao.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.selecao.enun.StatusCurso;

@RestController
@RequestMapping("/status")
public class StatusCursoResource {

	@CrossOrigin
	@GetMapping
	public StatusCurso[] listar(){
		StatusCurso[] status = StatusCurso.values();
		return status;
	}
	
}
