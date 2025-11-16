package com.giovanni.testePrologApp.controller.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.giovanni.testePrologApp.enums.StatusPneu;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class PneuRequest {
    private Long id;
    private String numeroDeFogo;
    private String marca;
    private BigDecimal pressaoPsi;
    private StatusPneu statusPneu;
    
}
