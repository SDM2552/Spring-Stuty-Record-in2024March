package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import Controller.BoardController;
import Controller.MemberController;
import dao.BoardDao;
import dao.CommentsDao;


@Configuration
@ComponentScan(basePackages = {"dao","service","controller"})
public class ControllerConfig {
	
	@Bean
	public BoardController boardController() {
		return new BoardController();
	}
	@Bean
	public MemberController memberController() {
		return new MemberController();
	}
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
	@Bean
	public CommentsDao commentsDao() {
		return new CommentsDao();
	}
}
