package com.br.locadora.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Veiculo {
    private String marca;
    private String modelo;
    private BigDecimal valorDiaria;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorDiaria = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(100, 300))
                .setScale(2, RoundingMode.HALF_UP);
    }

}