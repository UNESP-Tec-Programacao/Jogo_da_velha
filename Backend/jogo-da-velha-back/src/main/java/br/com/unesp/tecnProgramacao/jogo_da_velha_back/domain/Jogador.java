package br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Jogador {

    private UUID id;
    private String nome;

    public Jogador(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
    }

}
