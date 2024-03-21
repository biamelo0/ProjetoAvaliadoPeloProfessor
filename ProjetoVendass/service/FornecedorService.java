package com.example.ProjetoVendass.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetoVendass.entities.Fornecedor;
import com.example.ProjetoVendass.repository.FonecedorRepository;


@Service
public class FornecedorService {
	private final FonecedorRepository fornecedorRepository; 

	@Autowired 
	public FornecedorService (FonecedorRepository fornecedorRepository) { 
		this.fornecedorRepository = fornecedorRepository; 
	} 

	public List<Fornecedor> buscaTodosFornecedor(){ 
		return fornecedorRepository.findAll(); 
	} 

	public Fornecedor buscaFornecedorById(Long id) { 
		Optional <Fornecedor> fornecedor = fornecedorRepository.findById(id); 
		return fornecedor.orElse(null); 
	} 

	public Fornecedor salvaFornecedor (Fornecedor fornecedor) { 
		return fornecedorRepository.save(fornecedor); 
	} 

	public Fornecedor alteraFornecedor(long id, Fornecedor alteraFornecedor) { 
		Optional <Fornecedor> existeFornecedor =  fornecedorRepository.findById(id); 
		if (existeFornecedor.isPresent()) { 
			alteraFornecedor.setId(id); 
			return fornecedorRepository.save(alteraFornecedor); 
		} 
		return null; 
	} 

	public boolean apagarFornecedor(Long id) { 
		Optional <Fornecedor> existeFornecedor = fornecedorRepository.findById(id); 
		if (existeFornecedor.isPresent()) { 
			fornecedorRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
	
	

}