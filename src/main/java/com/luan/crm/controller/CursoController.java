package com.luan.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luan.crm.model.Curso;
import com.luan.crm.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<Curso> listarAllCursos() {
		return cursoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Curso adicionarCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@GetMapping(value = "/{id}")
	public Curso buscarCurso(@PathVariable int id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		if(curso.isPresent()) {
			return curso.get();
		}else {
			throw new RuntimeException("Curso não encontrado para o id: "+id);
		} 
	}
	
	@PutMapping
	public Curso atualizarCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@DeleteMapping(value = "/{id}")
	public String apagarCurso(@PathVariable int id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		if(curso.isPresent()) {
			cursoRepository.delete(curso.get());
			return "Curso excluido com id: "+id;
		}else {
			throw new RuntimeException("Curso não encontrado para o id: "+id);
		}
		
	}
	
}
