package com.br.generation.LojaGame.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.br.generation.LojaGame.model.CategoriaModel;
import com.br.generation.LojaGame.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin (origins = "*", allowedHeaders ="*")
public class CategoriaController {

	@Autowired
	public CategoriaRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel>GetById(Long id){
		
		return repository.findById(id).map(resp ->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{categoria}")
	public ResponseEntity<List<CategoriaModel>> getBycategoria(@PathVariable String categoria){
		
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(categoria));
	}
	@PostMapping
	public ResponseEntity <CategoriaModel> post (@RequestBody CategoriaModel Categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Categoria));
	}

	@PutMapping
	public ResponseEntity<CategoriaModel> put(@RequestBody CategoriaModel Categoria){

		return ResponseEntity.ok(repository.save(Categoria));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

		repository.deleteById(id);
	}



}
