package project.onlinecompiler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import project.onlinecompiler.dto.User;

@Controller
public class HomeController {

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@GetMapping(value = { "/", "/index", "/login" })
	public String index() {
		return "index";
	}

}
