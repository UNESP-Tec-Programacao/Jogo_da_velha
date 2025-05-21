package br.com.unesp.tecnProgramacao.jogo_da_velha_back.service;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.dto.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.*;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.exceptions.JogadorException;
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
        jogadorRepository.save(new Jogador(dto.getNickname()));
        return new JogadorDTO(Objects.requireNonNull(this.jogadorRepository.findByNickname(dto.getNickname()).orElse(null)));
    }

    public boolean existe(String username) {
        return jogadorRepository.existsByNickname(username);
    }

    public JogadorDTO buscar(String username) {
        return new JogadorDTO(this.jogadorRepository
                .findByNickname(username)
                .orElseThrow(() -> new JogadorException("Jogador não encontrado")));
    }
}
