package br.com.unesp.tecnProgramacao.jogo_da_velha_back.service;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.repository.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.dto.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PartidaService {
    private final PartidaRepository partidaRepository;
    private final JogadorRepository jogadorRepository;

    public PartidaService(PartidaRepository partidaRepository, JogadorRepository jogadorRepository) {
        this.partidaRepository = partidaRepository;
        this.jogadorRepository = jogadorRepository;
    }

    public Partida criar(CriarPartidaDTO dto) {
        Partida partida = new Partida();
        partida.setDataHora(java.time.Instant.now());

        if (dto.vencedorId != null) {
            Jogador vencedor = jogadorRepository.findById(dto.vencedorId)
                    .orElseThrow(() -> new NoSuchElementException("Vencedor inválido"));
            partida.setVencedor(vencedor);
        }

        return partidaRepository.save(partida);
    }


    public Partida atualizarJogada(UUID id, AtualizarPartidaDTO dto) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Partida não encontrada"));

        if (dto.vencedorId != null) {
            Jogador vencedor = jogadorRepository.findById(dto.vencedorId)
                    .orElseThrow(() -> new NoSuchElementException("Vencedor inválido"));
            partida.setVencedor(vencedor);
        } else {
            partida.setVencedor(null);
        }

        return partidaRepository.save(partida);
    }

}