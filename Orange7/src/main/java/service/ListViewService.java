package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import dao.MemberDao;
import dto.Board;


@Service
public class ListViewService  {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private MemberDao memberDao;
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	public ArrayList<Board> listView(){
		return boardDao.selectList();
	}

}
