package model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder(toBuilder = true)
    @Table(name = "tb_pedido")
    @Entity
    public class Pedido implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String descricao;

        @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
        @JoinColumn(name = "produtos_descricao")
        private Produto produtos;

        @ManyToOne
        @JoinColumn(name = "cliente_id")
        private Cliente clientes;


    }
