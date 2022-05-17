package com.desafio.controller;

import com.desafio.entities.Venda;
import com.desafio.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class VendaController {

    private final MainService mainService;

    @Autowired
    public VendaController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping(path = "{vendedorId}")
    public void salvarVenda(@PathVariable("vendedorId") Long vendedorId,
                            @RequestBody Venda venda) {
        mainService.salvarVenda(vendedorId, venda);
    }

    @DeleteMapping(path = "{vendedorId}/{vendaId}")
    public void deleteVenda(@PathVariable("vendedorId") Long vendedorId, @PathVariable("vendaId") Long vendaId) {
        mainService.deletarVenda(vendedorId, vendaId);
    }
}
