package com.br.locadora.service.impl;

import com.br.locadora.model.Aluguel;
import com.br.locadora.model.Usuario;
import com.br.locadora.model.Veiculo;
import com.br.locadora.repository.AluguelRepository;
import com.br.locadora.repository.UsuarioRepository;
import com.br.locadora.service.AluguelService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final UsuarioRepository usuarioRepository;

    public AluguelServiceImpl(AluguelRepository aluguelRepository, UsuarioRepository usuarioRepository) {
        this.aluguelRepository = aluguelRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Aluguel> buscarAlugueisPorUsuario(Usuario usuario) {
        return aluguelRepository.findByUsuario(usuario);
    }

    @Override
    public Aluguel alugarVeiculo(String marca, String modelo, Long userId, int dias) {
        Usuario user = usuarioRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Veiculo veiculo = new Veiculo(marca, modelo);

        Aluguel aluguel = new Aluguel();
        aluguel.setVeiculo(veiculo);
        aluguel.setUsuario(user);
        aluguel.setDataHoraAluguel(LocalDate.now());
        aluguel.setDevolucao(LocalDate.now().plusDays(dias));
        aluguel.setValorTotal(veiculo.getValorDiaria().multiply(new java.math.BigDecimal(dias)));
        aluguel.setIsEmAberto(true);

        aluguelRepository.save(aluguel);

        return aluguel;
    }


}
