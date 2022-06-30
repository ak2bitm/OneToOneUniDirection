package com.akhilesh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhilesh.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	public Optional<Student> findByEmail(String email);
}
