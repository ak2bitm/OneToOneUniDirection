package com.akhilesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.akhilesh.model.Student;
import com.akhilesh.service.StudentService;


@RestController
@RequestMapping("/api/students")
public class StudentController {

	private StudentService studentService;
	

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}


	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json", value = "/{stuId}")
	public Student updateStudent(@PathVariable("stuId")Long stuId,@RequestBody Student student) {
		return studentService.updateStuent(stuId,student);
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{stuId}")
	public Student getStudentById(@PathVariable("stuId") Long stuId) {
		Optional<Student> st = studentService.getStudentById(stuId);
		if(st.isPresent()) {
			return st.get();
		}
		return null;
	}
	
	@DeleteMapping("/{stuId}")
	public void deleteEmployee(@PathVariable("stuId")Long stuId) {
		studentService.deleteStudent(stuId);
	}
}
