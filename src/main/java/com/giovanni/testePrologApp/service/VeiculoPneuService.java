package com.giovanni.testePrologApp.service;

import org.springframework.stereotype.Service;

import com.giovanni.testePrologApp.entity.VeiculoPneu;
import com.giovanni.testePrologApp.exception.NegocioException;
import com.giovanni.testePrologApp.repository.VeiculoPneuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VeiculoPneuService {
    private final VeiculoPneuRepository veiculoPneuRepository;
    public VeiculoPneu buscarPorId(Long id){
        return veiculoPneuRepository.findById(id).orElseThrow(() -> new NegocioException("Veiculo com pneu nao encontrado"));
    }
}
