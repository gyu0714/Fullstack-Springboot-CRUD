package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Long> {

}
