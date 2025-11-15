package com.giovanni.testePrologApp.entity;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(
    name = "veiculo_pneu",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"veiculo_id", "posicao"}),
        @UniqueConstraint(columnNames = {"pneu_id"})
    }
    )
public class VeiculoPneu implements Serializable{
        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, unique=true, name = "id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(nullable=false, name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(nullable=false, name = "pneu_id")
    private Pneu pneu;

    @Column (name = "posicao", nullable=false)
    @NotNull(message="{veiculo_pneu.posicao.not-null}")
    @NotBlank(message="{veiculo_pneu.posicao.not-blank}")
    private String posicao;

    
    


}
