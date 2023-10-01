package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProdutoJaCadastradoException extends Exception{
    public ProdutoJaCadastradoException(Long id){super(String.format("Produto Já Cadastrado!", id));}
}
