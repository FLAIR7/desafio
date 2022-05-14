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
        boolean exists = vendedorRepository.existsById(vendedorId);
        if(!exists) {
            throw new IllegalStateException(
                    "Vendedor with id: " + vendedorId + " does not exist");
        }
        return vendedorRepository.findByVendedorId(vendedorId);
    }

    public Vendedor getVendedorByVendasDiarias(Long vendedorId, LocalDate dataVenda){
        Vendedor vendedor = vendedorRepository.findByVendedorId(vendedorId);
        List<Venda> vendas = vendaRepository.findByDataVenda(vendedorId, dataVenda);
        vendedor.setVendas(vendas);
        return vendedor;
    }

    public void salvarVendedor(Vendedor vendedor) {
        /*List<Vendedor> vendedores = vendedorRepository.findAll();
        boolean exists = vendedores.stream().anyMatch(x -> x.equals(vendedor));
        if(exists){
            throw new IllegalStateException(
                    "Vendedor " + vendedor.getNome() + " already exist");
        }*/
        vendedorRepository.save(vendedor);
    }

    public void salvarVenda(Long vendedorId, Venda venda) {
        boolean exists = vendedorRepository.existsById(vendedorId);
        if(!exists) {
            throw new IllegalStateException(
                    "Impossivel salvar, Vendedor com id: " + vendedorId + " não existe");
        }
        Vendedor vendedor = vendedorRepository.findByVendedorId(vendedorId);
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

}
