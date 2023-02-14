package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

@Controller
public class UserController {
	private UserService userService;


	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(value = "/users")
		public void getListOfUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
	}
}