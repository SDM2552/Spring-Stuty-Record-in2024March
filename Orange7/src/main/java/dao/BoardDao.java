package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dto.Board;
import dto.Comments;

@Repository
public class BoardDao {
	
//	@Autowired
//	public JdbcTemplate jdbcTemplate;
//	@Autowired
//	public DataSource dataSource;
	
	private static Connection conn;
//	private static BoardDao dao = new BoardDao();
//	private BoardDao() {}
//	public static BoardDao getInstance() {
//		BoardDao.getConnection();
//		return dao;
//	}
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Board> selectList(){ //게시판 목록 보기
	    ArrayList<Board> list = new ArrayList<>();
//	    String sql = "select b.num num, b.title title, b.content content, b.regtime regtime, b.hits hits, s.name name from board b, smember s where b.memberno = s.numid order by num desc";
	    String sql = "SELECT "
	    		+ "    b.num AS num,"
	    		+ "    b.title AS title,"
	    		+ "    b.content AS content,"
	    		+ "    b.regtime AS regtime,"
	    		+ "    b.hits AS hits,"
	    		+ "    s.name AS name,"
	    		+ "    COUNT(c.boardid) AS count "
	    		+ "FROM board b "
	    		+ "JOIN smember s ON b.memberno = s.numid "
	    		+ "LEFT JOIN comments c ON b.num = c.boardid "
	    		+ "GROUP BY b.num, b.title, b.content, b.regtime, b.hits, s.name "
	    		+ "ORDER BY b.num DESC";

	    
	    try {
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();


	        while(rs.next()) {
	            Board board = new Board(
	                    rs.getInt("num"), rs.getString("title"),
	                    rs.getString("content"), rs.getString("regtime"),
	                    rs.getInt("hits"), rs.getString("name"), rs.getInt("count"));
	            list.add(board);
	        }           
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("SQL 예외 발생");
	    }
	    return list;        
	}
	
	public Board selectOne(int num, boolean inc) { //게시판 글 읽기
		Board board = null;
		String sql = "select b.num num, b.title title, b.content content, b.regtime regtime, b.hits hits, s.name name from board b, smember s where b.memberno = s.numid and num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board = new Board(rs.getInt("num"), rs.getString("title"), 
						rs.getString("content"),rs.getString("regtime"), 
						rs.getInt("hits"), rs.getString("name"));
			}
			if (inc) {
				pstmt.executeUpdate("update board set hits=hits+1 where num="+num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;		
	}
	
	public int delete(int num) { // 게시판 글 삭제
		int result = 0;
		try ( 
		        PreparedStatement pstmt = conn.prepareStatement(
		        		"delete from board where num=" + num);
		    ) {
		        // 쿼리 실행
				result = pstmt.executeUpdate();
		        
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		return result;
	}
	
	public int insert(Board board) { //게시판 글쓰기
		String sql = "insert into board(memberno, title, content, regtime, hits) values (?,?,?,SYSDATE,0)";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        // 현재 시간 얻기
//	        String curTime = LocalDate.now() + " " + 
//	                         LocalTime.now().toString().substring(0, 8);
	        
	        // 쿼리 실행
	    	pstmt.setInt(1, board.getMemberno());
	    	pstmt.setString(2, board.getTitle());
	    	pstmt.setString(3, board.getContent());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}
	
	public int update(Board board) { // 게시판 글 수정
        String sql = "update board set title=?, content=? where num=?";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        // 현재 시간 얻기
//	        String curTime = LocalDate.now() + " " + 
//	                         LocalTime.now().toString().substring(0, 8);
	        
	        // 쿼리 실행
	    	pstmt.setString(1, board.getTitle());
	    	pstmt.setString(2, board.getContent());
	    	pstmt.setInt(3, board.getNum());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}
	
	
}




