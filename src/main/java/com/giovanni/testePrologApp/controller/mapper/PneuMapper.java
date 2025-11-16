package com.giovanni.testePrologApp.controller.mapper;

import org.springframework.stereotype.Component;

import com.giovanni.testePrologApp.controller.request.PneuRequest;
import com.giovanni.testePrologApp.controller.response.PneuResponse;
import com.giovanni.testePrologApp.entity.Pneu;

@Component
public class PneuMapper {

    public Pneu toEntity(PneuRequest request) {
        return Pneu.builder()
                .numeroDeFogo(request.getNumeroDeFogo())
                .marca(request.getMarca())
                .pressaoPsi(request.getPressaoPsi())
                .statusPneu(request.getStatusPneu())
                .build();
    }

    public PneuResponse toResponse(Pneu pneu) {
        return PneuResponse.builder()
                .id(pneu.getId())
                .numeroDeFogo(pneu.getNumeroDeFogo())
                .marca(pneu.getMarca())
                .pressaoPsi(pneu.getPressaoPsi())
                .status(pneu.getStatusPneu())
                .build();
    }
}
