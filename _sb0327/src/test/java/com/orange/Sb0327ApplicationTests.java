package com.orange;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.orange.model.Product;
import com.orange.repository.ProductMapper;
import com.orange.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class Sb0327ApplicationTests {

	@Autowired
	ProductMapper productMapper;
	@Autowired
	ProductService productService;
	
//	@Test
	void contextLoads() {
		log.debug("products 레코드 수 {}",productMapper.count());
		System.out.println(productMapper.count());
	}

	@Test
	public void getProductById() {
		Product product = productService.getProductById(1L);
		log.info("★product: {}",product);
	}
	@Transactional
	@Test
	public void addProduct() {
		productService.addProduct(new Product("쿤달 샴푸",7900));
		productService.addProduct(new Product("마스크팩",1000));
		productService.addProduct(new Product("티셔츠",5900));
	}

}
