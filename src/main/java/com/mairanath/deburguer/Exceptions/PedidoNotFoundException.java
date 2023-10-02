package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoNotFoundException extends Exception {
    public PedidoNotFoundException(Long id){
        String.format("Pedido não encontrado!", id);
    }
}
