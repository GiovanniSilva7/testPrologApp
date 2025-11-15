package com.giovanni.testePrologApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giovanni.testePrologApp.entity.Pneu;
import com.giovanni.testePrologApp.entity.Veiculo;
import com.giovanni.testePrologApp.entity.VeiculoPneu;

@Repository
public interface VeiculoPneuRepository extends JpaRepository<VeiculoPneu, Long> {

    List<VeiculoPneu> findByVeiculo(Veiculo veiculo);

    Optional<VeiculoPneu> findByPneu(Pneu pneu);

    boolean existsByVeiculoAndPosicao(Veiculo veiculo, String posicao);
}
