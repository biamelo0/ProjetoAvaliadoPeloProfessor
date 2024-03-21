package com.example.ProjetoVendass.service; 

 

import java.util.List; 

import java.util.Optional; 

 

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Service; 

 

import com.example.ProjetoVendass.entities.Produto; 

import com.example.ProjetoVendass.repository.ProdutoRepository; 

 

 

@Service 

public class ProdutoService { 

	private final ProdutoRepository produtoRepository;  

 

	@Autowired  

	public ProdutoService (ProdutoRepository produtoRepository) {  

		this.produtoRepository = produtoRepository;  

	}  

 

	public List<Produto> buscaTodosProduto(){  

		return produtoRepository.findAll();  

	}  

 

	public Produto buscaProdutoById(Long id) {  

		Optional <Produto> produto = produtoRepository.findById(id);  

		return produto.orElse(null);  

	}  

 

	public Produto salvaProduto (Produto produto) {  

		return produtoRepository.save(produto);  

	}  

 

	public Produto alteraProduto(long id, Produto alteraProduto) {  

		Optional <Produto> existeProduto = produtoRepository.findById(id);  

		if (existeProduto.isPresent()) {  

			alteraProduto.setId(id);  

			return produtoRepository.save(alteraProduto);  

		}  

		return null;  

	}  

 

	public boolean apagarProduto(Long id) {  

		Optional <Produto> existeProduto = produtoRepository.findById(id);  

		if (existeProduto.isPresent()) {  

			produtoRepository.deleteById(id);  

			return true;  

		}  

		return false;  

	}  

	 

	 

 

} 

 

 