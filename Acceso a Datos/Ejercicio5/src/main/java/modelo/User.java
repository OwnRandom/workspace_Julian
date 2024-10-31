package modelo;

import java.time.LocalDate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Long userId;
	private String username;
	private String password;
	private String userEmail;
	private LocalDate createdAt;
	private LocalDate lastLoginAt;

	public User(String username, String password, String userEmail, LocalDate createdAt, LocalDate lastLoginAt) {
		this.username = username;
		this.password = password;
		this.userEmail = userEmail;
		this.createdAt = createdAt;
		this.lastLoginAt = lastLoginAt;
	}

}