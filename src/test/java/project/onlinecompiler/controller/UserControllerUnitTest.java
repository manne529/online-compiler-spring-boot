package project.onlinecompiler.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;

import project.onlinecompiler.OnlineCompiler2Application;
import project.onlinecompiler.dto.User;
import project.onlinecompiler.repository.UserRepository;
import project.onlinecompiler.service.UserService;
import project.onlinecompiler.util.UserTestUtility;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { OnlineCompiler2Application.class, UserController.class })
@AutoConfigureMockMvc
public class UserControllerUnitTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Autowired
	private MockMvc mockMvc;

	private User user;

	@BeforeEach
	public void setUp() {
		user = UserTestUtility.getUser();
	}

	@Test
	public void testUserRegister() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/register").flashAttr("user", this.user)).andExpect(redirectedUrl("/login"));

		when(userService.save(this.user)).thenReturn(new User());

		verify(userService, times(1)).save(this.user);

	}

}
