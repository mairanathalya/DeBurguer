package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FuncionarioJaCadastradoException extends Exception {
    public FuncionarioJaCadastradoException(String cpf){super(String.format("Funcionário Já Cadastrado!", cpf));}
}
