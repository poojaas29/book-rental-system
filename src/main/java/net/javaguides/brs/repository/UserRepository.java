package net.javaguides.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.brs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
