package com.giovanni.testePrologApp.controller.response;

import java.math.BigDecimal;

import com.giovanni.testePrologApp.enums.StatusPneu;

import lombok.Builder;

@Builder
public record PneusAplicadoResponse(
        Long id,
        String numeroDeFogo,
        String marca,
        BigDecimal pressaoPsi,
        StatusPneu status,
        String posicao) {


}
