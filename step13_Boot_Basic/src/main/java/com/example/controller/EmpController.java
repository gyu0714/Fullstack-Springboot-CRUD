package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emp;
import com.example.service.EmpServiceImpl;

@RestController
@RequestMapping("/emps")
public class EmpController {
	
	@Autowired
	EmpServiceImpl empService;
	
	@GetMapping
	public List<Emp> getEmps() {
		return empService.getEmps();
	}
	
	@GetMapping("/{empno}")
	public ResponseEntity<Emp> getEmpByEmpno(@PathVariable Long empno) {
		return empService.getEmpByEmpno(empno);
	}
	
	@PostMapping("/signup")
	public Emp createEmp(@RequestBody Emp emp) {
		return empService.createEmp(emp);
	}
	
	@PutMapping("/edit/{empno}")
	public ResponseEntity<Emp> updateEmpByEmpno(@PathVariable Long empno, @RequestBody Emp emp){
		return empService.updateEmpByEmpno(emp, empno);
	}
	
	@DeleteMapping("/remove/{empno}")
	public ResponseEntity<Emp> deleteEmpByEmpno(@PathVariable Long empno) {
		return empService.deleteEmpByEmpno(empno);
	}
}
