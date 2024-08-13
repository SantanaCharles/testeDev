package com.example.demoTeste.repositories;

import com.example.demoTeste.entites.CalculoSalario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculoRepository  extends JpaRepository<CalculoSalario, Long> {
}
