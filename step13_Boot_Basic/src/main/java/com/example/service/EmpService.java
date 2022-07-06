package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Emp;

public interface EmpService {
	
	public List<Emp> getEmps();
	
	public ResponseEntity<Emp> getEmpByEmpno(Long empno);
	
	public Emp createEmp(Emp emp);
	
	public ResponseEntity<Emp> updateEmpByEmpno(Emp emp, Long empno);
	
	public ResponseEntity<Emp> deleteEmpByEmpno(Long empno);
}
