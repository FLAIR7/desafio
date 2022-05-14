package com.desafio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long vendedorId;

    private String nome;

    private double totalVendas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vendedores")
    private List<Venda> vendas;

    public Vendedor(){
    }

    public Vendedor(String nome){
        this.nome = nome;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas += totalVendas;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return nome.equals(vendedor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendedorId=" + vendedorId +
                ", nome='" + nome + '\'' +
                ", totalVendas='" + totalVendas + '\'' +
                ", vendas=" + vendas +
                '}';
    }
}
