package com.desafio.repository;

import com.desafio.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    //List<Venda> findByDataVenda(LocalDate dataVenda);

    @Query("select vd from Venda vd join vd.vendedores v where v.id = ?1 and vd.dataVenda between ?2 and ?2")
    List<Venda> findByDataVenda(Long vendedorId, LocalDate dataVenda);

}
