package project.onlinecompiler.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import project.onlinecompiler.dto.User;

@Controller
@CrossOrigin(origins = "*")
public class HomeController {

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@GetMapping(value = { "/", "/index", "/login" })
	public String index(Principal principal) {
		System.out.println(principal);
		return "index";
	}

	@GetMapping("/error")
	public String errorPage() {
		return "error";
	}

}
