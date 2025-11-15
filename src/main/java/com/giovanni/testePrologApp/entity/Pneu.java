package com.giovanni.testePrologApp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.giovanni.testePrologApp.enums.StatusPneu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "pneu")
public class Pneu implements Serializable{
        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, unique=true, name = "id")
    private Long id;

    @Column(name = "numero_de_fogo", nullable=false, unique = true)
    private String numeroDeFogo;

    @Column (name = "marca", nullable=false)
    @NotNull(message="{pneu.marca.not-null}")
    @NotBlank(message="{pneu.marca.not-blank}")
    private String marca;

    @Column (name = "pressao_psi", nullable=false)
    private BigDecimal pressaoPsi;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable=false)
    private StatusPneu statusPneu;


    
}
