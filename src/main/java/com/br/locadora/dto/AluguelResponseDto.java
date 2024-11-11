package com.br.locadora.dto;

import com.br.locadora.model.Aluguel;
import lombok.Data;

@Data
public class AluguelResponseDto {
    private String marca;
    private String modelo;
    private String nomeUsuario;
    private String dataHoraAluguel;
    private String devolucao;
    private String valorTotal;
    private Boolean isEmAberto;

    public AluguelResponseDto(Aluguel aluguel) {
        this.marca = aluguel.getVeiculo().getMarca();
        this.modelo = aluguel.getVeiculo().getModelo();
        this.nomeUsuario = aluguel.getUsuario().getUsername();
        this.dataHoraAluguel = aluguel.getDataHoraAluguel().toString();
        this.devolucao = aluguel.getDevolucao().toString();
        this.valorTotal = aluguel.getValorTotal().toString();
    }

}
