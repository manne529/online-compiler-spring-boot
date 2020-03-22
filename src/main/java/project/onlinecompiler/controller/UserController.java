package project.onlinecompiler.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import project.onlinecompiler.dto.User;
import project.onlinecompiler.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, Errors errors) {
		
		System.out.println(user);
		if (errors.hasErrors()) {
			return "registration";
		} else {
			user = userService.save(user);
			if (user != null) {
				return "redirect:/login";
			} else {
				return "registration";
			}
		}
	}

}
