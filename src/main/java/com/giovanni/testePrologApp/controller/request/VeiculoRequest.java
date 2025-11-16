package com.giovanni.testePrologApp.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.giovanni.testePrologApp.enums.StatusVeiculo;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=false)
public class VeiculoRequest {
    private Long id;
    private String placa;
    private String marca;
    private Integer quilometragem;
    private StatusVeiculo statusVeiculo;
    
}
