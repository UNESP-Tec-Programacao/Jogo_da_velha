package br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Getter @Setter
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, length = 32)
    private String nickname;


    public Jogador() {

    }
    public Jogador(String nickname) {
        this.nickname = nickname;
    }
}
