package it.beije.pascal.repository;

import java.util.List;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.model.User;

public interface ShopUserRepository {

	public void save(User user);

	public List<User> findByEmailAndPassword(String email, String password);


}
