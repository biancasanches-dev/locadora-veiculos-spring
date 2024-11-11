package com.br.locadora.service.impl;

import com.br.locadora.model.Usuario;
import com.br.locadora.repository.UsuarioRepository;
import com.br.locadora.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvar(String nome, String senha) {
        Usuario usuario = new Usuario();
        usuario.setUsername(nome);
        usuario.setSenha(senha);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarUsuario(Long id) {
        return Optional.of(usuarioRepository.findById(id).get());
    }

    @Override
    public void atualizar(Long id, String nome, String senha) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.setUsername(nome);
        usuario.setSenha(senha);
        usuarioRepository.save(usuario);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
