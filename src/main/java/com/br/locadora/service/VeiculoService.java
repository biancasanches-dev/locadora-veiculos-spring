package com.br.locadora.service;

import com.br.locadora.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    List<Veiculo> getModelosPorMarca(String Marca);
}
