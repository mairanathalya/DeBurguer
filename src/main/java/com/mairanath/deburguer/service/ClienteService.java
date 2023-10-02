
package service;

import Exceptions.ClienteJaCadastradoException;
import Exceptions.ClienteNotFoundException;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {
    public ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public List<Cliente> clientesCadastrados() {
        return this.clienteRepository.findAll();
    };


    public Cliente obterDadosCliente(String cpf) {
        return this.clienteRepository.findByCpf(cpf);
    }

    @Transactional
    public Cliente cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException {
        if (clienteRepository.existsByCpf(cliente.getCpf())){
            throw new ClienteJaCadastradoException(cliente.getCpf());
        }
        return this.clienteRepository.save(cliente);
    }

    @Transactional
    public void deletaCliente(String cpf) throws ClienteNotFoundException {
        if (!this.clienteRepository.existsByCpf(cpf)){
            throw new ClienteNotFoundException(cpf);
        }
        this.clienteRepository.deleteByCpf(cpf);
    }

    @Transactional
    public Cliente atualizaCliente(Cliente cliente, String cpf) throws ClienteNotFoundException {
            if (!this.clienteRepository.existsByCpf(cpf)){
                throw new ClienteNotFoundException(cpf);
            }
            Cliente clienteAtualizar = this.clienteRepository.findByCpf(cpf);
            if (null!=cliente.getCpf())
                clienteAtualizar.setCpf(cliente.getCpf());
            if (null!=cliente.getNome())
                clienteAtualizar.setNome(cliente.getNome());
            if (null!=cliente.getEmails())
                clienteAtualizar.setEmails(cliente.getEmails());
            if (null!=cliente.getPedidos())
                clienteAtualizar.setPedidos(cliente.getPedidos());
            return this.clienteRepository.save(clienteAtualizar);
        }
=======
package com.mairanath.deburguer.service;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

}
