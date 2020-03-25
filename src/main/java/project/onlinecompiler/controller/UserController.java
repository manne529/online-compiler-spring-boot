package project.onlinecompiler.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import project.onlinecompiler.dto.User;
import project.onlinecompiler.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, Errors errors) {

		if (errors.hasErrors()) {
			return "registration";
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user = userService.save(user);
			if (user != null) {
				return "redirect:/login";
			} else {
				return "registration";
			}
		}
	}

	@GetMapping("/homepage")
	public String homepage(Principal principal, HttpSession session) {
		if (principal != null) {
			User user = userService.getUser(principal.getName());
			session.setAttribute("user", user);
			if (user.getRole().equals("ROLE_TRAINER")) {
				return "redirect:/trainer/home";
			} else {
				return "redirect:/std/home";
			}
		} else {
			return "redirect:/";
		}
	}

}
