package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Emp;
import com.example.repository.DeptRepository;
import com.example.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private DeptRepository deptRepository;

	@Override
	public List<Emp> getEmps() {
		return empRepository.findAll();
	}

	@Override
	public ResponseEntity<Emp> getEmpByEmpno(Long empno) {
		Emp emp = empRepository.findById(empno).orElseThrow(
				() -> new ResourceNotFoundException("해당하는 사원 없음 : " + empno));
		
		return ResponseEntity.ok(emp);
	}
	
	@Override
	public Emp createEmp(Emp emp) {
			return empRepository.save(emp);
	}

	@Override
	public ResponseEntity<Emp> updateEmpByEmpno(Emp emp, Long empno) {
		Emp updateEmp = empRepository.findById(empno).orElseThrow(
				() -> new ResourceNotFoundException("해당하는 사원 없음  : " + emp));
		
		updateEmp.setEmpno(emp.getEmpno());
		updateEmp.setEname(emp.getEname());
		updateEmp.setJob(emp.getJob());
		updateEmp.setMgr(emp.getMgr());
		updateEmp.setComm(emp.getComm());
		updateEmp.setDept(emp.getDept());
		
		return ResponseEntity.ok(updateEmp);
	}

	@Override
	public ResponseEntity<Emp> deleteEmpByEmpno(Long empno) {
		Emp emp = empRepository.findById(empno).orElseThrow(
				() -> new ResourceNotFoundException("해당하는 사원이 없습니다." + empno));
		
		empRepository.delete(emp);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
