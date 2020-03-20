package project.onlinecompiler.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@Pattern(regexp = "[a-z\\s]{5,}", message = "Min 5 characters")
	private String fullname;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Enter a valid mobile number")
	private String mobile;

	@Column(nullable = false, unique = true)
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$", message = "Min 8 characters, min 1 small alphabet, min 1 captical alphabet, min 1 numeric, min 1 special character")
	private String password;

	@Column(nullable = false, unique = true)
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$", message = "Min 8 characters, min 1 small alphabet, min 1 captical alphabet, min 1 numeric, min 1 special character")
	@Transient
	private String confirmPassword;
	@Enumerated(EnumType.STRING)
	private Role role;

}
