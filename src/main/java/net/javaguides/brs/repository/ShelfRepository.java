package net.javaguides.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.brs.entity.Order;
import net.javaguides.brs.entity.Shelf;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
	List<Shelf> findByUser(Order order);

}
