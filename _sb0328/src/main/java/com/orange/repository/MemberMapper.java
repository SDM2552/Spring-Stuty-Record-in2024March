package com.orange.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.orange.model.Member;

@Mapper
public interface MemberMapper {

	@Select("select count(*) from member")
	int count();
	
	@Select("select * from member")
	List<Member> selectAll();
	
	Member selectMemberById(Long id);
}
