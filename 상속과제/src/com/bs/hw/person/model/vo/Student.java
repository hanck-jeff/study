package com.bs.hw.person.model.vo;

public class Student extends Person{
//	- grade : int // 학년
//	- major : String	// 전공 
//	+ Student()
//	+ Student(name:String, age:int, height:double, weight:double, grade:int, major:String)
//	+ getter/setter()
//	+ toString() : String
	
	private int grade;
	private String major;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String name, int age, double height, double weight, int grade, String major) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
	}


	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + grade + " " + major;
	}
	
	
}
