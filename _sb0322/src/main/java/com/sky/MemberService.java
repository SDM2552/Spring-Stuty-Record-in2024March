package com.sky;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dto.Member;
import com.sky.dto.MemberForInsert;
import com.sky.dto.MemberForUpdate;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	public List<Member> printList(){
		List<Member> list = memberDao.selectAll();
		return list;
	}
	public void insertMember(MemberForInsert member) {
		memberDao.insert(member);
	}
	public void updateMember(MemberForUpdate member) {
		memberDao.update(member);
	}
	public void deleteMember(int id){
		memberDao.delete(id);
	}
	
	//	public void insertMember(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
//        int age = Integer.parseInt(request.getParameter("age"));
//        String email = request.getParameter("email");
//        String memo = request.getParameter("memo");
//		memberDao.insert(name, age, email, memo);
//	}
}
