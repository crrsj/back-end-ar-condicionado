package br.com.manutencao.modelo;


import br.com.manutencao.dto.ManutencaoDTO;
import br.com.manutencao.dto.ServicosDTO;
import br.com.manutencao.enums.Pagamento;
import br.com.manutencao.enums.Servicos;
import br.com.manutencao.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ordem = new Random().nextInt(1000 + 1) ;
    private String nome;
    private String cpf;
    private String fone;
    private String marca;
    private String modelo;
    private Integer btus;
    private Servicos servicos;
    private String descricao;
    private Double total;
    private Status status;
    private Pagamento pagamento;

    public Manutencao(ManutencaoDTO manutencaoDTO) {
        this.id = manutencaoDTO.getId();
        this.ordem = manutencaoDTO.getOrdem();
        this.nome = manutencaoDTO.getNome();
        this.cpf = manutencaoDTO.getCpf();
        this.fone = manutencaoDTO.getFone();
        this.marca = manutencaoDTO.getMarca();
        this.modelo = manutencaoDTO.getModelo();
        this.btus = manutencaoDTO.getBtus();
        this.servicos = manutencaoDTO.getServicos();
        this.descricao = manutencaoDTO.getDescricao();
        this.total = manutencaoDTO.getTotal();
        this.status = manutencaoDTO.getStatus();
        this.pagamento = manutencaoDTO.getPagamento();
    }


    public void atualizando(ServicosDTO servicosDTO) {
        if(servicosDTO.nome() != null){
            this.nome = servicosDTO.nome();
        }
        if(servicosDTO.fone() != null){
            this.servicos = servicosDTO.servicos();
        }
        if (servicosDTO.total() != null){
            this.total = servicosDTO.total();
        }
        if(servicosDTO.status() != null){
            this.status = servicosDTO.status();
        }
        if(servicosDTO.pagamento() != null){
            this.pagamento = servicosDTO.pagamento();
        }
    }
}
