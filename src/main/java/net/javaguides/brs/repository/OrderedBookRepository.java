package net.javaguides.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.brs.entity.Order;
import net.javaguides.brs.entity.OrderedBook;

@Repository
public interface OrderedBookRepository extends JpaRepository<OrderedBook, Long> {
	
	List<OrderedBook> findByOrder(Order order);
	
	@Query(value = "SELECT sum(orderedBook.book.rent) FROM OrderedBook orderedBook")
    public Long sumRent();


}
