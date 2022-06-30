package com.akhilesh.service;

import java.util.List;
import java.util.Optional;

import com.akhilesh.model.Student;

public interface StudentService {

	public Student createStudent(Student address);
	public List<Student> getAllStudents();
	public Optional<Student> getStudentById(long sId);
	public Student updateStuent(Long stuId,Student updateStudent);
	public void deleteStudent(long sId);
}
