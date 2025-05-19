package br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain;

import java.util.List;
import java.util.UUID;

public class Partida {

    private UUID id;
    private List<Jogador> jogadores;

    private Jogador vencedor;

}
