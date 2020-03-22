package project.onlinecompiler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.onlinecompiler.dto.User;
import project.onlinecompiler.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getUser(Integer id) {
		try {
			return userRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	public List<User> getUser() {
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteAll() {
		try {
			userRepository.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
