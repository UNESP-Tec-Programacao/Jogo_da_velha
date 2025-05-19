package br.com.unesp.tecnProgramacao.jogo_da_velha_back.util;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.Jogador;

import java.util.ArrayList;
import java.util.List;

public class JogadorUtil {

    public List<Jogador> receberJogadores(String jogador1, String jogador2){
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador(jogador1));
        jogadores.add(new Jogador(jogador2));
        return jogadores;
    }

}
