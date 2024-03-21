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

import com.example.ProjetoVendass.entities.Cliente;
import com.example.ProjetoVendass.service.ClienteService;

import jakarta.validation.Valid; 

  

@RestController 

@RequestMapping("/cliente") 

public class ClienteController { 

	private final ClienteService clienteService;   

  

	@Autowired   

	public ClienteController(ClienteService clienteService) {   

	this.clienteService = clienteService;   

	}   

  

	@PostMapping("/")   

	public ResponseEntity<Cliente> createCliente(@RequestBody @Valid Cliente cliente) {   

		Cliente salvaCliente = clienteService.salvaCliente(cliente);   

	return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);   

	}   

  

	@PutMapping("/{id}")    

	public ResponseEntity<Cliente> alteraClienteControl(@PathVariable Long id, @RequestBody @Valid Cliente cliente){   

		Cliente alteraCliente = clienteService.alteraCliente(id, cliente);   

		if (alteraCliente != null) {  

			return ResponseEntity.ok(cliente);   

		}   

		else {   

			return ResponseEntity.notFound().build();   

		}   

	}   

  

	@GetMapping("/{id}")   

		public ResponseEntity<Cliente> buscaClienteControlId (@PathVariable Long id){   

			Cliente cliente = clienteService.buscaClienteById(id);   

			if(cliente != null) {   

				return ResponseEntity.ok(cliente);   

			}  

			else {   

				return ResponseEntity.notFound().build();   

			}  

		}   

  

	@GetMapping("/")    

	public ResponseEntity<List<Cliente>> buscaTodosClientesControl(){   

		List<Cliente> cliente = clienteService.buscaTodosClientes();   

		return ResponseEntity.ok(cliente);   

	}   

  

	@DeleteMapping("/{id}")   

	public ResponseEntity<Cliente> apagarClienteControl(@PathVariable Long id){   

		boolean apagar = clienteService.apagarCliente(id);   

		if (apagar) {   

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();   

		}   

		else {   

			return ResponseEntity.notFound().build(); 	}   

  

	}  

  

} 