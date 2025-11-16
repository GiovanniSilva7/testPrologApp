package com.giovanni.testePrologApp.controller.response;

import java.math.BigDecimal;

import com.giovanni.testePrologApp.enums.StatusPneu;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PneuResponse {
    private Long id;
    private String numeroDeFogo;
    private String marca;
    private BigDecimal pressaoPsi;
    private StatusPneu status;
}
