package service;

import Exceptions.PedidoJaCadastradoException;
import Exceptions.PedidoNotFoundException;
import model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PedidoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PedidoService {

    public PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService (PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    public List<Pedido> pedidosLancados() {
        return this.pedidoRepository.findAll();
    }

    public Pedido obterDetalhesPedido(Pedido pedido) {
        return this.pedidoRepository.findById(pedido);
    }

    @Transactional
    public Pedido lancarPedido(Pedido pedido) throws PedidoJaCadastradoException {
        if (pedidoRepository.existsById(pedido.getId())){
            throw new PedidoJaCadastradoException(pedido.getId());
        }
        return this.pedidoRepository.save(pedido);
    }

    @Transactional
    public void deletaPedido(Long id) throws PedidoNotFoundException {
        if (!this.pedidoRepository.existsById(id)){
            throw new PedidoNotFoundException(id);
        }
        this.pedidoRepository.deleteById(id);
    }

    public Pedido atualizaPedido(Pedido pedido, Long id) throws PedidoNotFoundException {
        if (!this.pedidoRepository.existsById(id)){
            throw new PedidoNotFoundException(id);
        }
        Pedido pedidoAtualizar = this.pedidoRepository.findById(pedido);
        if (null!=pedido.getId())
            pedidoAtualizar.setId(pedido.getId());
        if (null!=pedido.getDescricao())
            pedidoAtualizar.setDescricao(pedido.getDescricao());
        if (null!=pedido.getProdutos())
            pedidoAtualizar.setProdutos(pedido.getProdutos());
        if (null!=pedido.getClientes())
            pedidoAtualizar.setClientes(pedido.getClientes());
        return this.pedidoRepository.save(pedidoAtualizar);
    }
    }
