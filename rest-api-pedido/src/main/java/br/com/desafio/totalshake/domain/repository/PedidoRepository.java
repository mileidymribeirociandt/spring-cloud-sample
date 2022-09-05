package br.com.desafio.totalshake.domain.repository;

import br.com.desafio.totalshake.domain.entity.Pedido;
import br.com.desafio.totalshake.domain.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM pedido;", nativeQuery = true)
    //TODO
    List<Pedido> findAll(Pageable pageable);

    @Query(value = "UPDATE pedido SET status = ?2 WHERE id = ?1 AND status != ?2", nativeQuery = true)
    @Modifying
    void updatePedidoStatus(Long id, String status);
}
