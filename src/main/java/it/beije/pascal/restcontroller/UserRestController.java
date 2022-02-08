package it.beije.pascal.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.User;
import it.beije.pascal.service.UserService;

@RestController
@RequestMapping("api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public List<User> getItems() {
		System.out.println("GET users");

		List<User> users = userService.findAll();

		return users;
	}

	@GetMapping(value = "/user/{id}")
	public User getItemDetails(@PathVariable Integer id) {
		System.out.println("GET user detail");

		Optional<User> o = userService.findById(id);

		return o.isPresent() ? o.get() : null;
	}

	@PostMapping(value = "/user")
	public User addNewProduct(@RequestBody User user) {
		System.out.println("POST new user");

		System.out.println(user);

		User u = userService.register(user);

		return u;
	}

	@PutMapping(value = "/user/{id}")
	public User modifyProduct(@PathVariable Integer id, @RequestBody User user) {
		System.out.println("update user");

		Optional<User> o = userService.findById(id);

		if (o.isPresent()) {
			User p = o.get();
			return userService.update(p, user, id);
		}

		return null;
	}

	@DeleteMapping(value = "/user/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		System.out.println("Delete user");

		Optional<User> o = userService.findById(id);

		if (o.isPresent()) {
			User p = o.get();
			userService.delete(p);
		}
	}

}
