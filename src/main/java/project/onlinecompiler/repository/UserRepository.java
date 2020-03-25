package project.onlinecompiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.onlinecompiler.dto.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
