package project.onlinecompiler.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.onlinecompiler.OnlineCompiler2Application;
import project.onlinecompiler.dto.User;
import project.onlinecompiler.util.UserTestUtility;

@SpringBootTest(classes = OnlineCompiler2Application.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	private User user;

	@BeforeEach
	public void setUp() {
		user = UserTestUtility.getUser();
	}

	@AfterEach
	public void tearDown() {
		userService.deleteAll();
	}

	@Test
	public void testSaveUser() {
		assertThat(userService.save(user)).isNotNull();
	}

	@Test
	public void testSaveUserWithNullValues() {
		user.setFullname(null);
		assertThat(userService.save(user)).isNull();
	}

	@Test
	public void testSaveUserWithDuplicateValues() {
		userService.save(user);
		User user = UserTestUtility.clone(this.user);
		assertThat(userService.save(user)).isNull();
	}

	@Test
	public void testGetUserWithId() {
		userService.save(user);
		User user = userService.getUser(this.user.getId());
		assertThat(user).isNotNull();
		assertThat(user).extracting(User::getEmail).isEqualTo(this.user.getEmail());
	}

	@Test
	public void testGetUserWithIdFailure() {
		assertThat(userService.getUser(101)).isNull();
	}

	@Test
	public void testGetAllUsers() {
		userService.save(user);
		userService.save(UserTestUtility.anotherUser());
		List<User> users = userService.getUser();
		assertThat(users).isNotNull();
		assertThat(users).hasSize(2);
	}

}
