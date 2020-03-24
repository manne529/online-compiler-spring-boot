package project.onlinecompiler.util;

import project.onlinecompiler.dto.Role;
import project.onlinecompiler.dto.User;

public class UserTestUtility {

	public static User getUser() {
		User user = new User();
		user.setFullname("rajshekar");
		user.setEmail("rajshekar@gmail.com");
		user.setMobile("9090909090");
		user.setPassword("P@ssw0rd#123");
		user.setConfirmPassword("P@ssw0rd#123");
		return user;
	}

	public static User clone(User user) {

		User newUser = new User();
		newUser.setFullname(user.getFullname());
		newUser.setEmail(user.getEmail());
		newUser.setMobile(user.getMobile());
		newUser.setPassword(user.getPassword());
		newUser.setConfirmPassword(user.getPassword());
		return newUser;
	}

	public static User anotherUser() {
		User user = new User();
		user.setFullname("geetha");
		user.setEmail("geetha@gmail.com");
		user.setMobile("8089089089");
		user.setPassword("P@ssw0rd#123");
		user.setConfirmPassword("P@ssw0rd#123");
		return user;
	}

}
