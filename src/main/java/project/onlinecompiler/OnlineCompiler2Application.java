package project.onlinecompiler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages = "project.onlinecompiler")
public class OnlineCompiler2Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCompiler2Application.class, args);
	}

	

}
