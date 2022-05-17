package com.desafio.controller;

import com.desafio.entities.Vendedor;
import com.desafio.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/")
public class VendedorController {

    private final MainService mainService;

    @Autowired
    public VendedorController(MainService mainService) {
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

    @GetMapping(path = "{vendedorId}/")
    public Vendedor vendedorVendasDiarias(@PathVariable("vendedorId") Long vendedorId,
                                          @RequestParam("dataVenda") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataVenda){
        return mainService.getVendedorByVendasDiarias(vendedorId, dataVenda);
    }

    @PostMapping
    public void salvarVendedor(@RequestBody Vendedor vendedor){
        mainService.salvarVendedor(vendedor);
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
