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

import com.example.ProjetoVendass.entities.Produto;
import com.example.ProjetoVendass.service.ProdutoService;

import jakarta.validation.Valid; 

  

@RestController 

@RequestMapping("/produto") 

public class ProdutoController { 

	private final ProdutoService produtoService;   

  

	@Autowired   

	public ProdutoController(ProdutoService produtoService) {   

	this.produtoService = produtoService;   

	}   

  

	@PostMapping("/")   

	public ResponseEntity<Produto> createProduto(@RequestBody @Valid Produto produto) {   

		Produto salvaProduto = produtoService.salvaProduto(produto);   

	return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);   

	}   

  

	@PutMapping("/{id}")    

	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody @Valid Produto produto){   

		Produto alteraProduto = produtoService.alteraProduto(id, produto);   

		if (alteraProduto != null) {  

			return ResponseEntity.ok(produto);   

		}   

		else {   

			return ResponseEntity.notFound().build();   

		}   

	}   

  

	@GetMapping("/{id}")   

		public ResponseEntity<Produto> buscaProdutoControlId (@PathVariable Long id){   

			Produto produto = produtoService.buscaProdutoById(id);   

			if(produto != null) {   

				return ResponseEntity.ok(produto);   

			}  

			else {   

				return ResponseEntity.notFound().build();   

			}  

		}   

  

	@GetMapping("/")    

	public ResponseEntity<List<Produto>> buscaTodosProdutosControl(){   

		List<Produto> produto = produtoService.buscaTodosProduto();   

		return ResponseEntity.ok(produto);   

	}   

  

	@DeleteMapping("/{id}")   

	public ResponseEntity<Produto> apagarProdutoControl(@PathVariable Long id){   

		boolean apagar = produtoService.apagarProduto(id);   

		if (apagar) {   

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();   

		}   

		else {   

			return ResponseEntity.notFound().build(); 	}   

  

	}  

  

} 
