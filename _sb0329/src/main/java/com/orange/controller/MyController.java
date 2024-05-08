package com.orange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.orange.model.Product;
import com.orange.repository.ProductMapper;
import com.orange.service.ProductService;

@Controller
public class MyController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("userName","이순신");
		model.addAttribute("aaa","왱알왱알");
		model.addAttribute("product", productService.getProductById(2L));
		return "main";
	}
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list",productService.getAllProducts());
		return "list";
	}
	@GetMapping("/save")
	public String save() {
		return "save";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(Product product) {
		productService.addProduct(product);
		return "redirect:/save";
	}
}
