package com.orange;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestRunner implements ApplicationRunner{

	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Connection connection = dataSource.getConnection();
		log.info("■DBCP: "+dataSource.getClass()); //사용하는 DBCP 타입 확인
		log.info("■Url: "+connection.getMetaData().getURL());
		log.info("■UserName: "+ connection.getMetaData().getUserName());
		
		//JdbcTemplete
		jdbcTemplate.execute("INSERT INTO Products (prod_name, prod_price) VALUES ('버킷햇',6900)");
	}

}
