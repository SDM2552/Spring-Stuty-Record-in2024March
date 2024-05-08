package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dao.BoardDao;
import dao.CommentsDao;
import dto.Board;
import dto.Comments;
import service.ListViewService;
import service.PostViewService;
import service.PostWriteService;

@Controller
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private CommentsDao commentsDao;
	@Autowired
	private ListViewService listViewService;
	@Autowired
	private PostViewService postViewService;
	@Autowired
	private PostWriteService postWriteService;

	@GetMapping("/")
	public String root() {
		return "index2";
	}

	@GetMapping("/list")
	public String list(BoardDao boardDao, Model model) {
		BoardDao.getConnection();
		List<Board> list = listViewService.listView();
		model.addAttribute("list", list);
//		model.addAttribute("list", listViewService.listView());
		return "list";
	}

	@GetMapping("/post")
	public String post(BoardDao boardDao, int num, boolean inc, Model model) {
		BoardDao.getConnection();
		CommentsDao.getConnection();
		Board board = postViewService.postView(num, inc);
		model.addAttribute("board", board);
		ArrayList<Comments> comments = postViewService.commentView(num);
		System.out.println(comments.toString());
		model.addAttribute("comments", comments);
		return "post";
	}
	@GetMapping("/write")
	public String writeForm(Model model) {
		BoardDao.getConnection();
		model.addAttribute("action", "write");
		return "writeForm";
	}
	@PostMapping("/write")
	public String writePost(Board board,HttpServletRequest request, HttpServletResponse response, Model model) {
		postWriteService.writePost(board, request, response, model);
		return "list";
	}
	
	public String updatePost() {
		return "list";
	}

	@GetMapping("/move")
	public String home() {
		return "redirect:/";
	}
}
