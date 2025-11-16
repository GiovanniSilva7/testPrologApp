package com.giovanni.testePrologApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giovanni.testePrologApp.entity.VeiculoPneu;

@Repository
public interface VeiculoPneuRepository extends JpaRepository<VeiculoPneu, Long> {

    List<VeiculoPneu> findByVeiculoId(Long veiculoId);

    boolean existsByVeiculoIdAndPosicao(Long veiculoId, String posicao);

    boolean existsByPneuId(Long pneuId);

    void deleteByVeiculoIdAndPneuId(Long veiculoId, Long pneuId);
}
