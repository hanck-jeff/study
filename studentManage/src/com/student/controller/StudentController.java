package com.student.controller;

import com.student.model.dao.StudentDao;
import com.student.model.vo.Student;
import com.student.view.MainView;

//프로그램에서 서비스를 진행시키는 역할을 하는 클래스
public class StudentController {
	
	private StudentDao dao = new StudentDao();
	private MainView view = new MainView();
//	컨트롤러에도 new view 가 있고 view에도 controller에도 view가 있어서 서로 소환하다가 스택이 차버림.. 그래서 스택오버플로우 오류발생
	
	public void menu() {
		
		view.mainMenu(this);
		//여기서 this는 main의 new StudentController().menu();
		//new StudentController() 컨트롤러다.

	}
	
	public void insertStudent() {
		//1. 학생정보 입력화면
		Student student = new MainView().insertStudentView();
		
		//입력한 정보 확인하기
		
		//2. 데이터 저장소에 저장 - StudentDao(data access object)클래스를 이용해서 데이터를 저장
		boolean result = dao.saveStudent(student);
		//single tone?
		
		//3. 서비스 실행 결과 출력 -> 화면 메세지 출력 화면
		String msg = result?"회원등록성공":"회원등록실패";
		new MainView().printMessage(msg);
		
		
	}
	
	public void updateStudent() {
		String studentList = dao.searchStudent();
		
		if(!studentList.equals("")) {
			int no = new MainView().updateStudentListView(studentList);
			Student s = dao.updateStudentByNo(no);
			if(s != null) { new MainView().editStudentView(s);}
			else {
				String msg = "없는 학생입니다.";
				new MainView().printMessage(msg);
			}
			
		}else {
			String msg = "등록된 학생이 없습니다.";
			new MainView().printMessage(msg);
		}
	}
	
	public void deleteStudent() {
		String studentList = dao.searchStudent();
		String msg ="";
		if(!studentList.equals("")) {
			int no = new MainView().deleteStudentListView(studentList);
			boolean result = dao.deleteStudentByNo(no);
			msg = result?"회원 삭제 성공":"회원 삭제 실패";
		}else {
			msg = "등록된 학생이 없습니다.";
		}
		new MainView().printMessage(msg);
	}
	
	public void searchStudent() {
		//1. dao 필드에 저장된 학생들을 가져오기
		//2. 가져온 학생을 출력하기
		String studentList = dao.searchStudent();
		new MainView().searchStudentView((studentList.equals(""))?"검색결과가 없습니다.":studentList);
	}
	
	public void searchStudentByNo() {
		int studentNo = new MainView().searchStudentByNoView();
		String studentList = dao.searchStudentByNo(studentNo);
		new MainView().searchStudentView((studentList.equals(""))?"검색결과가 없습니다.":studentList);
	}
	
	public void searchStudentByGrade() {
		int grade = new MainView().searchStudentByGradeView();
		String studentList = dao.searchStudentByGrade(grade);
		new MainView().searchStudentView((studentList.equals(""))?"검색결과가 없습니다.":studentList);
	}
	
	public void searchStudentByName() {
		String name = new MainView().searchStudentByNameView();
		String studentList = dao.searchStudentByName(name);
		new MainView().searchStudentView((studentList.equals(""))?"검색결과가 없습니다.":studentList);		
	}
	
}
