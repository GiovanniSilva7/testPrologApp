package com.giovanni.testePrologApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giovanni.testePrologApp.controller.mapper.VeiculoMapper;
import com.giovanni.testePrologApp.controller.request.VeiculoRequest;
import com.giovanni.testePrologApp.controller.response.VeiculoPneusResponse;
import com.giovanni.testePrologApp.controller.response.VeiculoResponse;
import com.giovanni.testePrologApp.entity.Veiculo;
import com.giovanni.testePrologApp.entity.VeiculoPneu;
import com.giovanni.testePrologApp.exception.NegocioException;
import com.giovanni.testePrologApp.repository.VeiculoPneuRepository;
import com.giovanni.testePrologApp.repository.VeiculoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;
    private final VeiculoPneuRepository veiculoPneuRepository;
    private final VeiculoMapper veiculoMapper;

    @Transactional(readOnly = true)
    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id).orElseThrow(() -> new NegocioException("Veiculo nao encontrado"));
    }

    @Transactional(readOnly = true)
    public List<VeiculoResponse> listarTodos() {
        return veiculoRepository.findAll().stream().map(veiculoMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public VeiculoPneusResponse buscarVeiculoComPneus(Long veiculoId) {
        Veiculo veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new NegocioException("Veículo não encontrado"));

        List<VeiculoPneu> veiculoPneus = veiculoPneuRepository.findByVeiculoId(veiculoId);

        return veiculoMapper.toResponse(veiculo, veiculoPneus);
    }

    @Transactional
    public VeiculoResponse cadastrar(VeiculoRequest request) {
        Veiculo veiculo = veiculoMapper.toEntity(request);
        veiculo = veiculoRepository.save(veiculo);
        return veiculoMapper.toResponse(veiculo);
    }

}
