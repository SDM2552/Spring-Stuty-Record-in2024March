package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dao.BoardDao;
import dao.MemberDao;
import dto.Member;
import service.LoginService;
import service.LogoutService;
import service.MemberJoinService;

@Controller
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private LoginService loginService;
	@Autowired
	private LogoutService logoutService;
	@Autowired
	private MemberJoinService memberJoinService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm2";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpServletRequest request, HttpServletResponse response) {
		MemberDao.getConnection();
		member.getId();
		member.getPw();
		return loginService.login(member, request, response);	
	}
	@GetMapping("/loginFail")
	public String loginFail() {
		return "loginFail";
	}
	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		return logoutService.logout(request, response);
	}
	@GetMapping("/signUp")
	public String signUp() {
		return "memberJoinForm";
	}
	@PostMapping("/signUp")
	public String doSignUp(HttpServletRequest request, HttpServletResponse response) {
		MemberDao.getConnection();
		return memberJoinService.signUp(request, response);
	}
	@PostMapping("/DuplicateID")
	public String DuplicateID() {
		return "SignUpDuplicateID";
	}
	@GetMapping("/move2")
	public String home2() {
	    return "redirect:/";
	}

}
