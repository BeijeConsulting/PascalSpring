package it.beije.pascal.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.User;
import it.beije.pascal.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService userService;

//	@RequestMapping(value = "/ecommerce", method = RequestMethod.GET)
//	public String getEcommerce(Model model) {
//		return "ecommerce/ecommerce";
//	}
//
//	@RequestMapping(value = "/registration_form", method = RequestMethod.GET)
//	public String getRegistrationForm() {
//		return "ecommerce/registration";
//	}

	@PostMapping(value = "/saveUser") // CREATE
	public User save(@RequestBody User user) { // RequestBody vuole l'oggetto passato sotto forma di json nel body
		userService.save(user);
		return user;
	}

	@GetMapping(value = "/getUser/{id}") // READ
	public User findById(@PathVariable Integer id) { // PathVariable si utilizza per indicare il percorso nell'url		
		User user = userService.findById(id);
		return user;
	}
	
	@GetMapping(value = "/leggiUtente") // READ
	public User getUser(Integer id) { // leggiUtente?id=2 		
		User user = userService.findById(id);
		return user;
	}

	@PutMapping(value = "/updateUser/{id}") // UPDATE
	public User update(@PathVariable Integer id) { // PathVariable si utilizza per indicare il percorso nell'url
		User user = userService.findById(id);
		if (user != null) {
			user.setEmail("modificato");
			user.setName(null);
			user.setPassword("modificato");
			user.setSurname("modificato");
			userService.save(user);
		}
		return user;
	}

	@DeleteMapping(value = "/deleteUser/{id}") // DELETE
	public Boolean delete(@PathVariable Integer id) {
		return userService.delete(id);
	}

}
