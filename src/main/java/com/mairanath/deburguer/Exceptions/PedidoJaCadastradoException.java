package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PedidoJaCadastradoException extends Exception {
    public PedidoJaCadastradoException(Long id){super(String.format("Pedido Já Lançado!", id));}
}
