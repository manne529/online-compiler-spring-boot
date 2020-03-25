package project.onlinecompiler;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "project.onlinecompiler")
@MultipartConfig
public class OnlineCompiler2Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCompiler2Application.class, args);
	}

}
