package br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter

public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Instant dataHora;

    @ManyToOne
    @JoinColumn(name = "vencedor_id")
    private Jogador vencedor;

}
