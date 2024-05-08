package com.orange.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.orange.spring.Member;

@Mapper
public interface MemberMapper {
	
	int selectCount();
	
	@Select("select count(*) from member")
	int count();
	
	@Select("select * from MEMBER where EMAIL = #{email}")
	Member selectByEmail(String email);
	
	Member selectByEmail1(String email);
	
	@Insert("insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) " +
	        "values (#{email}, #{password}, #{name}, now())")
	void insert(Member member);
	
	void insert2(Member member);
	
	@Select("select * from Member")
	List<Member> selectAll();

}
