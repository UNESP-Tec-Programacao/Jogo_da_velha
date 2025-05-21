package br.com.unesp.tecnProgramacao.jogo_da_velha_back.controller;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.dto.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/public/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> ler() {
        return ResponseEntity.ok(jogadorService.findAll());
    }
    @PostMapping
    public ResponseEntity<JogadorDTO> criar(@RequestBody CriarJogadorDTO dto) {
        return ResponseEntity.ok(jogadorService.criar(dto));
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existe(@RequestParam String username) {
        return ResponseEntity.ok(jogadorService.existe(username));
    }

    @GetMapping("/{username}")
    public ResponseEntity<JogadorDTO> buscar(@PathVariable String username) {
        return ResponseEntity.ok(jogadorService.buscar(username));
    }
}