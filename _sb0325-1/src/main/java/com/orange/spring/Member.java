package com.orange.spring;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private String registerDateTime;

	public Member(String email, String password, 
			String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

//	void setId(Long id) {
//		this.id = id;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public LocalDateTime getRegisterDateTime() {
//		return registerDateTime;
//	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

}
