package br.com.manutencao.dto;

import br.com.manutencao.enums.Pagamento;
import br.com.manutencao.enums.Servicos;
import br.com.manutencao.enums.Status;
import br.com.manutencao.modelo.Manutencao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
public class ManutencaoDTO{
   private Long id;
   private Integer ordem =  new Random().nextInt(1000 + 1);
   @NotBlank(message = "não pode estar em branco!")
   private String nome;
   @NotBlank(message = "não pode estar em branco!")
   private String cpf;
   @NotBlank(message = "não pode estar em branco!")
   private String fone;
   @NotBlank(message = "não pode estar em branco!")
   private String marca;
   @NotBlank(message = "não pode estar em branco!")
   private String modelo;
   @NotBlank(message = "não pode estar em branco!")
   private Integer btus;
   @Enumerated(EnumType.STRING)
   private Servicos servicos;
   private String descricao;
   private Double total;
   @Enumerated(EnumType.STRING)
   private Status status;
   @Enumerated(EnumType.STRING)
   private Pagamento pagamento;



   public ManutencaoDTO(Manutencao criar) {
     this.id = criar.getId();
     this.ordem = criar.getOrdem();
     this.nome = criar.getNome();
     this.cpf = criar.getCpf();
     this.fone = criar.getFone();
     this.marca = criar.getMarca();
     this.modelo = criar.getModelo();
     this.btus = criar.getBtus();
     this.servicos = criar.getServicos();
     this.descricao = criar.getDescricao();
     this.total = criar.getTotal();
     this.status = criar.getStatus();
     this.pagamento = criar.getPagamento();
   }
}
