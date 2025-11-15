package com.giovanni.testePrologApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giovanni.testePrologApp.entity.Veiculo;
import com.giovanni.testePrologApp.enums.StatusVeiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findByPlaca(String placa);

    List<Veiculo> findByStatusVeiculo(StatusVeiculo statusVeiculo);
}
