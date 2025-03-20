package com.bs.hw.person.model.vo;

public class Employee extends Person{
//	- salary : int // 급여
//	- dept : String // 부서
//	+ Employee()
//	+ Employee(name:String, age:int, height:double,
//	weight:double, salary:int, dept:String)
//	+ getter/setter()
//	+ toString() : String
	
	private int salary;
	private String dept;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
	}

	
	
	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return super.toString() + " " + salary + " " + dept;
	}

}
