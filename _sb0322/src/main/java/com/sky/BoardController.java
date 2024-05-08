package com.sky;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.dto.Member;
import com.sky.dto.MemberForInsert;
import com.sky.dto.MemberForUpdate;

@Controller
public class BoardController {
	
//	@Autowired
//	private MemberDao memberDao;
	@Autowired
	private MemberService memberService;

	@GetMapping("/")
	public String root(Model model) {
		return "root";
	}
	@GetMapping("/table")
	public String table(Model model) {
		model.addAttribute("list", memberService.printList());
		return "table";
	}
	
	@PostMapping("/insert")
	public String addMember(MemberForInsert member) {
		memberService.insertMember(member);
		return "redirect:/table";
	}
	
	@PostMapping("/update")
	public String updateMember(MemberForUpdate member) {
		memberService.updateMember(member);
		return "redirect:/table";
	}
	@PostMapping("/delete")
	public String deleteMember(@RequestParam("id") int id) {
		memberService.deleteMember(id);
		return "redirect:/table";
	}

//	@PostMapping("/insert")
//	public String addMember(HttpServletRequest request, HttpServletResponse response) {
//		memberService.insertMember(request, response);
//		return "redirect:/table";
//	}
	
	
	@GetMapping("/home")
	public String redirect() {
		return "redirect:/";
	}
}
