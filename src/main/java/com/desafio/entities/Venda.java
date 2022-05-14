package com.desafio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendaId;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataVenda;

    private Double valor;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "venda_vendedor",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "vendedor_id")
    )
    @JsonIgnore
    private Vendedor vendedores;

    public Venda(){
    }

    public Venda(LocalDate dataVenda, Double valor){
        this.dataVenda = dataVenda;
        this.valor = valor;
    }

    public Long getVendaId() {
        return vendaId;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Vendedor getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedor vendedores) {
        this.vendedores = vendedores;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "vendaId=" + vendaId +
                ", dataVenda=" + dataVenda +
                ", valor=" + valor +
                '}';
    }
}
