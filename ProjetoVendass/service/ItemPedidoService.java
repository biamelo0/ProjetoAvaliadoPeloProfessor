package com.example.ProjetoVendass.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetoVendass.entities.ItemPedido;
import com.example.ProjetoVendass.repository.ItemPedidoRepository;


@Service
public class ItemPedidoService {
	private final ItemPedidoRepository itemPedidoRepository; 

	@Autowired 
	public ItemPedidoService (ItemPedidoRepository itemPedidoRepository) { 
		this.itemPedidoRepository = itemPedidoRepository; 
	} 

	public List<ItemPedido> buscaTodosItemPedido(){ 
		return itemPedidoRepository.findAll(); 
	} 

	public ItemPedido buscaItemPedidoById(Long id) { 
		Optional <ItemPedido> itemPedido = itemPedidoRepository.findById(id); 
		return itemPedido.orElse(null); 
	} 

	public ItemPedido salvaItemPedido (ItemPedido itemPedido) { 
		return itemPedidoRepository.save(itemPedido); 
	} 

	public ItemPedido alteraItemPedido(long id, ItemPedido alteraItemPedido) { 
		Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id); 
		if (existeItemPedido.isPresent()) { 
			alteraItemPedido.setId(id); 
			return itemPedidoRepository.save(alteraItemPedido); 
		} 
		return null; 
	} 

	public boolean apagarItemPedido(Long id) { 
		Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id); 
		if (existeItemPedido.isPresent()) { 
			itemPedidoRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
	
	

}
