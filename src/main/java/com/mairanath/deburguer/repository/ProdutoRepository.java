package repository;
import model.Pedido;
import model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ProdutoRepository extends JpaRepository<Produto, Long> {
        boolean existsById(Long id);

        Produto findById(Produto produto);
    }

