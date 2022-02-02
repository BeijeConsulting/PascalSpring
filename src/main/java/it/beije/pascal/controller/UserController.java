package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.beije.pascal.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	
}