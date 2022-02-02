package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
