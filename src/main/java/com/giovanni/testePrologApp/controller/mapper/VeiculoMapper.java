package com.giovanni.testePrologApp.controller.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.giovanni.testePrologApp.controller.request.VeiculoRequest;
import com.giovanni.testePrologApp.controller.response.PneusAplicadoResponse;
import com.giovanni.testePrologApp.controller.response.VeiculoPneusResponse;
import com.giovanni.testePrologApp.controller.response.VeiculoResponse;
import com.giovanni.testePrologApp.entity.Veiculo;
import com.giovanni.testePrologApp.entity.VeiculoPneu;

@Component
public class VeiculoMapper {

    public Veiculo toEntity(VeiculoRequest request) {
        Veiculo veiculo = Veiculo.builder()
                .marca(request.getMarca())
                .placa(request.getPlaca())
                .quilometragem(request.getQuilometragem())
                .statusVeiculo(request.getStatusVeiculo())
                .build();

        return veiculo;
    }

    public VeiculoResponse toResponse(Veiculo veiculo) {
        return VeiculoResponse.builder()
                .id(veiculo.getId())
                .placa(veiculo.getPlaca())
                .marca(veiculo.getMarca())
                .status(veiculo.getStatusVeiculo())
                .build();
    }

    public VeiculoPneusResponse toResponse(Veiculo veiculo, List<VeiculoPneu> veiculoPneus) {

        return VeiculoPneusResponse.builder()
                .id(veiculo.getId())
                .placa(veiculo.getPlaca())
                .marca(veiculo.getMarca())
                .status(veiculo.getStatusVeiculo())
                .pneus(
                        veiculoPneus == null ? List.of()
                                : veiculoPneus.stream()
                                        .map(this::toPneuAplicadoResponse)
                                        .toList())
                .build();
    }

    private PneusAplicadoResponse toPneuAplicadoResponse(VeiculoPneu vp) {
        var p = vp.getPneu();

        return PneusAplicadoResponse.builder()
                .id(p.getId())
                .numeroDeFogo(p.getNumeroDeFogo())
                .marca(p.getMarca())
                .pressaoPsi(p.getPressaoPsi())
                .status(p.getStatusPneu())
                .posicao(vp.getPosicao())
                .build();
    }
}
