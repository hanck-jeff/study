package com.student.view;

//import com.student.controller.StudentController;
import static com.student.controller.StudentArrController.getStudentArrController;

import java.util.Scanner;

import com.student.model.vo.Student;

//프로그램에서 화면을 출력해주는 역할


public class MainArrView {
	private static MainArrView view;
	private MainArrView() {}
	public static MainArrView mainView() {
		if(view == null) view=new MainArrView();
		return view;
	}
	private Scanner sc = new Scanner(System.in);
	
	//메뉴화면을 출력
	public void mainMenu () {
//		StudentController studentController = new StudentController();
		while(true){
			System.out.println("=============학생관리프로그램 v0.2===============");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정(학년,반,전화번호,주소)");
			System.out.println("3. 학생삭제");
			System.out.println("4. 전체조회");
			System.out.println("5. 학생번호로 조회");
			System.out.println("6. 학년으로 조회");
			System.out.println("7. 이름으로 조회(완전일치하는 이름)");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴선택 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1: getStudentArrController().insertStudent();
				break;
			case 2: 
				getStudentArrController().updateStudent();
				break;
			case 3: 
				getStudentArrController().deleteStudent();
				break;
			case 4: 
				getStudentArrController().searchStudent();
				break;
			case 5: 
				getStudentArrController().searchStudentByNo();
				break;
			case 6: 
				getStudentArrController().searchStudentByGrade();
				break;
			case 7: 
				getStudentArrController().searchStudentByName();
				break;
			case 0: 
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못눌렀습니다.");
				break;
			}	
		}	
	}
	
	//2. 학생정보 등록화면
	// 학생번호, 이름, 학년, 반, 주소, 전화번호, 성별, 키, 몸무게
	public Student insertStudentView () {
		int grade, classRoom ;
		String name, address, phone;
		char gender;
		double height, weight; //vo(dto)에서 따로 관리한다 

		Student inputStudent = new Student();
		
		System.out.print("이름 :");
		name = sc.next();
		inputStudent.setName(name);
		System.out.print("학년 :");
		grade = sc.nextInt();
		inputStudent.setGrade(grade);
		System.out.print("반 :");
		classRoom = sc.nextInt();
		inputStudent.setClassRoom(classRoom);
		sc.nextLine();
		System.out.print("주소 :");
		address = sc.nextLine();
		inputStudent.setAddress(address);
		System.out.print("전화번호 :");
		phone = sc.nextLine();
		inputStudent.setPhone(phone);
		System.out.print("성별 :");
		gender = sc.next().charAt(0);
		inputStudent.setGender(gender);
		System.out.print("키 :");
		height = sc.nextDouble();
		inputStudent.setHeight(height);
		System.out.print("몸무게 :");
		weight = sc.nextDouble();
		inputStudent.setWeight(weight);
		
//		System.out.println(inputStudent.infoStudent());
		return inputStudent;
		
	}
	public void searchStudentView (String list) {
		System.out.println("========== 학생 조회 결과 ==========");
		System.out.println(list);
		System.out.println("================================");
	}
	
	public int searchStudentByNoView () {
		System.out.println("========== 학생 번호로 조회 ==========");
		System.out.print("번호 : ");
		return sc.nextInt();
	}
	
	public int searchStudentByGradeView () {
		System.out.println("========== 학년으로 조회 ==========");
		System.out.print("학년 : ");
		return sc.nextInt();
	}
	
	public String searchStudentByNameView () {
		System.out.println("========== 이름으로 조회 ==========");
		System.out.print("이름 : ");
		return sc.next();
	}
	
	public void printMessage(String msg) {
		System.out.println("========== 알림메세지 ==========");
		System.out.println(msg);
		System.out.println("=============================");
	}
	
	public int updateStudentListView(String list) {
		System.out.println("========== 수정 페이지 ==========");
		System.out.println(list);
		System.out.println("==============================");
		System.out.println("수정할 학생 번호를 입력해주세요.");
		return sc.nextInt();
	}
	
	public int deleteStudentListView(String list) {
		System.out.println("========== 삭제 페이지 ==========");
		System.out.println(list);
		System.out.println("==============================");
		System.out.println("삭제할 학생 번호를 입력해주세요.");
		return sc.nextInt();
	}
	
	public void editStudentView(Student s) {
//		System.out.println("현재 이름 : "+s.getName());
//		System.out.print("바꿀 이름 : ");
//		String name = sc.next();
//		s.setName(name);
//		
		System.out.println("현재 학년 : "+s.getGrade());
		System.out.print("바꿀 학년 : ");
		int grade = sc.nextInt();
		s.setGrade(grade);
		
		System.out.println("현재 반 : "+s.getClassRoom());
		System.out.print("바꿀 반 : ");
		int classRoom = sc.nextInt();
		s.setClassRoom(classRoom);
		
		System.out.println("현재 주소 : "+s.getAddress());
		System.out.print("바꿀 주소 : ");
		String address = sc.next();
		s.setAddress(address);
		
		System.out.println("현재 전화번호 : "+s.getPhone());
		System.out.print("바꿀 전화번호 : ");
		String phone = sc.next();
		s.setPhone(phone);
		
//		System.out.println("현재 성별 : "+s.getGrade());
//		System.out.print("바꿀 성별 : ");
//		char gender = sc.next().charAt(0);
//		s.setGender(gender);
//		
//		System.out.println("현재 키 : "+s.getGrade());
//		System.out.print("바꿀 키 : ");
//		double h = sc.nextDouble();
//		s.setHeight(h);
//		
//		System.out.println("현재 몸무게 : "+s.getGrade());
//		System.out.print("바꿀 몸무게 : ");
//		double w = sc.nextDouble();
//		s.setGrade(grade);
//		
		
		
	}
}
