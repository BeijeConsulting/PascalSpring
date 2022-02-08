package it.beije.pascal.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.model.User;
import it.beije.pascal.repository.RubricaRepository;
import it.beije.pascal.repository.UserRepository;
import it.beije.pascal.service.RubricaService;
import it.beije.pascal.service.UserService;


//@Controller
@RestController
@RequestMapping("api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

//	@RequestMapping(value = "/contatti", method = RequestMethod.GET)
//	public @ResponseBody List<Contatto> getList(@RequestParam(value = "surname", required = false) String cognome) {
	@GetMapping(value = "/users")
	public List<User> getList(@RequestParam(value = "surname", required = false) String cognome) {
		System.out.println("GET contatti");
		
		List<User> users = userService.getList(cognome);

		System.out.println("contatti : " + users.size());
		
		return users;
	}
	
//	@RequestMapping(value = "/contatto/{id}", method = RequestMethod.GET)
//	public @ResponseBody Contatto getDetail(@PathVariable Integer id) {
	@GetMapping(value = "/user/{id}")
	public User getDetail(@PathVariable Integer id) {
		System.out.println("GET contatto");
		
		Optional<User> o = userRepository.findById(id);
		
		return o.isPresent() ? o.get() : null;
	}
	
	@PostMapping(value = "/user")
	public User insert(@RequestBody User user) {
		System.out.println("POST contatto : " + user);
		
		userRepository.save(user);
		
		return user;
	}

	@PutMapping(value = "/user/{id}")
	public User insert(@RequestBody User user, @PathVariable Integer id) {
		System.out.println("PUT contatto : " + user);
		
		User c = null;
		if (user.getId() != null && user.getId() == id) {
			Optional<User> o = userRepository.findById(id);
			
			if (o.isPresent()) {
				c = o.get();
//				c.setCognome(contatto.getCognome());
//				c.setNome(contatto.getNome());
				//....
				BeanUtils.copyProperties(user, c);
				userRepository.save(c);
			} else throw new RuntimeException("id errato");
		}		
		
		return c;
	}

	@DeleteMapping(value = "/user/{id}")
	public Boolean insert(@PathVariable Integer id) {
		System.out.println("DELETE user : " + id);
		
		Optional<User> o = userRepository.findById(id);
			
		if (o.isPresent()) {
				userRepository.delete(o.get());
		} else throw new RuntimeException("id errato");
				
		return Boolean.TRUE;
	}

}