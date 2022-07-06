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

import com.example.model.Dept;
import com.example.service.DeptServiceImpl;

@RestController
@RequestMapping("/depts")
public class DeptRestController {
	
	@Autowired
	DeptServiceImpl deptService;
	
	@GetMapping
	public List<Dept> getDepts() {
		return deptService.getDeptAll();
	}
	
	@GetMapping("/{deptno}")
	public ResponseEntity<Dept> getDeptByDept(@PathVariable Long deptno) {
		return deptService.getDeptByDeptno(deptno);
	}
	
	@PostMapping("/create")
	public Dept createDept(@RequestBody Dept dept) {
		return deptService.createDept(dept);
	}
	
	@PutMapping("/edit/{deptno}")
	public ResponseEntity<Dept> updateDeptByDeptno(@PathVariable Long deptno, @RequestBody Dept deptDetails) {
		return deptService.updateDeptByDeptno(deptDetails, deptno);
	}
	
	@DeleteMapping("/remove/{deptno}")
	public ResponseEntity<Dept> deleteDeptByDeptno(@PathVariable Long deptno) {
		return deptService.removeDeptByDeptno(deptno);
	}
	
}
