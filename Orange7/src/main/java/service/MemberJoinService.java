package service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import dto.Member;

@Service
public class MemberJoinService {

	@Autowired
	private MemberDao memberDao;
	
	public String signUp(HttpServletRequest request, HttpServletResponse response) {
	String id = request.getParameter("id");
//	Connection conn = ConnectionProvider.getConnection();
//   	MemberDao dao = MemberDao.getInstance();
   			//MemberDao.getInstance().idCheck(request.getParameter("id"));

    
        if (id.equals(memberDao.idCheck(id))) {  
            // 이미 있는 아이디이면 오류 표시
        	return "SignUpDuplicateID";
         } else {   	
            Member newMember = new Member(request.getParameter("id"  ),
                    request.getParameter("pw"  ),
                    request.getParameter("name"));
//            conn = ConnectionProvider.getConnection();
            memberDao.insert(newMember);
            System.out.println("가입정보: "+newMember.toString());
            System.out.println("가입 성공");
        	
		return "signUpSucess";
        }
	}
}
