package br.com.unesp.tecnProgramacao.jogo_da_velha_back.dto;


import java.util.List;
import java.util.UUID;

public class AtualizarPartidaDTO {
    public List<String> tabuleiro;
    public UUID vezId;
    public UUID vencedorId;
}
