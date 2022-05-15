package com.desafio.repository;

import com.desafio.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Vendedor v " +
            "SET v.nome=:nome " +
            "WHERE v.id=:vendedorId")
    void atualizaVendedor(@Param("vendedorId") Long vendedorId, @Param("nome") String nome);


}
