package br.com.unesp.tecnProgramacao.jogo_da_velha_back.service;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.dto.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JogadorService {
    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public JogadorDTO criar(CriarJogadorDTO dto) {
        Jogador jogador = new Jogador(dto.getNickname());
        jogadorRepository.save(jogador);
        JogadorDTO retorno = new JogadorDTO();
        retorno.id = jogador.getId();
        retorno.nickname = jogador.getNickname();
        return retorno;
    }

    public boolean existe(String username) {
        return jogadorRepository.existsByNickname(username);
    }

    public JogadorDTO buscar(String username) {
        Jogador jogador = jogadorRepository.findByNickname(username)
                .orElseThrow(() -> new NoSuchElementException("Jogador não encontrado"));
        JogadorDTO dto = new JogadorDTO();
        dto.id = jogador.getId();
        dto.nickname = jogador.getNickname();
        return dto;
    }
}
