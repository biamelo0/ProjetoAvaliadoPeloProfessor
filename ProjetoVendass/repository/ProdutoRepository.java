package com.example.ProjetoVendass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetoVendass.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}
