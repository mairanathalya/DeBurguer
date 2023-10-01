package resource;


import Exceptions.ProdutoJaCadastradoException;
import Exceptions.ProdutoNotFoundException;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public List<Produto> produtosCadastrados(){
        return this.produtoService.produtosCadastrado();
    }
    @GetMapping("/produtos/{id}")
    public Produto obterDadosProdutos(@PathVariable Produto produto){
        return this.produtoService.obterDadosProdutos(produto);
    }
    @PostMapping("/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProdutos(@Validated @RequestBody Produto produto) throws ProdutoJaCadastradoException {
        return this.produtoService.cadastrarProdutos(produto);
    }
    @DeleteMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaProduto(@PathVariable Long id) throws ProdutoNotFoundException {
        this.produtoService.deletaProduto(id);
    }
    @PutMapping("/produtos/{id}")
    public Produto atualizaProduto(@Validated @RequestBody Produto produto, @PathVariable Long id) throws ProdutoNotFoundException {
        return this.produtoService.atualizaProduto(produto, id);
    }

}
