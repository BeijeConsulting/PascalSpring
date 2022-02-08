package it.beije.pascal.restcontroller;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
	public List<User> getList(){
		System.out.println("GET user");
		
		List<User> users = userService.getList();
		
		return users;
	}
	
	@GetMapping(value="/users/{id}")
	public User getDetail(@PathVariable Integer id) {
		
		User user = userService.getDetail(id);
		
		return user;
		
	}
	
	@PostMapping(value = "/user")
	public User insert(@RequestBody User user) {
		User user2 = userService.insert(user);
		
		return user2;
	}
	
	@PutMapping(value="/user/{id}")
	public User insert(@RequestBody User user, @PathVariable Integer id) {
		
		User u = null;
		if(user.getId() != null && user.getId() == id) {
			u = userService.getDetail(id);
			BeanUtils.copyProperties(user, u);
			userService.insert(u);
		}
		return u;
	}
	
	@DeleteMapping(value="/user/{id}")
	public Boolean insert(@PathVariable Integer id) {
		User u = userService.getDetail(id);
		if(u != null) {
			return userService.delete(u);
		}
		return false;
	}

}
