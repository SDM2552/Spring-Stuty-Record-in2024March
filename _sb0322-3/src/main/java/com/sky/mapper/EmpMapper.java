package com.sky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sky.dto.Emp;

@Mapper
public interface EmpMapper {
	List<Emp> selectEmpList();
	
	int selectCount();
	
	void insertEmp(Emp emp);
//
//	BoardDto selectBoardDetail(int boardIdx);
//
//	void updateHitCount(int boardIdx);
//	
	void updateEmp(Emp emp);
	
	void deleteEmp(int empno);
}
