package com.sky;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.ui.Model;

import com.sky.dao.DeptDao;
import com.sky.dao.EmpDao;
import com.sky.dto.Dept;
import com.sky.dto.Emp;
import com.sky.service.DeptService;
import com.sky.service.EmpService;

@SpringBootTest
class Sb03221ApplicationTests {

	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmpDao empDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EmpService empService;
	@Autowired
	private State state;
	
//	@Test
	@DisplayName("jdbc 테스트")
	void jdbcTest() {
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select count(*) from dept",10);
		rs.next();
		System.out.println("rs값: "+rs);
		assertEquals(10, rs.getInt("10"));
	}
	
//	@Test
	@DisplayName("dept목록 출력 테스트")
	public void test2() {
		System.out.println(deptDao.deptList().toString());
	}
//	@Test
	@DisplayName("Dept Service 작동 테스트")
	public void test3() {
		System.out.println(deptService.printList().toString());
	}
//	@Test
	@DisplayName("Emp Service selectOne 작동 테스트")
	public void test4() {
		System.out.println(empService.selectOne(7839));
	}
//	@Test
	@DisplayName("State 왜 안나옴?")
	public void test5(State state, int deptno, Model model) {
		deptno=10;
		List<Dept> deptList = deptService.printList();
		model.addAttribute("list", deptList);
		state.setDeptno(deptno);
		System.out.println(deptno);
	}
	@Test
	@DisplayName("update 테스트")
	public void test6() {
		Emp emp = new Emp(7900,"JAMES","CLERK",7698,"81-12-03", 950, 0, 30);
//		empDao.updateOne(emp);
//		empService.updateOne(emp);
		}

}
