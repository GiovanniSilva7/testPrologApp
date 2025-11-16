package com.giovanni.testePrologApp.controller.response;

import java.util.List;

import com.giovanni.testePrologApp.enums.StatusVeiculo;

import lombok.Builder;

@Builder
public record VeiculoPneusResponse (
    Long id,
    String placa,
    String marca,
    StatusVeiculo status,
    List<PneusAplicadoResponse> pneus
){}
