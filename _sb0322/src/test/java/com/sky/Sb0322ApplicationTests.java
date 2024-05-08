package com.sky;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.sky.dto.Member;
import com.sky.dto.MemberForInsert;

@SpringBootTest
class Sb0322ApplicationTests {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	@DisplayName("jdbc 테스트")
	void jdbcTest() {
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from member where id=?",13);
		rs.next();
		assertEquals(13, rs.getInt("id"));
	}
	
//	@Test
	@DisplayName("assertEquals 테스트")
	void contextLoads() {
		int before = memberDao.count();
		MemberForInsert member = MemberForInsert.builder().name("지지").email("gg@gmail.com").age(21).memo("@test").build();
		memberDao.insert(member);
		int after = memberDao.count();		
		assertEquals(before+1, after);
	}
	@Test
	@DisplayName("selectAll() 테스트")
	public void test1() {
		System.out.println(memberDao.selectAll());
	}
//	@Test
	@DisplayName("insert() 테스트할래")
	public void test2() {
		MemberForInsert member = MemberForInsert.builder().name("잉").email("ee@gmail.com").age(19).build();
		memberDao.insert(member);
	}
	

}
