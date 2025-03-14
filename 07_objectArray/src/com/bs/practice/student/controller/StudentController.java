package com.bs.practice.student.controller;

import com.bs.practice.student.model.vo.Student;

public class StudentController {
	
	public Student[] sArr = new Student[5];
	public final int CUT_LINE = 60;
	
	public StudentController () {
		
		sArr = new Student[] {
			new Student("김길동","자바", 100),
			new Student("박길동","디비", 50),
			new Student("이길동","화면", 85),
			new Student("정길동","서버", 60),
			new Student("홍길동","자바", 20)
		};
	}
	
	public void printStudent() {
		
		for(Student s: sArr) {
			System.out.println(s.inform());
		}
		
	}
	
	public double sumScore() {
		double sum = 0;
		for(Student s: sArr) {
			sum += s.getScore();
		}
		return sum;
	}
	
	public double[] avgScore() {
		double sumScore = sumScore();
		double avgScore = (double)sumScore/sArr.length;
		double scoreArr[] = {sumScore,avgScore};
		return scoreArr;
	}
	
	

}
