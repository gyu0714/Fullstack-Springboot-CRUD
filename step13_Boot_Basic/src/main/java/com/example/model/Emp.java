package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString()
@Entity(name = "emp")
public class Emp {
	@Id
	private Long empno;
	
	private String ename;
	
	private String job;
	
	private Integer mgr;
	
	private LocalDateTime hiredate;
	
	private Integer sal;
	
	private Integer comm;
	
//	@JsonIgnore => 다대다 테이블 매핑으로 가정할 경우 JSON stackoverflow를 방지하기 위한 어노테이션
	@OneToOne
	@JoinColumn(name = "deptno",
			foreignKey = @ForeignKey(foreignKeyDefinition = 
				"FOREIGN KEY (deptno) REFERENCE dept (deptno) ON DELETE SET NULL ON UPDATE CASCADE"
					))
	private Dept dept;

}
