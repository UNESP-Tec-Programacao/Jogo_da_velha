package br.com.unesp.tecnProgramacao.jogo_da_velha_back.service;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.repository.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Partida> findAll() {
        return partidaRepository.findAll();
    }

    public Partida criar(CriarPartidaDTO dto) {
        Jogador jogadorX = jogadorRepository.findById(dto.jogadorXId)
                .orElseThrow(() -> new NoSuchElementException("Jogador X não encontrado"));

        Partida partida = new Partida();
        partida.setDataHora(java.time.Instant.now());
        partida.setJogadorX(jogadorX);
        partida.setJogadorO(null); // ainda esperando
        partida.setTabuleiro(dto.tabuleiro);
        partida.setVencedor(null);
        partida.setVez(jogadorX); // jogador X sempre começa

        return partidaRepository.save(partida);
    }

    public List<String> obterTabuleiro(UUID id) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partida não encontrada"));
        return partida.getTabuleiro();
    }

    public Partida entrarComoJogadorO(UUID partidaId, UUID jogadorOId) {
        Partida partida = partidaRepository.findById(partidaId)
                .orElseThrow(() -> new NoSuchElementException("Partida não encontrada"));

        if (partida.getJogadorO() != null) {
            throw new IllegalStateException("Essa partida já tem dois jogadores.");
        }

        Jogador jogadorO = jogadorRepository.findById(jogadorOId)
                .orElseThrow(() -> new NoSuchElementException("Jogador O não encontrado"));

        partida.setJogadorO(jogadorO);
        return partidaRepository.save(partida);
    }

    public List<Partida> buscarPartidasEmAberto() {
        return partidaRepository.findByJogadorOIsNull();
    }


    public Partida atualizarJogada(UUID id, AtualizarPartidaDTO dto) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Partida não encontrada"));

        Jogador jogadorDaVez = jogadorRepository.findById(dto.vezId)
                .orElseThrow(() -> new NoSuchElementException("Jogador X não encontrado"));
        partida.setTabuleiro(dto.tabuleiro);
        partida.setVez(jogadorDaVez);

        String vencedorSimbolo = verificarVencedor(dto.tabuleiro);
        if (vencedorSimbolo != null) {
            UUID vencedorId = vencedorSimbolo.equals("X") ? partida.getJogadorX().getId() : partida.getJogadorO().getId();
            Jogador vencedor = jogadorRepository.findById(vencedorId)
                    .orElseThrow(() -> new NoSuchElementException("Vencedor inválido"));
            partida.setVencedor(vencedor);
        } else {
            partida.setVencedor(null);
        }

        return partidaRepository.save(partida);
    }

    private String verificarVencedor(List<String> tabuleiro) {
        int[][] combinacoes = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // linhas
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // colunas
                {0, 4, 8}, {2, 4, 6}             // diagonais
        };

        for (int[] c : combinacoes) {
            String a = tabuleiro.get(c[0]);
            String b = tabuleiro.get(c[1]);
            String cVal = tabuleiro.get(c[2]);

            if (!a.isEmpty() && a.equals(b) && a.equals(cVal)) {
                return a; // "X" ou "O"
            }
        }

        return null;
    }


}