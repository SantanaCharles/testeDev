package com.example.demoTeste.controller;

import com.example.demoTeste.entites.CalculoSalario;
import com.example.demoTeste.repositories.CalculoRepository;
import com.example.demoTeste.repositories.services.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/calculos")
public class CalculoSalarioController {

    @Autowired
    CalculoService calculoService;

//    @GetMapping
//    public ResponseEntity<CalculoSalario> findById(@PathVariable Long id) {
//        CalculoSalario calcSalario = calculoService.findById(id);
//        return ResponseEntity.ok().body(calcSalario);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CalculoSalario>> findAll(){
//        List<CalculoSalario> calculoSalarioList = calculoService.findAll();
//        return  ResponseEntity.ok().body(calculoSalarioList);
//    }

    @PostMapping
    public  ResponseEntity<CalculoSalario> criarRegistro(@RequestBody CalculoSalario calculoSalario){
        CalculoSalario calculoSalario1  = calculoService.create(calculoSalario.getData(),calculoSalario.getSalariobruto(), calculoSalario.getCep());

        return ResponseEntity.ok().body(calculoSalario1);
    }



}
