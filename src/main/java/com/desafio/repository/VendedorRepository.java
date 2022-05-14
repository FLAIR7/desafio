package com.desafio.repository;

import com.desafio.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    Vendedor findByVendedorId(Long vendedorId);

    @Modifying
    @Query("update Vendedor v set v.nome = ?2 where v.id = ?1")
    void atualizaVendedor(Long vendedorId, String nome);

}
