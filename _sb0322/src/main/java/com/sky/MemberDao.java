package com.sky;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sky.dto.Member;
import com.sky.dto.MemberForInsert;
import com.sky.dto.MemberForUpdate;

@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
		return count;
	}

	public List<Member> selectAll(){
		List<Member> results = jdbcTemplate.query("select * from member",
				(ResultSet rs, int rowNum) -> {
						Member member = new Member(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getInt("age"),
								rs.getString("email"),
								rs.getString("memo"));
						return member;
					}	
		);
		return results;	
	}
	
//	public void insert(String name, int age, String email, String memo) {
//		jdbcTemplate.update("insert into member(name, age, email, memo, regdate) values(?,?,?,?,now())",
//				name, age, email, memo);
//	}
	public void insert(MemberForInsert member) {
		jdbcTemplate.update("insert into member(name, age, email, memo, regdate) values(?,?,?,?,now())",
				member.getName(), member.getAge(),member.getEmail(), member.getMemo());
	}
	
	public void update(MemberForUpdate member) {
		jdbcTemplate.update("update member set name=?,age=?,email=?,memo=? where id=?",
				member.getName(), member.getAge(),member.getEmail(), member.getMemo(), member.getId());
	}
	public void delete(int id) {
		jdbcTemplate.update("delete from member where id=?",id);
	}
	
//	public Member selectByEmail(String email) {
//		List<Member> results = jdbcTemplate.query(
//				"select * from MEMBER where EMAIL = ?",
//				new RowMapper<Member>() {
//
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Member member = new Member(rs.getString("EMAIL"), 
//								rs.getString("PASSWORD"), 
//								rs.getString("NAME"), 
//								rs.getTimestamp("REGDATE").toLocalDateTime());
//						member.setId(rs.getLong("ID"));
//						return member;
//					}
//					}, 
//				email);
//		return results.isEmpty() ? null : results.get(0);
//	}
//	public Member selectByEmail2(String email) {
//		Member results = jdbcTemplate.queryForObject(
//				"select * from MEMBER where EMAIL = ?",
//				new RowMapper<Member>() {
//
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Member member = new Member(rs.getString("EMAIL"), 
//								rs.getString("PASSWORD"), 
//								rs.getString("NAME"), 
//								rs.getTimestamp("REGDATE").toLocalDateTime());
//						member.setId(rs.getLong("ID"));
//						return member;
//					}
//					}, 
//				email);
//		return results;
//	}
//	public Member selectByEmail3(String email) {
//		List<Member> results = jdbcTemplate.query(
//				"select * from MEMBER where EMAIL = ?",
//				(rs, rowNum) -> {
//						Member member = new Member(rs.getString("EMAIL"), 
//								rs.getString("PASSWORD"), 
//								rs.getString("NAME"), 
//								rs.getTimestamp("REGDATE").toLocalDateTime());
//						member.setId(rs.getLong("ID"));
//						return member;
//					}, email);
//		return results.isEmpty() ? null : results.get(0);
//	}
//
//	public void insert(Member member) {
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbcTemplate.update(new PreparedStatementCreator() {		
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(
//						"insert into Member (email, password, name, regdate) values(?,?,?,now())", new String[]{"ID"});
//				pstmt.setString(1, member.getEmail());
//				pstmt.setString(2, member.getPassword());
//				pstmt.setString(3, member.getName());
//				return pstmt;
//			}
//		}, keyHolder);
//		Number keyValue = keyHolder.getKey();
//		member.setId(keyValue.longValue());
//	}
//
//	
//	public void insert2(Member member) {
//		jdbcTemplate.update("insert into Member (email, password, name, regdate) values(?,?,?,now())",
//				member.getEmail(), member.getPassword(), member.getName());
//	}
//
//	public void update(Member member) {
//		jdbcTemplate.update("update MEMBER set name=?,PASSWORD=? where EMAIL=?",
//				member.getName(),member.getPassword(),member.getEmail());
//		
//	}
//
//	public List<Member> selectAll2() {
//		List<Member> results = jdbcTemplate.query("select * from Member",
//				new RowMapper<Member>() {
//
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Member member = new Member(
//								rs.getString("EMAIL"), 
//								rs.getString("PASSWORD"), 
//								rs.getString("NAME"), 
//								rs.getTimestamp("REGDATE").toLocalDateTime());
//						member.setId(rs.getLong("ID"));
//						return member;
//					}
//		});
//		return results;
//	}
}
