package com.br.locadora.service;

import com.br.locadora.model.Aluguel;
import com.br.locadora.model.Usuario;

import java.util.List;

public interface AluguelService {
    List<Aluguel> buscarAlugueisPorUsuario(Usuario usuario);
    Aluguel alugarVeiculo(String marca, String modelo, Long userId, int dias);

}
