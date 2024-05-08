package com.orange.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private Long prodId;
	private String prodName;
	private Integer prodPrice;
}
