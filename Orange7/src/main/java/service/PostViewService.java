package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import dao.CommentsDao;
import dto.Board;
import dto.Comments;

@Service
public class PostViewService {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private CommentsDao commentsDao;
	
	public Board postView(int num, boolean inc) {
		return boardDao.selectOne(num, inc);
	}
	public ArrayList<Comments> commentView(int num) {
		return commentsDao.printComments(num);
	}
}
