package com.giovanni.testePrologApp.controller.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record InformacoesGeraisResponse(
        LocalDateTime dataCadastro,
        LocalDateTime ultimaAtualizacao
) {}
