package project.onlinecompiler.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	@Pattern(regexp = "[a-z]{5,}", message = "Username must be only small alphabet, Min 5 characters")
	private String username;

	@Column(nullable = false, unique = false)
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$", message = "Min 8 characters, min 1 small alphabet, min 1 captical alphabet, min 1 numeric, min 1 special character")
	private String password;

	@Column(nullable = false, unique = false)
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$", message = "Min 8 characters, min 1 small alphabet, min 1 captical alphabet, min 1 numeric, min 1 special character")
	@Transient
	private String confirmPassword;

	private boolean enabled;

	@Column(nullable = false, unique = false)
	private String role;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Question> questionList;
}
