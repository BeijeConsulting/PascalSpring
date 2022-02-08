package it.beije.pascal.controller.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.model.User;
import it.beije.pascal.repository.shop.UserRepository;

@RestController
@RequestMapping("api")
public class UserControl {
	
	@Autowired
	public UserRepository userRepository;
	
	@RequestMapping(value = "/utos", method = RequestMethod.GET)
	public List<User> users(){
		
		System.out.println("API GET Users");
		
		List<User> u = new ArrayList<>();
		
		u = userRepository.findAll();
		
		System.out.println("Numero di utenti : " + u.size());
		
		return u;
	}
	
	@PostMapping(value ="/uto")
	public User user(@RequestBody User u) {
		
		System.out.println("API POST User : " + u);
		
		userRepository.save(u);
		
		return u;
	}
	
	@PutMapping(value = "/utos/{id}")
	public User insert(@PathVariable Integer id) {
		
		System.out.println("Ricerca Contatto per id. id = " +id);
		
		User u = null;
		
		Optional<User> c = userRepository.findById(id);		
			
			if (c.isPresent()) {
				u = c.get();
//				c.setCognome(contatto.getCognome());
//				c.setNome(contatto.getNome());
				//....
				BeanUtils.copyProperties(c, u);
				userRepository.save(u);
			} else throw new RuntimeException("id errato");		
		
		return u;
	}
	
	

}
