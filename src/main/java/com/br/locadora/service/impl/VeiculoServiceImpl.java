package com.br.locadora.service.impl;

import com.br.locadora.api.CarApiClient;
import com.br.locadora.api.CarApiResponse;
import com.br.locadora.model.Veiculo;
import com.br.locadora.service.VeiculoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final CarApiClient carApiClient;

    @Value("${rapidapi.host}")
    private String apiHost;

    @Value("${rapidapi.key}")
    private String apiKey;

    public VeiculoServiceImpl(CarApiClient carApiClient) {
        this.carApiClient = carApiClient;
    }

    @Override
    public List<Veiculo> getModelosPorMarca(String marca) {
        CarApiResponse response = carApiClient.getModelosPorMarca(apiHost, apiKey, marca);

        return response.getData().stream()
                .map(item -> item.get("modelName"))
                .filter(Objects::nonNull)
                .map(modelo -> new Veiculo(marca, modelo))
                .toList();
    }


}
