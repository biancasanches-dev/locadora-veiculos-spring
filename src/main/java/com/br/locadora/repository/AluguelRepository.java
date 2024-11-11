package com.br.locadora.repository;

import com.br.locadora.model.Aluguel;
import com.br.locadora.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findByUsuario(Usuario usuario);
}
