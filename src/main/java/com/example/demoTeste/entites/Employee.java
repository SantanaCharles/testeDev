package com.example.demoTeste.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAdmissao;
    private double salarioBruto;
    private String cep;
    private int dias;
    private int meses;
    private int anos;
    private double novoSalario;
    private String dadosCep;

    public Employee(){}

    public Employee(Long id, LocalDate dataAdmissao, double salarioBruto, String cep, int dias, int meses, int anos, double novoSalario, String dadosCep) {
        this.id = id;
        this.dataAdmissao = dataAdmissao;
        this.salarioBruto = salarioBruto;
        this.cep = cep;
        this.dias = dias;
        this.meses = meses;
        this.anos = anos;
        this.novoSalario = novoSalario;
        this.dadosCep = dadosCep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public double getNovoSalario() {
        return novoSalario;
    }

    public void setNovoSalario(double novoSalario) {
        this.novoSalario = novoSalario;
    }

    public String getDadosCep() {
        return dadosCep;
    }

    public void setDadosCep(String dadosCep) {
        this.dadosCep = dadosCep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
