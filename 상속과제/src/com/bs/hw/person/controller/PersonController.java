package com.bs.hw.person.controller;

import com.bs.hw.person.model.vo.Employee;
import com.bs.hw.person.model.vo.Student;

public class PersonController {

//	- s:Student[] = new Student[3]
//	- e:Employee[] = new Employee[10]
//	+ personCount() : int[]
//	+ insertStudent(name:String, age:int, height:double, weight:double, grade:int, major:String) : void
//	+ printStudent() : Student[]
//	+ insertEmployee(name:String, age:int, height:double, weight:double, salary:int, dept:String) : void
//	+ printEmployee() : Employee[]
	
	private Student[] s = new Student[3];
	private Employee[] e= new Employee[10];
	
	public int[] personCount(){
		int sCount = 0;
		int eCount = 0;
		for(Student s : s) if(s != null) sCount++;
		for(Employee e : e) if(e != null) eCount++;
		return new int[] {sCount, eCount};
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade , String major) {
		Student newStudent = new Student(name,age,height,weight,grade,major);
		
		for(int i=0;i<s.length ;i++) {
			if(s[i] == null) {
				s[i] = newStudent;
				break;
			}
		}
	}
	
	public Student[] printStudent(){
		return s;
	}
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		Employee newEmployee = new Employee(name,age,height,weight,salary,dept);
		
		for(int i=0;i<e.length ;i++) {
			if(e[i] == null) {
				e[i] = newEmployee;
				break;
			}
		}
	}
	
	public Employee[] printEmployee(){
		return e;
	}
	
	
	
}
