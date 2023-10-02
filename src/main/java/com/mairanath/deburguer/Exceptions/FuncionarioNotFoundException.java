package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNotFoundException extends Throwable {
    public FuncionarioNotFoundException(String cpf){
        String.format("Funcionário não encontrado!", cpf);
    }
}
