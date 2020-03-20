package project.onlinecompiler.controller.user;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import project.onlinecompiler.dto.User;

@Controller
public class UserController {

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, Errors errors) {
		if (errors.hasErrors()) {
			return "registration";
		} else {
			return "redirect:/login";
		}
	}

}
