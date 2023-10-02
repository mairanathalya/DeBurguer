
package resource;

import Exceptions.PedidoJaCadastradoException;
import Exceptions.PedidoNotFoundException;
import model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.PedidoService;

import java.util.List;
import java.util.Optional;

package com.mairanath.deburguer.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/pedidos")
    public List<Pedido> pedidosLancados(){
        return this.pedidoService.pedidosLancados();
    }

    @GetMapping("pedidos/{id}")
    public Pedido obterDetalhesPedido(@PathVariable Long id){
        return this.pedidoService.obterDetalhesPedido(id);
    }

    @PostMapping("/pedidos")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido lancarPedido(@Validated @RequestBody Pedido pedido) throws PedidoJaCadastradoException {
        return this.pedidoService.lancarPedido(pedido);
    }
    @DeleteMapping("/pedidos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaPedido(@PathVariable Long id) throws PedidoNotFoundException {
        this.pedidoService.deletaPedido(id);
    }
    @PutMapping("/pedidos/{id}")
    public Pedido atualizaPedido(@Validated @RequestBody Pedido pedido, Long id) throws PedidoNotFoundException {
        return this.pedidoService.atualizaPedido(pedido, id);
    }

}

}

