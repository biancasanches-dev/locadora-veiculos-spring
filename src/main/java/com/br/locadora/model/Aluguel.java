package com.br.locadora.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario usuario;
    @Embedded
    private Veiculo veiculo;
    private LocalDate dataHoraAluguel;
    private LocalDate devolucao;
    private BigDecimal valorTotal;
    private Boolean isEmAberto;

}
