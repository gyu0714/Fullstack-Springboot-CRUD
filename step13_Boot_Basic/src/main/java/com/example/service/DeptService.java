package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Dept;

public interface DeptService {
	
	public List<Dept> getDeptAll();
	
	public ResponseEntity<Dept> getDeptByDeptno(Long deptno);
	
	public Dept createDept(Dept dept);
	
	public ResponseEntity<Dept> updateDeptByDeptno(Dept dept, Long deptno);
	
	public ResponseEntity<Dept> removeDeptByDeptno(Long deptno);
	
}
