package com.giovanni.testePrologApp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giovanni.testePrologApp.controller.mapper.PneuMapper;
import com.giovanni.testePrologApp.controller.request.PneuRequest;
import com.giovanni.testePrologApp.controller.response.PneuResponse;
import com.giovanni.testePrologApp.entity.Pneu;
import com.giovanni.testePrologApp.exception.NegocioException;
import com.giovanni.testePrologApp.repository.PneuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PneuService {
    private final PneuRepository pneuRepository;
    private final PneuMapper pneuMapper;

    @Transactional(readOnly = true)
    public PneuResponse buscarPorId(Long id) {
        Pneu pneu = pneuRepository.findById(id)
                .orElseThrow(() -> new NegocioException("Erro ao buscar pneu"));

        return pneuMapper.toResponse(pneu);
    }

    @Transactional
    public PneuResponse cadastrar(PneuRequest request) {
        Pneu pneu = pneuMapper.toEntity(request);
        pneu = pneuRepository.save(pneu);
        return pneuMapper.toResponse(pneu);

    }

}
