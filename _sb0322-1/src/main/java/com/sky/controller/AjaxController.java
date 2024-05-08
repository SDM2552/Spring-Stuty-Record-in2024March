package com.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sky.State;
import com.sky.dto.Dept;
import com.sky.dto.Emp;
import com.sky.service.DeptService;
import com.sky.service.EmpService;

@Controller
public class AjaxController {
	
	@Autowired
	private DeptService deptService;
	@Autowired
	private EmpService empService;
	@Autowired
	private State state;

	@GetMapping("/ajax1")
	public String main(Model model) {
		List<Dept> deptList = deptService.printList();
		model.addAttribute("list", deptList);
		return "rootWithAjax2";
	}
	@GetMapping("/selectEmp2")
	public String selectEmp2(int deptno, Model model) {
			List<Dept> deptList = deptService.printList();
			model.addAttribute("list", deptList);
			state.setDeptno(deptno);
			System.out.println(deptno);
			List<Emp> empList = empService.printList(deptno);
			model.addAttribute("list2",empList);
		return "selectEmp2";
	}
	
}
