package br.com.manutencao.servico;

import br.com.manutencao.dto.ManutencaoDTO;
import br.com.manutencao.dto.ServicosDTO;
import br.com.manutencao.modelo.Manutencao;
import br.com.manutencao.repositorio.ManutencaoRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ManutencaoServ {

    private final ManutencaoRepo repositorio;
    public Manutencao salvarServico(ManutencaoDTO manutencaoDTO){
        var salvando = new Manutencao(manutencaoDTO);
      return repositorio.save(salvando);
    }

    public List<ServicosDTO> listarServicos(){
      var buscar =  repositorio.findAll().stream().map(ServicosDTO::new).toList();
      return buscar;
    }

    public Manutencao buscarPorId(Long id){
        Optional<Manutencao> busca = repositorio.findById(id);
        return busca.orElseThrow(NoSuchElementException::new);
    }

    public void excluir(Long id){
        repositorio.deleteById(id);
    }

    @Transactional
    public Manutencao atualizarServicos(ServicosDTO servicosDTO){
        var atualizar = repositorio.getReferenceById(servicosDTO.id());
        atualizar.atualizando(servicosDTO);
        return atualizar;
    }

    public List<ServicosDTO> buscarPorNome(String nome){
     return repositorio.findByNome(nome.trim().toUpperCase());

    }

}
