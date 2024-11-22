package br.com.manutencao.repositorio;

import br.com.manutencao.dto.ManutencaoDTO;
import br.com.manutencao.dto.ServicosDTO;
import br.com.manutencao.modelo.Manutencao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManutencaoRepo extends JpaRepository<Manutencao,Long>{
    @Query(value = "select m from Manutencao m where upper(trim(m.nome)) like %?1% ")
    List<ServicosDTO> findByNome(String nome);
}
