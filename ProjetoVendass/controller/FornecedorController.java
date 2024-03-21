package com.example.ProjetoVendass.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoVendass.entities.Fornecedor;
import com.example.ProjetoVendass.service.FornecedorService;

import jakarta.validation.Valid; 

  

@RestController 

@RequestMapping("/fornecedor") 

public class FornecedorController { 

	private final FornecedorService fornecedorService;   

  

	@Autowired   

	public FornecedorController(FornecedorService fornecedorService) {   

	this.fornecedorService = fornecedorService;   

	}   

  

	@PostMapping("/")   

	public ResponseEntity<Fornecedor> createFornecedor(@RequestBody @Valid Fornecedor fornecedor) {   

		Fornecedor salvaFornecedor = fornecedorService.salvaFornecedor(fornecedor);   

	return ResponseEntity.status(HttpStatus.CREATED).body(salvaFornecedor);   

	}   

  

	@PutMapping("/{id}")    

	public ResponseEntity<Fornecedor> alteraFornecedorControl(@PathVariable Long id, @RequestBody @Valid Fornecedor fornecedor){   

		Fornecedor alteraFornecedor = fornecedorService.alteraFornecedor(id, fornecedor);   

		if (alteraFornecedor != null) {  

			return ResponseEntity.ok(fornecedor);   

		}   

		else {   

			return ResponseEntity.notFound().build();   

		}   

	}   

  

	@GetMapping("/{id}")   

		public ResponseEntity<Fornecedor> buscaFornecedorControlId (@PathVariable Long id){   

			Fornecedor fornecedor = fornecedorService.buscaFornecedorById(id);   

			if(fornecedor != null) {   

				return ResponseEntity.ok(fornecedor);   

			}  

			else {   

				return ResponseEntity.notFound().build();   

			}  

		}   

  

	@GetMapping("/")    

	public ResponseEntity<List<Fornecedor>> buscaTodosFornecedorsControl(){   

		List<Fornecedor> fornecedor = fornecedorService.buscaTodosFornecedor();   

		return ResponseEntity.ok(fornecedor);   

	}   

  

	@DeleteMapping("/{id}")   

	public ResponseEntity<Fornecedor> apagarFornecedorControl(@PathVariable Long id){   

		boolean apagar = fornecedorService.apagarFornecedor(id);   

		if (apagar) {   

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();   

		}   

		else {   

			return ResponseEntity.notFound().build(); 	}   

  

	}  

  

} 