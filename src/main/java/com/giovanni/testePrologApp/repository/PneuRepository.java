package com.giovanni.testePrologApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giovanni.testePrologApp.entity.Pneu;
import com.giovanni.testePrologApp.enums.StatusPneu;

@Repository
public interface PneuRepository extends JpaRepository<Pneu, Long> {
    Optional<Pneu> findByNumeroDeFogo(String numeroDeFogo);

    List<Pneu> findByStatusPneu(StatusPneu statusPneu);
}
