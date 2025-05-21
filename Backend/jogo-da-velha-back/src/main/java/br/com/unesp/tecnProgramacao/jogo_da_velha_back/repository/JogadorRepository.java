package br.com.unesp.tecnProgramacao.jogo_da_velha_back.repository;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, UUID> {
    Optional<Jogador> findByNickname(String nickName);
    boolean existsByNickname(String nickName);

}
