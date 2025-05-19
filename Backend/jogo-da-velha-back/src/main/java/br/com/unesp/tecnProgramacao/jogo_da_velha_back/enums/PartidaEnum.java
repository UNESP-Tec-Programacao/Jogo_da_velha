package br.com.unesp.tecnProgramacao.jogo_da_velha_back.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum PartidaEnum {

    (1, "VENCEDOR");

    private Integer valor;
    private String resultado;


    PartidaEnum(Integer valor, String resultado) {
        this.valor = valor;
        this.resultado = resultado;
    }
}
