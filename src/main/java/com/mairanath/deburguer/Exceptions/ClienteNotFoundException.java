package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Throwable {
    public ClienteNotFoundException(String cpf){
        String.format("Cliente não encontrado!", cpf);
    }
}
