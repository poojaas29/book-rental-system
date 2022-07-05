package net.javaguides.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.brs.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
