package com.performance.apiperformanceenhancement.dao;

import com.performance.apiperformanceenhancement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {}
