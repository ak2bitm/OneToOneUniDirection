package com.akhilesh.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.akhilesh.exception.ResourceNotFoundException;
import com.akhilesh.model.Student;
import com.akhilesh.repo.StudentRepository;
import com.akhilesh.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	@Override
	public Student createStudent(Student student) {
		Optional<Student> optst = studentRepository.findByEmail(student.getEmail());
		if(optst.isPresent()) {
			throw new ResourceNotFoundException("Student exist with given email :"+student.getEmail());
		}
		return studentRepository.save(student);
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}


	@Override
	public Optional<Student> getStudentById(long sId) {
		return studentRepository.findById(sId);
	}


	@Override
	public Student updateStuent(Long stuId,Student updateStudent) {
		
		return studentRepository.findById(stuId).map(st->{
			st.setFirstName(updateStudent.getFirstName());
			st.setLastName(updateStudent.getLastName());
			st.setEmail(updateStudent.getEmail());
			return st;
		}).orElseThrow(()-> new ResourceNotFoundException("Student not found with id:"+updateStudent.getSid()));
	}


	@Override
	public void deleteStudent(long sId) {
		studentRepository.deleteById(sId);		
	}

}
