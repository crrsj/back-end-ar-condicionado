package br.com.manutencao.dto;

import br.com.manutencao.enums.Pagamento;
import br.com.manutencao.enums.Servicos;
import br.com.manutencao.enums.Status;
import br.com.manutencao.modelo.Manutencao;
import org.hibernate.usertype.StaticUserTypeSupport;

import java.util.Random;

public record ServicosDTO(
        Long id,
        Integer ordem,
        String nome,
        String fone,
        String modelo,

        Servicos servicos,
        String descricao,
        Double total,
        Status status,
        Pagamento pagamento) {

        public ServicosDTO(Manutencao manutencao){
            this(
                    manutencao.getId(),
                    manutencao.getOrdem(),
                    manutencao.getNome(),
                    manutencao.getFone(),
                    manutencao.getModelo(),
                    manutencao.getServicos(),
                    manutencao.getDescricao(),
                    manutencao.getTotal(),
                    manutencao.getStatus(),
                    manutencao.getPagamento());
        }
}
