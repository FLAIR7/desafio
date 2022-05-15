package com.desafio.repository;

import com.desafio.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("SELECT vd FROM Venda vd " +
            "JOIN vd.vendedores v " +
            "WHERE v.id = ?1 " +
            "AND vd.dataVenda " +
            "BETWEEN ?2 AND ?2")
    List<Venda> findByDataVenda(Long vendedorId, LocalDate dataVenda);



}
