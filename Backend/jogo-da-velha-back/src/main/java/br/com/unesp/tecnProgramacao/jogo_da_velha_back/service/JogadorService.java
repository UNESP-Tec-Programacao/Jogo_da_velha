package br.com.unesp.tecnProgramacao.jogo_da_velha_back.service;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.Jogador;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.exceptions.JogadorException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    static public List<Jogador> jogadores;

    public String getJogadores(List<Jogador> jogadoresList){
        try{
            jogadores = jogadoresList;
            return "Jogadores recebidos com sucesso!";
        }catch (Exception ex){
            throw new JogadorException("Ocorreu um erro ao tentar receber os jogadores");
        }
    }

}
