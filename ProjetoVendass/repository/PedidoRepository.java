package com.example.ProjetoVendass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetoVendass.entities.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, Long>{
}
