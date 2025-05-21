package br.com.unesp.tecnProgramacao.jogo_da_velha_back.repository;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JogadorRepository extends JpaRepository<Jogador, UUID> {
    Optional<Jogador> findByNickname(String nickName);
    boolean existsByNickname(String nickName);

}
