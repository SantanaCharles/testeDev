package com.example.demoTeste.repositories.services;

import com.example.demoTeste.entites.CalculoSalario;
import com.example.demoTeste.entites.Distritos;
import com.example.demoTeste.repositories.CalculoRepository;
import com.example.demoTeste.repositories.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CalculoService {

    @Autowired
    private CalculoRepository calculoRepository;

    @Autowired
    private DistritoRepository distritosRepository;

    private final WebClient webClient;

    public CalculoService(WebClient.Builder webClientBulder) {
        this.webClient = webClientBulder.baseUrl("https://viacep.com.br").build();
    }

    public CalculoSalario create(String data, Double salarioBruto, String cep){
        String uri = "/ws/{cep}/json/";

        Mono<Distritos> distritos = this.webClient.get()
                .uri(uri,cep)
                .retrieve()
                .bodyToMono(Distritos.class);


        Double salarioCalculado = salarioBruto * 0.35;

        Period period = Period.between(data, LocalDate.now());
        registro.setData(data);
        registro.setDias(period.getDays());
        registro.setMeses(period.getMonths());
        registro.setAnos(period.getYears());

        CalculoSalario calculoSalario = new CalculoSalario(null,cep,data, salarioBruto, salarioCalculado);
        calculoRepository.save(calculoSalario);


        return calculoSalario ;
    }

    public CalculoSalario findById(Long id){
        Optional<CalculoSalario> calculoSalario = calculoRepository.findById(id);
        return  calculoSalario.get();
    }

    public List<CalculoSalario> findAll(){
        return  calculoRepository.findAll();
    }

}
