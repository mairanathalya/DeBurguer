package repository;
import model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface PedidoRepository extends JpaRepository<Pedido, Long> {

        boolean existsById(Long id);

        Pedido findById(Pedido pedido);
}
