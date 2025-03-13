package com.student.model.vo;

public class Student {
	private static int studentIndex = 0;
	private int studentNo;
	private int grade;
	private int classRoom ;
	private String name;
	private String address;
	private String phone;
	private char gender;
	private double height;
	private double weight; //vo(dto)에서 따로 관리한다
	
	{//초기화블록 //생성자별로코드를 계속 넣을 필요 없다.
		studentNo = ++studentIndex;
	}
	
	public Student() {
		
		
		
	}
	
	public Student(String name, int grade, int classRoom, String address,
					String phone, char gender, double height, double weight) {
		this.name=name;
		this.grade=grade;
		this.classRoom=classRoom;
		this.address=address;
		this.phone=phone;
		this.gender=gender;
		this.weight=weight;
		this.height=height;
	}


	public int getStudentNo() {
		return studentNo;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String infoStudent() {
		return studentNo+"\t"+
			   name+"\t"+
			   grade+"\t"+
			   classRoom+"\t"+
			   address+"\t"+
			   phone+"\t"+
			   gender+"\t"+
			   height+"\t"+
			   weight;
	}
	

}

