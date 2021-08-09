package com.ratan;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Student {

	//@Min(100)
	@Min(value = 100,message = "{roll.invalid}")
	private Integer roll;
	
	@Size(min = 3,max = 10 ,message = "{name.invalid}")
	private String name;
	private Integer marks;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Integer getRoll() {
		return roll;
	}


	public void setRoll(Integer roll) {
		this.roll = roll;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getMarks() {
		return marks;
	}


	public void setMarks(Integer marks) {
		this.marks = marks;
	}


	public Student(Integer roll, String name, Integer marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}


	
	
}
