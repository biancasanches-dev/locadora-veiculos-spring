package com.br.locadora.service;

import com.br.locadora.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario salvar(String nome, String senha);
    Optional<Usuario> buscarUsuario(Long id);
    void atualizar(Long id, String nome, String senha);
    void deletar(Long id);
}
