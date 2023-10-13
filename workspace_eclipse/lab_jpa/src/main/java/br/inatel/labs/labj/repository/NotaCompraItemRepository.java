package br.inatel.labs.labj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.inatel.labs.labjpa.entity.NotaCompraItem;

@Repository
public interface NotaCompraItemRepository extends JpaRepository<NotaCompraItem, Long> {

}
