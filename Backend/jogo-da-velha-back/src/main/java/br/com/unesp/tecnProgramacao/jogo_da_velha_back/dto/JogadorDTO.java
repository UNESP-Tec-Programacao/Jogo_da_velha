package br.com.unesp.tecnProgramacao.jogo_da_velha_back.dto;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.Jogador;

import java.util.List;
import java.util.UUID;

public class JogadorDTO {
    public UUID id;
    public String nickname;

    public JogadorDTO(){}

    public JogadorDTO(Jogador jogador){
        this.id = jogador.getId();
        this.nickname = jogador.getNickname();
    }

}
