package com.ratan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentApp")
public class MyController {

	@Value("${uname}")
	private String username;
	
	
	//@RequestMapping("/hello")
	
	//@RequestMapping(value = "/hello", method = RequestMethod.GET)
	//@RequestMapping(value = "/hello",method = RequestMethod.GET,produces = "application/json")
//@RequestMapping(value = "/hello",method = RequestMethod.GET,produces =MediaType.APPLICATION_XML_VALUE)
	
	@GetMapping("/getStudent/{roll}")
	public Student getStudentDetails(@PathVariable int roll) {
		
		if(roll < 100)
			throw new InvalidRollNumberException("Roll number should be greater than 100");
		
		
		
		return new Student(roll, "Ram",850);
	}
	
	
	@GetMapping("/getAllStudents")
	public StudentList getAllStudents(){
		
		StudentList list=new StudentList();
		
		list.getStudents().add(new Student(10,"name1",850));
		list.getStudents().add(new Student(12,"name2",750));
		list.getStudents().add(new Student(14,"name3",950));
		list.getStudents().add(new Student(15,"name4",750));
		
		return list;
		
	}
	
	
	@PostMapping(value = "/saveStudent",consumes = "application/json")
	public String saveStudentDetails(@Valid @RequestBody Student student) {
		
		
		
		
		return  "Student stored ,"+student.getName() + "===="+username;
		
		
	}
	
	@PutMapping(value = "/updateStudent/{graceMarks}",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student,@PathVariable("graceMarks")int gMarks) {
		
		student.setMarks(student.getMarks()+gMarks);
		
		HttpHeaders hh=new HttpHeaders();
		
		hh.add("jwt", "sdnjnwjk3kj412321231sdf");
		hh.add("user", "admin");
		hh.add("hello", "abc");
		
		ResponseEntity<Student> re=new ResponseEntity<>(student,hh,HttpStatus.ACCEPTED);
		
		
		
		
		return re;
		
		
	}
	
	
	
	
	
	
}
