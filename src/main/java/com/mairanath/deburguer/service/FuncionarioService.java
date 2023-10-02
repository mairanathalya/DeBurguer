
package service;

import Exceptions.ClienteJaCadastradoException;
import Exceptions.ClienteNotFoundException;
import Exceptions.FuncionarioJaCadastradoException;
import Exceptions.FuncionarioNotFoundException;
import model.Cliente;
import model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FuncionarioRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FuncionarioService {

    public FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService (FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }
    public List<Funcionario> funcionariosCadastrados() {
        return this.funcionarioRepository.findAll();
    }

    public Funcionario obterDadosFuncionarios(String cpf) {
        return this.funcionarioRepository.findByCpf(cpf);
    }

    @Transactional
    public Funcionario cadastrarFuncionarios(Funcionario funcionario) throws FuncionarioJaCadastradoException {
        if (funcionarioRepository.existsByCpf(funcionario.getCpf())){
            throw new FuncionarioJaCadastradoException(funcionario.getCpf());
        }
        return this.funcionarioRepository.save(funcionario);
    }

    @Transactional
    public void deletaFuncionarios(String cpf) throws FuncionarioNotFoundException {
        if (!this.funcionarioRepository.existsByCpf(cpf)){
            throw new FuncionarioNotFoundException(cpf);
        }
        this.funcionarioRepository.deleteByCpf(cpf);
    }


    public Funcionario atualizaFuncionario(Funcionario funcionario, String cpf) throws FuncionarioNotFoundException {
        if (!this.funcionarioRepository.existsByCpf(cpf)){
            throw new FuncionarioNotFoundException(cpf);
        }
        Funcionario funcionarioAtualizar = this.funcionarioRepository.findByCpf(cpf);
        if (null!=funcionario.getCpf())
            funcionarioAtualizar.setCpf(funcionario.getCpf());
        if (null!=funcionario.getNome())
            funcionarioAtualizar.setNome(funcionario.getNome());
        if (null!=funcionario.getEmails())
            funcionarioAtualizar.setEmails(funcionario.getEmails());
        return this.funcionarioRepository.save(funcionarioAtualizar);
    }
=======
package com.mairanath.deburguer.service;

import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

}
