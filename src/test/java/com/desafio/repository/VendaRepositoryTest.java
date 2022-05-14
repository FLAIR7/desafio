package com.desafio.repository;

import com.desafio.entities.Venda;
import com.desafio.entities.Vendedor;
import com.desafio.services.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class VendaRepositoryTest {


    @Autowired
    private  MainService mainService;


    @Test
    public void saveVenda(){
        Vendedor diego = new Vendedor("Diego");
        Venda celular = new Venda(LocalDate.parse("2022-04-03"), 500.0);
        diego.setVendas(List.of(celular));
        mainService.salvarVendedor(diego);
    }

}