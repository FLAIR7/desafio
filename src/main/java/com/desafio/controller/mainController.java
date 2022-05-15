package com.desafio.controller;

import com.desafio.entities.Venda;
import com.desafio.entities.Vendedor;
import com.desafio.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/")
public class mainController {

    private final MainService mainService;

    @Autowired
    public mainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public List<Vendedor> vendedor(){
        return mainService.getAllVendedores();
    }

    @GetMapping(path = "{vendedorId}")
    public Vendedor vendedorPeloId(@PathVariable("vendedorId") Long vendedorId){
        return mainService.getVendedorById(vendedorId);
    }

    // url para achar a data das vendas http://localhost:8080/?dataVenda=2020-03-29
    @GetMapping(path = "{vendedorId}/")
    public Vendedor vendedorVendasDiarias(@PathVariable("vendedorId") Long vendedorId,
                                          @RequestParam("dataVenda") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataVenda){
        return mainService.getVendedorByVendasDiarias(vendedorId, dataVenda);
    }

    @PostMapping
    public void salvarVendedor(@RequestBody Vendedor vendedor){
        mainService.salvarVendedor(vendedor);
    }

    @PostMapping(path = "{vendedorId}")
    public void salvarVenda(@PathVariable("vendedorId") Long vendedorId,
                            @RequestBody Venda venda) {
        mainService.salvarVenda(vendedorId, venda);
    }

    @PutMapping(path = "{vendedorId}")
    public void atualizarVendedor(@PathVariable("vendedorId") Long vendedorId,
                                  @RequestBody Vendedor vendedor) {
        mainService.atualizarVendedor(vendedorId, vendedor.getNome());
    }

    @DeleteMapping(path = "{vendedorId}")
    public void deleteVendedor(@PathVariable("vendedorId") Long vendedorId){
        mainService.deletarVendedor(vendedorId);
    }
}
