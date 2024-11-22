package br.com.manutencao.infra;


import br.com.manutencao.dto.MensagemDeErro;
import br.com.manutencao.dto.ValidarCampos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratamentoDeErros {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MensagemDeErro>objetoNaoEncontrado(){
        var erros = new MensagemDeErro(HttpStatus.NOT_FOUND,"Objeto não encontrado !");
        return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validandoCampos(MethodArgumentNotValidException ex){
     var validar = ex.getFieldErrors();
     return ResponseEntity.badRequest().body(validar.stream().map(ValidarCampos::new).toList());
    }
}
