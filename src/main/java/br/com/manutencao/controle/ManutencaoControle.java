package br.com.manutencao.controle;


import br.com.manutencao.dto.ManutencaoDTO;
import br.com.manutencao.dto.ServicosDTO;
import br.com.manutencao.servico.ManutencaoServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("ar")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ManutencaoControle {


    private final ManutencaoServ servico;


    @PostMapping
    @Operation(summary = "Endpoint responsável por cadastrar um serviço.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<ManutencaoDTO>salvarServico(@RequestBody @Valid ManutencaoDTO manutencaoDTO){
        var criar = servico.salvarServico(manutencaoDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(criar.getId()).toUri();
        return ResponseEntity.created(uri).body(new ManutencaoDTO(criar));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável por buscar todos os serviços")
    @ApiResponse(responseCode = "201",description = "sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<ServicosDTO>>buscarServicos(){
        var buscar = servico.listarServicos();
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("{id}")
    @Operation(summary = "Endpoint responsável por buscar um serviço pelo id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<ServicosDTO>buscarPorId(@PathVariable Long id){
        var busca = servico.buscarPorId(id);
        return ResponseEntity.ok().body(new ServicosDTO(busca));
    }


    @DeleteMapping("{id}")
    @Operation(summary = "Endpoint responsável por deletar um serviço.")
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluir(@PathVariable Long id){
        servico.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Operation(summary = "Endpoint responsável por atualizar um serviço.")
    @ApiResponse(responseCode = "200",description = "sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<ServicosDTO>atualizarServicos(@RequestBody ServicosDTO servicosDTO){
        var atualize = servico.atualizarServicos(servicosDTO);
        return ResponseEntity.ok().body(new ServicosDTO(atualize));
    }

    @GetMapping("buscarNome")
    @Operation(summary = "Endpoint responsável por buscar um serviço pelo nome do cliente.")
    @ApiResponse(responseCode = "200",description = "sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<ServicosDTO>>buscarNome(@RequestParam("nome") String nome){
        var buscar = servico.buscarPorNome(nome);
        return ResponseEntity.ok(buscar);
    }
}
