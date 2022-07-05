package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Dept;
import com.example.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptRepository deptRepository;

	@Override
	public List<Dept> getDeptAll() {
		return deptRepository.findAll();
	}

	@Override
	public Dept createDept(Dept dept) {
		return deptRepository.save(dept);
	}

	@Override
	public ResponseEntity<Dept> getDeptByDeptno(Long deptno) {
		Dept dept = deptRepository.findById(deptno).orElseThrow(
				() -> new ResourceNotFoundException("해당하는 부서 없음" + deptno));
		
		return ResponseEntity.ok(dept);
	}

	@Override
	public ResponseEntity<Dept> updateDeptByDeptno(Dept deptDetails, Long deptno) {
		 Dept updatedept = deptRepository.findById(deptno).orElseThrow(
				() -> new ResourceNotFoundException("해당하는 부서 없음 : " + deptno));
		 
		 updatedept.setDeptno(deptDetails.getDeptno());
		 updatedept.setDname(deptDetails.getDname());
		 updatedept.setLoc(deptDetails.getLoc());
		 
		 return ResponseEntity.ok(updatedept);
	}

	@Override
	public ResponseEntity<Dept> removeDeptByDeptno(Long deptno) {
		Dept dept = deptRepository.findById(deptno).orElseThrow(
				() -> new ResourceNotFoundException("해당하는 부서 없음 : " + deptno));
				
			deptRepository.delete(dept);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}



}
