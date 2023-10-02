
package repository;

import model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
        Funcionario findByCpf(String cpf);
        boolean existsByCpf(String cpf);

        Funcionario deleteByCpf(String cpf);
    }

package com.mairanath.deburguer.repository;

import com.mairanath.deburguer.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}

