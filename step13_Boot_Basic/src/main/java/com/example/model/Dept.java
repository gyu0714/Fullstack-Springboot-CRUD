package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "dept")
public class Dept {
	
	@Id
	private Long deptno;
	
	private String dname;
	
	private String loc;
	
	}
