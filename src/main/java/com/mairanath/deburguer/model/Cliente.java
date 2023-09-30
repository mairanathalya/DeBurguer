package com.mairanath.deburguer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Table(name = "tb_cliente")
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cliente")
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<Email> emails;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(name = "cliente_pedido" ,
            joinColumns = @JoinColumn(name = "id_cliente") ,
            inverseJoinColumns = @JoinColumn(name = "id_pedido"))
    private Set<Pedido> pedidos = new HashSet<>();

}
