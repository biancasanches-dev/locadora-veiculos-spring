package com.br.locadora.controller;

import com.br.locadora.dto.UsuarioDto;
import com.br.locadora.model.Usuario;
import com.br.locadora.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioService.salvar(usuarioDto.nome(), usuarioDto.senha());
        return ResponseEntity.ok("Usuário " + usuario.getUsername() + " cadastrado com sucesso");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody String nome, @RequestBody String senha) {
        usuarioService.atualizar(id, nome, senha);
        return ResponseEntity.ok("Usuário atualizado com sucesso");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.ok("Usuário deletado com sucesso");
    }
}
