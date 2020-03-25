package project.onlinecompiler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

	@GetMapping("/home")
	public String homepage() {
		return "trainerhome";
	}

}
