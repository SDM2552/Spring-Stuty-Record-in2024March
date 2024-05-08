package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import dao.BoardDao;
import dto.Board;

@Service
public class PostWriteService {
	@Autowired
	private BoardDao boardDao;
	
	String title   = null;
    String writer  = null;
    String content = null;
    String action = null;

	public String writePost(Board board, HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		title   = board.getTitle();
	    writer  = (String)session.getAttribute("userName");
	    content = board.getContent();
	    action  = "write";
	    boardDao.insert(board);
	    model.addAttribute("board", board);
	    model.addAttribute("action", action);
		return "write";
	}
	
	public String updatePost(HttpServletRequest req, HttpServletResponse res, int num) {
		Board board = boardDao.selectOne(num, false);
		System.out.println("board값을 가져오나? "+board);
		
		System.out.println("num값을 가져오나? "+num);
		
		title = board.getTitle();
		content = board.getContent();
        
		action = "update?num="+num;
		req.setAttribute("board", board);
        req.setAttribute("action", action);
        System.out.println("board request 체크 "+board);
        System.out.println("action requuest 체크 "+action);
		return "update";
	}
}
