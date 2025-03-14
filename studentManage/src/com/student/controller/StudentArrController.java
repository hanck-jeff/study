package com.student.controller;


import com.student.model.vo.Student;
import static com.student.view.MainArrView.*;
import static com.student.model.dao.StudentArrDao.studentArrDao;

//프로그램에서 서비스를 진행시키는 역할을 하는 클래스
public class StudentArrController {
	
//	private StudentDao dao = new StudentDao();
//	private MainView view = new MainView();
//	컨트롤러에도 new view 가 있고 view에도 controller에도 view가 있어서 서로 소환하다가 스택이 차버림.. 그래서 스택오버플로우 오류발생
	
	//single tone patten
	private static StudentArrController controller;
	
	private StudentArrController() {}
	
	public static StudentArrController getStudentArrController() {
		if(controller == null) controller = new StudentArrController();
		return controller;
		
	}
	
	
	public void menu() {
//		view.mainMenu(this);
		mainView().mainMenu();
		//여기서 this는 main의 new StudentController().menu();
		//new StudentController() 컨트롤러다.

	}
	
	public void insertStudent() {
		//1. 학생정보 입력화면
//		Student student = new MainView().insertStudentView();
		Student student = mainView().insertStudentView();
		
		//입력한 정보 확인하기
		
		//2. 데이터 저장소에 저장 - StudentDao(data access object)클래스를 이용해서 데이터를 저장
		boolean result = studentArrDao().saveStudent(student);
		//single tone?
		
		//3. 서비스 실행 결과 출력 -> 화면 메세지 출력 화면
		String msg = result?"회원등록성공":"회원등록실패";
		mainView().printMessage(msg);
		
		
	}
	
	public void updateStudent() {
		String studentList = studentArrDao().searchStudent();
		
		if(!studentList.equals("")) {
			int no = mainView().updateStudentListView(studentList);
			Student s = studentArrDao().updateStudentByNo(no);
			if(s != null) { mainView().editStudentView(s);}
			else {
				String msg = "없는 학생입니다.";
				mainView().printMessage(msg);
			}
			
		}else {
			String msg = "등록된 학생이 없습니다.";
			mainView().printMessage(msg);
		}
	}
	
	public void deleteStudent() {
		String studentList = studentArrDao().searchStudent();
		String msg ="";
		if(!studentList.equals("")) {
			int no = mainView().deleteStudentListView(studentList);
			boolean result = studentArrDao().deleteStudentByNo(no);
			msg = result?"회원 삭제 성공":"회원 삭제 실패";
		}else {
			msg = "등록된 학생이 없습니다.";
		}
		mainView().printMessage(msg);
	}
	
	public void searchStudent() {
		//1. dao 필드에 저장된 학생들을 가져오기
		//2. 가져온 학생을 출력하기
		String studentList = studentArrDao().searchStudent();
		mainView().searchStudentView((studentList.equals(""))?"검색결과가 없습니다.":studentList);
	}
	
	public void searchStudentByNo() {
		int studentNo = mainView().searchStudentByNoView();
		String studentList = studentArrDao().searchStudentByNo(studentNo);
		mainView().searchStudentView((studentList.equals(""))?"검색결과가 없습니다.":studentList);
	}
	
	public void searchStudentByGrade() {
		int grade = mainView().searchStudentByGradeView();
		String studentList = studentArrDao().searchStudentByGrade(grade);
		mainView().searchStudentView((studentList.equals(""))?"검색결과가 없습니다.":studentList);
	}
	
	public void searchStudentByName() {
		String name = mainView().searchStudentByNameView();
		String studentList = studentArrDao().searchStudentByName(name);
		mainView().searchStudentView((studentList.equals(""))?"검색결과가 없습니다.":studentList);		
	}
	
}
