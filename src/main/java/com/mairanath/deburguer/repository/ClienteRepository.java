
package repository;
import model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ClienteRepository extends JpaRepository<Cliente, Long> {

        boolean existsByCpf(String cpf);
        Cliente findByCpf(String cpf);

        Cliente deleteByCpf(String cpf);
    }

package com.mairanath.deburguer.repository;

import com.mairanath.deburguer.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}

