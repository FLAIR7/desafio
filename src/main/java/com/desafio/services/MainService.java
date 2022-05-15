package com.desafio.services;

import com.desafio.entities.Venda;
import com.desafio.entities.Vendedor;
import com.desafio.repository.VendaRepository;
import com.desafio.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MainService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public List<Vendedor> getAllVendedores(){
        return vendedorRepository.findAll();
    }

    public Vendedor getVendedorById(Long vendedorId){
        return vendedorRepository
                .findById(vendedorId)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Vendedor com id: " + vendedorId + " não existe!"
                        ));
    }

    public Vendedor getVendedorByVendasDiarias(Long vendedorId, LocalDate dataVenda){
        Vendedor vendedor = vendedorRepository
                .findById(vendedorId)
                .orElseThrow(() ->
                        new NoSuchElementException("Vendedor id: " + vendedorId + " não existe!"));
        List<Venda> vendas = vendaRepository.findByDataVenda(vendedorId, dataVenda);
        vendedor.setVendas(vendas);
        return vendedor;
    }

    public void salvarVendedor(Vendedor vendedor) {
        /* Testa se os vendedores possuem o mesmo nome,
           set tiver, ele joga um exception
        List<Vendedor> vendedores = vendedorRepository.findAll();
        boolean exists = vendedores.stream().anyMatch(x -> x.equals(vendedor));
        if(exists){
            throw new IllegalStateException(
                    "Vendedor " + vendedor.getNome() + " already exist");
        }*/
        vendedorRepository.save(vendedor);
    }

    public void salvarVenda(Long vendedorId, Venda venda) {
        Vendedor vendedor = vendedorRepository
                .findById(vendedorId)
                .orElseThrow(() -> new NoSuchElementException("Vendedor id: " + vendedorId + " não existe"));
        vendedor.setTotalVendas(venda.getValor());
        venda.setVendedores(vendedor);
        vendaRepository.save(venda);
    }

    @Transactional
    public void atualizarVendedor(Long vendedorId,
                                  String nome){
        Vendedor vendedor = vendedorRepository.findById(vendedorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Vendedor com id " + vendedorId + " não existe"));
        if(nome != null && nome.length() > 0) {
            vendedor.setNome(nome);
        }
        vendedorRepository.atualizaVendedor(vendedorId, nome);
    }

    public void deletarVendedor(Long vendedorId){
        Vendedor vendedor = vendedorRepository
                .findById(vendedorId)
                .orElseThrow(() -> new NoSuchElementException("Não existe o vendedor com id: " + vendedorId + " para ser excluido"));
        vendedorRepository.deleteById(vendedorId);
    }

}
