package com.sky.AjaxController;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sky.MemberService;

@Controller
public class AjaxController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/ajax1")
	public String todo() {
		return "ajax1";
	}
	@GetMapping("/list")
	public String lst(Model model) {
		model.addAttribute("list", memberService.printList());
		return "list";
	}
}
