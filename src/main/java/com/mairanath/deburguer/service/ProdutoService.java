
package service;

import Exceptions.PedidoJaCadastradoException;
import Exceptions.PedidoNotFoundException;
import Exceptions.ProdutoJaCadastradoException;
import Exceptions.ProdutoNotFoundException;
import model.Pedido;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {
    public ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService (ProdutoRepository produtoRepository){
       this.produtoRepository = produtoRepository;
    }

    public List<Produto> produtosCadastrado() {
        return this.produtoRepository.findAll();
    }

    public Produto obterDadosProdutos(Produto produto) {
        return this.produtoRepository.findById(produto);
    }

    @Transactional
    public Produto cadastrarProdutos(Produto produto) throws ProdutoJaCadastradoException {
        if (produtoRepository.existsById(produto.getId())){
            throw new ProdutoJaCadastradoException(produto.getId());
        }
        return this.produtoRepository.save(produto);
    }
    @Transactional
    public void deletaProduto(Long id) throws ProdutoNotFoundException{
            if (!this.produtoRepository.existsById(id)){
                throw new ProdutoNotFoundException(id);
            }
            this.produtoRepository.deleteById(id);
    }


    public Produto atualizaProduto(Produto produto, Long id) throws ProdutoNotFoundException {
        if (!this.produtoRepository.existsById(id)){
            throw new ProdutoNotFoundException(id);
        }
        Produto produtoAtualizar = this.produtoRepository.findById(produto);
        if (null!=produtoAtualizar.getId())
            produtoAtualizar.setId(produto.getId());
        if (null!= produtoAtualizar.getNome())
            produtoAtualizar.setNome(produto.getNome());
        return this.produtoRepository.save(produtoAtualizar);
    }
}

=======
package com.mairanath.deburguer.service;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
}
