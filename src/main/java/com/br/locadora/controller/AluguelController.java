package com.br.locadora.controller;

import com.br.locadora.dto.AluguelDto;
import com.br.locadora.dto.AluguelResponseDto;
import com.br.locadora.model.Aluguel;
import com.br.locadora.model.Usuario;
import com.br.locadora.model.Veiculo;
import com.br.locadora.service.AluguelService;
import com.br.locadora.service.UsuarioService;
import com.br.locadora.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    private final AluguelService aluguelService;
    private final UsuarioService usuarioService;
    private final VeiculoService veiculoService;

    public AluguelController(AluguelService aluguelService, UsuarioService usuarioService, VeiculoService veiculoService) {
        this.aluguelService = aluguelService;
        this.usuarioService = usuarioService;
        this.veiculoService = veiculoService;
    }

    @GetMapping("/historico")
    public ResponseEntity<List<AluguelResponseDto>> consultarPorCliente(@RequestParam Long id) {
        Usuario usuario = usuarioService.buscarUsuario(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<Aluguel> alugueis = aluguelService.buscarAlugueisPorUsuario(usuario);
        return ResponseEntity.ok(alugueis.stream().map(AluguelResponseDto::new).toList());
    }

    @GetMapping("modelos/{marca}")
    public List<Veiculo> listarModelosPorMarca(@PathVariable String marca) {
        return veiculoService.getModelosPorMarca(marca);
    }

    @PostMapping("/alugar/{id}")
    public ResponseEntity<AluguelResponseDto> alugarVeiculo(@PathVariable Long id, @RequestBody AluguelDto aluguelDto) {
        return ResponseEntity.ok(new AluguelResponseDto(aluguelService.alugarVeiculo(aluguelDto.marca(), aluguelDto.modelo(), id , aluguelDto.dias())));
    }
}
