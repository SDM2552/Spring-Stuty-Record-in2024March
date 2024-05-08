package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import dao.MemberDao;
import dto.Member;
import util.Cookies;

@Service
public class LoginService {
	@Autowired
	private MemberDao memberDao;
	
	public String login(Member member, HttpServletRequest request, HttpServletResponse response) {
        String id = member.getId();
        String pw = member.getPw();
        member = memberDao.selectForLogin(id, pw);

        HttpSession session = request.getSession();

        if (member != null) {
            session.setAttribute("userNumId", member.getNumId());
            session.setAttribute("userId", member.getId());
            session.setAttribute("userName", member.getName());

            if ("on".equals(request.getParameter("remember"))) {
                try {
                    String rememberId = request.getParameter("id");
                    response.addCookie(Cookies.createCookie("rememberId", rememberId, "/", 60 * 60));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // remember 체크가 안된 경우에는 쿠키 삭제
                try {
					response.addCookie(Cookies.createCookie("rememberId", "", "/", 0));
				} catch (IOException e) {
					e.printStackTrace();
				}
            }

            return "index2";
        } else {
            return "loginFail";
        }
    }
}