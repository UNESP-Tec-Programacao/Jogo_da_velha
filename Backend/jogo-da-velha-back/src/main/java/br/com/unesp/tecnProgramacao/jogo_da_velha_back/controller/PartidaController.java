package br.com.unesp.tecnProgramacao.jogo_da_velha_back.controller;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.dto.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.Partida;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/public/partidas")
public class PartidaController {
    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }
    @GetMapping
    public ResponseEntity<List<Partida>> ler() {
        return ResponseEntity.ok(partidaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Partida> criar(@RequestBody CriarPartidaDTO dto) {
        return ResponseEntity.ok(partidaService.criar(dto));
    }

    @PutMapping("/{id}/jogada")
    public ResponseEntity<Partida> atualizar(@PathVariable UUID id, @RequestBody AtualizarPartidaDTO dto) {
        return ResponseEntity.ok(partidaService.atualizarJogada(id, dto));
    }

    @GetMapping("/{id}/tabuleiro")
    public ResponseEntity<List<String>> obterTabuleiro(@PathVariable UUID id) {
        return ResponseEntity.ok(partidaService.obterTabuleiro(id));
    }

}
