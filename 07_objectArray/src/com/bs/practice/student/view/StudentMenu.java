package com.bs.practice.student.view;

import com.bs.practice.student.controller.StudentController;
import com.bs.practice.student.model.vo.Student;

public class StudentMenu {
	
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("========== 학생 정보 출력 ==========");
		ssm.printStudent();
		// StudentController에 printStudent()의 반환 값을 통해 학생 정보 출력
		System.out.println("========== 학생 성적 출력 ==========");
		double[] scoreArr = ssm.avgScore();
		System.out.println("학생 점수 합계 : "+(int)scoreArr[0]);
		System.out.println("학생 점수 평균 : "+scoreArr[1]);
		// StudentController에 avgScore()를 통해 점수 합계와 평균 출력
		System.out.println("========== 성적 결과 출력 ==========");
		
		for(Student a : ssm.sArr) {
			if(a.getScore() >= 60){
				System.out.println(a.getName()+"학생은 통과입니다.");
			}else{
				System.out.println(a.getName()+"학생은 재시험대상입니다.");
			}
		}
		// 학생의 점수가 CUT_LINE 미만이면 재시험 대상, 이상이면 통과 출력
		
	}

}
