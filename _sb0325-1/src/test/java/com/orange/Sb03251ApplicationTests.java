package com.orange;


import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.orange.repository.MemberMapper;
import com.orange.spring.Member;

@SpringBootTest
class Sb03251ApplicationTests {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Test
	void contextLoads() {
		System.out.println(memberMapper.selectCount());
	}
	@Test
	@DisplayName("회원 수 count() 2번쨰")
	void test1() {
		System.out.println(memberMapper.count());
	}
	@Test
	@DisplayName("Member 검색")
	void selectByEmail() {
		System.out.println(memberMapper.selectByEmail1("aaa@korea.com"));
	}
//	@Test
	@DisplayName("Member 등록")
	void insertMember() {
		Member memeber = Member.builder()
								.email("kk@korea.com")
								.password("1234")
								.name("케이")
								.build();
		memberMapper.insert(memeber);
	}
//	@Test
	@DisplayName("Member 등록")
	void insertMember2() {
		Member memeber = Member.builder()
								.email("hh@korea.com")
								.password("1234")
								.name("엣치")
								.build();
		memberMapper.insert2(memeber);
	}
	
	@Test
	@DisplayName("Member list 전부 출력")
	void selectAll(){
		memberMapper.selectAll();
	}

}
