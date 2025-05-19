package br.com.unesp.tecnProgramacao.jogo_da_velha_back.controller;


import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.Jogador;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.service.JogadorService;
import br.com.unesp.tecnProgramacao.jogo_da_velha_back.util.JogadorUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping("{jogador1}/{jogador2}")
    public String recebeJogadores(@RequestParam("jogador1") String jogador1, @RequestParam("jogador2") String jogador2){
        return this.jogadorService
                .getJogadores(new JogadorUtil().receberJogadores(jogador1, jogador2));
    }

}
