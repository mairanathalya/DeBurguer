package resource;


import Exceptions.FuncionarioJaCadastradoException;
import Exceptions.FuncionarioNotFoundException;
import model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> funcionariosCadastrados(){
        return this.funcionarioService.funcionariosCadastrados();
    }

    @GetMapping("/funcionarios/{cpf}")
    public Funcionario obterDadosFuncionarios(@PathVariable String cpf) throws FuncionarioNotFoundException {
        return this.funcionarioService.obterDadosFuncionarios(cpf);
    }

    @PostMapping("/funcionarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario cadastrarFuncionarios(@Validated @RequestBody Funcionario funcionario) throws FuncionarioJaCadastradoException {
        return this.funcionarioService.cadastrarFuncionarios(funcionario);
    }

    @DeleteMapping("/funcionarios/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaFuncionarios(@PathVariable String cpf) throws FuncionarioNotFoundException{
        this.funcionarioService.deletaFuncionarios(cpf);
    }

    @PutMapping("/funcionarios/{cpf}")
    public Funcionario atualizaFuncionario(@Validated @RequestBody Funcionario funcionario, @PathVariable String cpf) throws FuncionarioNotFoundException{
        return this.funcionarioService.atualizaFuncionario(funcionario, cpf);
    }
}
