package br.com.unesp.tecnProgramacao.jogo_da_velha_back.repository;

import br.com.unesp.tecnProgramacao.jogo_da_velha_back.domain.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PartidaRepository extends JpaRepository<Partida, UUID> {
}
