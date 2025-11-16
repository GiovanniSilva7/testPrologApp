package com.giovanni.testePrologApp.entity;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.giovanni.testePrologApp.enums.StatusVeiculo;

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
import jakarta.validation.constraints.Size;
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
@Table(name = "veiculo")
public class Veiculo implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, name = "id")
    private Long id;

    @Column(name = "placa", nullable=false)
    @NotNull(message="{veiculo.placa.not-null}")
    @NotBlank(message="{veiculo.placa.not-blank}")
    @Size(max = 7, message="veiculo.placa.size")
    private String placa;


    @Column(name = "marca", nullable=false)
    @NotNull(message="{veiculo.marca.not-null}")
    @NotBlank(message="{veiculo.marca.not-blank}")
    @Size(max = 50, message="veiculo.marca.size")
    private String marca;

    @Column(name = "quilometragem", nullable = false)
    private Integer quilometragem;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable=false)
    private StatusVeiculo statusVeiculo;
    
}
