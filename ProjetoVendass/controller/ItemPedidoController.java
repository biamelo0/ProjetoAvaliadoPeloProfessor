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

import com.example.ProjetoVendass.entities.ItemPedido;
import com.example.ProjetoVendass.service.ItemPedidoService;

import jakarta.validation.Valid; 

  

@RestController 

@RequestMapping("/itemPedido") 

public class ItemPedidoController { 

	private final ItemPedidoService itemPedidoService;   

  

	@Autowired   

	public ItemPedidoController(ItemPedidoService itemPedidoService) {   

	this.itemPedidoService = itemPedidoService;   

	}   

  

	@PostMapping("/")   

	public ResponseEntity<ItemPedido> createItemPedido(@RequestBody @Valid ItemPedido itemPedido) {   

		ItemPedido salvaItemPedido = itemPedidoService.salvaItemPedido(itemPedido);   

	return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemPedido);   

	}   

  

	@PutMapping("/{id}")    

	public ResponseEntity<ItemPedido> alteraItemPedidoControl(@PathVariable Long id, @RequestBody @Valid ItemPedido itemPedido){   

		ItemPedido alteraItemPedido = itemPedidoService.alteraItemPedido(id, itemPedido);   

		if (alteraItemPedido != null) {  

			return ResponseEntity.ok(itemPedido);   

		}   

		else {   

			return ResponseEntity.notFound().build();   

		}   

	}   

  

	@GetMapping("/{id}")   

		public ResponseEntity<ItemPedido> buscaItemPedidoControlId (@PathVariable Long id){   

			ItemPedido itemPedido = itemPedidoService.buscaItemPedidoById(id);   

			if(itemPedido != null) {   

				return ResponseEntity.ok(itemPedido);   

			}  

			else {   

				return ResponseEntity.notFound().build();   

			}  

		}   

  

	@GetMapping("/")    

	public ResponseEntity<List<ItemPedido>> buscaTodosItemPedidosControl(){   

		List<ItemPedido> itemPedido = itemPedidoService.buscaTodosItemPedido();   

		return ResponseEntity.ok(itemPedido);   

	}   

  

	@DeleteMapping("/{id}")   

	public ResponseEntity<ItemPedido> apagarItemPedidoControl(@PathVariable Long id){   

		boolean apagar = itemPedidoService.apagarItemPedido(id);   

		if (apagar) {   

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();   

		}   

		else {   

			return ResponseEntity.notFound().build(); 	}   

  

	}  

  

} 
