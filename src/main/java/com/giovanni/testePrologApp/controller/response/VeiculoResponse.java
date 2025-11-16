package com.giovanni.testePrologApp.controller.response;

import java.util.List;

import com.giovanni.testePrologApp.enums.StatusVeiculo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class VeiculoResponse {
   private Long id;
   private String placa;
   private String modelo;
   private String marca;
   private Integer ano;
   private StatusVeiculo status;
   private List<PneusAplicadoResponse> pneus;
   private InformacoesGeraisResponse informacoesGerais;
}
