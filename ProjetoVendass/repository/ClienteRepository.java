package com.example.ProjetoVendass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetoVendass.entities.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{

}
