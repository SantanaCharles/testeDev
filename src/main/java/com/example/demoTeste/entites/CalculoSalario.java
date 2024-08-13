package com.example.demoTeste.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name= "tb_calculosalario")
public class CalculoSalario  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String cep;
    private  String data;
    private  Double salariobruto;
    private  Double salariocaldulado;
    private

    public CalculoSalario(){
    }

    public CalculoSalario(Long id, String cep, String data, Double salariobruto, Double salariocaldulado) {
        this.id = id;
        this.cep = cep;
        this.data = data;
        this.salariobruto = salariobruto;
        this.salariocaldulado = salariocaldulado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getData() {
        return data;
    }

    public Double getSalariobruto() {
        return salariobruto;
    }

    public void setSalariobruto(Double salariobruto) {
        this.salariobruto = salariobruto;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getSalariocaldulado() {
        return salariocaldulado;
    }

    public void setSalariocaldulado(Double salariocaldulado) {
        this.salariocaldulado = salariocaldulado;
    }
}
