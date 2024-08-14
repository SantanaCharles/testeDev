package com.example.demoTeste.services;

import com.example.demoTeste.entites.Employee;
import com.example.demoTeste.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;


    private final WebClient webClient;

    public EmployeeService(WebClient.Builder webClientBulder) {
        this.webClient = webClientBulder.baseUrl("https://viacep.com.br").build();
    }

    public Employee calcularERegistrar(Employee employee){
        LocalDate dataAdmissao = employee.getDataAdmissao();
        LocalDate dateAtual = LocalDate.now();

        Period period = Period.between(dataAdmissao,dateAtual);
        employee.setDias(period.getDays());
        employee.setMeses(period.getMonths());
        employee.setAnos(period.getYears());

        employee.setNovoSalario(employee.getNovoSalario() * 0.35);

        String dadosCep = webClient.get()
                .uri("/ws/{cep}/json/", employee.getCep())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        employee.setDadosCep(dadosCep);

        return repository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> optionalEmployee = repository.findById(id);
        return  optionalEmployee.get();
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

}
