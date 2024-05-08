package com.sky.dto;

import java.time.LocalDateTime;

import com.sky.service.WrongIdPasswordException;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MemberForInsert {

	private String name;
	private int age;
	private String email;
	private String memo;
	
	public MemberForInsert(String name, int age, String email, String memo) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.memo = memo;
	}
	
//	private Long id;
//	private String email;
//	private String password;
//	private String name;
//	private LocalDateTime registerDateTime;
//
//	public Member(String email, String password, 
//			String name, LocalDateTime regDateTime) {
//		this.email = email;
//		this.password = password;
//		this.name = name;
//		this.registerDateTime = regDateTime;
//	}
//
//	public void setId(Long id) {
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
//
//	public void changePassword(String oldPassword, String newPassword) {
//		if (!password.equals(oldPassword))
//			throw new WrongIdPasswordException();
//		this.password = newPassword;
//	}

}
