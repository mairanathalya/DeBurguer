
package resource;
import Exceptions.ClienteJaCadastradoException;
import Exceptions.ClienteNotFoundException;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.ClienteService;

import java.util.List;

@RestController
    @RequestMapping("/cliente")
    public class ClienteController {
        private final ClienteService clienteService;


        @Autowired
        public ClienteController(ClienteService clienteService){
            this.clienteService = clienteService;
        }

        @GetMapping("/clientes")
        public List<Cliente> clientesCadastrados(){
            return this.clienteService.clientesCadastrados();
        }

        @GetMapping("/clientes/{cpf}")
        public Cliente obterDadosCliente(@PathVariable String cpf) throws ClienteNotFoundException {
            return this.clienteService.obterDadosCliente(cpf);
        }

        @PostMapping("/clientes")
        @ResponseStatus(HttpStatus.CREATED)
        public Cliente cadastrarCliente(@Validated @RequestBody Cliente cliente) throws ClienteJaCadastradoException {
            return this.clienteService.cadastrarCliente(cliente);
        }

        @DeleteMapping("/clientes/{cpf}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deletaCliente(@PathVariable String cpf) throws ClienteNotFoundException{
            this.clienteService.deletaCliente(cpf);
        }

        @PutMapping("/clientes/{cpf}")
        public Cliente atualizaCliente(@Validated @RequestBody Cliente cliente, @PathVariable String cpf) throws ClienteNotFoundException{
            return this.clienteService.atualizaCliente(cliente, cpf);
        }

    }

package com.mairanath.deburguer.resource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

}

