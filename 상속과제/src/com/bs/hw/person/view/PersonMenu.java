package com.bs.hw.person.view;

import java.util.Scanner;

import com.bs.hw.person.controller.PersonController;

public class PersonMenu{
	// 필드
	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController();
	public void mainMenu() {
	// M과 N에 들어가는 숫자는 PersonController(pc)클래스에 있는
		while(true) {
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			int sCount = pc.personCount()[0];
			System.out.println("현재 저장된 학생은 "+sCount+"명입니다.");

			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			int eCount = pc.personCount()[1];
			System.out.println("현재 저장된 사원은 "+eCount+"명입니다.");
					
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.println("메뉴 번호 :");
		
			int input = sc.nextInt();
			switch(input) {
			case 1 : studentMenu(); break;
			case 2 : employeeMenu(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}	
		}
	}
	public void studentMenu(){
	// 만일 학생 객체 배열에 담긴 데이터의 수가 3개 일 때
	// “학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상
	// 활성화 되지 않습니다.”를 출력 후 메뉴 번호를 담음
	// 실제로 1번을 누르면 “잘못 입력하셨습니다. 다시 입력해주세요.”를 출력
	// 학생 객체 배열에 담긴 데이터의 수가 3개가 아닐 때는
	// 위에 출력한 메뉴 모두 받을 수 있게 함
	// 잘못 입력했을 경우,“잘못 입력하셨습니다. 다시 입력해주세요.” 출력 후 반복
		while(true) {
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.println("메뉴 번호 :");
			int input = sc.nextInt();
			switch(input) {
			case 1 : insertStudent(); return;
			case 2 : printStudent(); return;
			case 9 : System.out.println("메인메뉴로 돌아갑니다.");return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}
		}
	}
		
	public void employeeMenu(){
//	1. 사원 추가 è insertEmployee()
//	2. 사원 보기 è printEmployee()
//	9. 메인으로 è “메인으로 돌아갑니다.” 출력 후 메인으로
//	// 만일 사원 객체 배열에 담긴 데이터의 수가 10개 일 때
//	// “사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더 이상
//	// 활성화 되지 않습니다.
//	”를 출력 후 메뉴 번호를 담음
//	// 실제로 1번을 누르면 “잘못 입력하셨습니다. 다시 입력해주세요.
//	”를 출력
//	// 사원 객체 배열에 담긴 데이터의 수가 10개가 아닐 때는
//	// 위에 출력한 메뉴 모두 받을 수 있게 함
//	메뉴 번호 :
//	// 잘못 입력했을 경우,
//	“잘못 입력하셨습니다. 다시 입력해주세요.” 출력 후 반복
		while(true) {
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.println("메뉴 번호 :");
			int input = sc.nextInt();
			switch(input) {
			case 1 : insertEmployee(); return;
			case 2 : printEmployee(); return;
			case 9 : System.out.println("메인메뉴로 돌아갑니다.");return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}
		}
	}
	public void insertStudent(){
		
	// 위의 데이터를 모두 사용자에게 입력 받아 pc의 insertStudent()메소드의
	// 매개변수로 넘겨 줌
	// 이 때 학생 객체 배열에 담긴 데이터의 수가 3개가 되지 않았을 때는
	// “그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : “를 출력해
	// N 또는 n이 아니면 위의 데이터를 받는 것을 반복하고
	// N 또는 n이라면 반복을 멈춤
	// 만일 학생 객체 배열에 담긴 데이터의 수가 3이 되었을 때는
	// “학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고
	// 학생 메뉴로 돌아갑니다.”를 출력 후 반복 종료
		int sCount = pc.personCount()[0];
		if(sCount == 3) {
			return;
		}
		while(true){
			String name, major;
			double height,weight;
			int age,grade;
			boolean dupId = false;
			sc.nextLine();
			System.out.println("학생 이름 :");
			name = sc.nextLine();
			System.out.println("학생 나이 :");
			age = sc.nextInt();
			System.out.println("학생 키 :");
			height = sc.nextDouble();
			System.out.println("학생 몸무게 :");
			weight= sc.nextDouble();
			System.out.println("학생 학년 :");
			grade = sc.nextInt();
			System.out.println("학생 전공 :");
			sc.nextLine();
			major = sc.nextLine();
			pc.insertStudent(name,age,height,weight,grade,major);
			System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char input = sc.next().charAt(0);
			if(input!='n'&& input!='N') {
				sCount = pc.personCount()[0];
				if(sCount == 3) {
					break;
				}
			}else {
				break;
			}
		}
			
	}
	public void printStudent(){
	// pc의 printStudent() 메소드의 반환 값을 이용하여 학생 객체 배열에 저장된
	// 모든 데이터 출력
	}
	public void insertEmployee(){
	// 위의 데이터를 모두 사용자에게 입력 받아 pc의 insertEmployee()메소드의
	// 매개변수로 넘겨 줌
	// 이 때 사원 객체 배열에 담긴 데이터의 수가 10개가 되지 않았을 때는
	// “그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : “를 출력해
	// N 또는 n이 아니면 위의 데이터를 받는 것을 반복하고
	// N 또는 n이라면 반복을 멈춤
	// 만일 사원 객체 배열에 담긴 데이터의 수가 10이 되었을 때는
	// “사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고
	// 사원 메뉴로 돌아갑니다.”를 출력 후 반복 종료

		
		int eCount = pc.personCount()[1];
		if(eCount == 10) {
			return;
		}
		while(true){
			String name, dept;
			double height,weight;
			int age,salary;
			boolean dupId = false;
			sc.nextLine();
			System.out.println("사원 이름 :");
			name = sc.nextLine();
			System.out.println("사원 나이 :");
			age = sc.nextInt();
			System.out.println("사원 키 :");
			height = sc.nextDouble();
			System.out.println("사원 몸무게 :");
			weight= sc.nextDouble();
			System.out.println("사원 급여 :");
			salary = sc.nextInt();
			System.out.println("사원 부서 :");
			sc.nextLine();
			dept = sc.nextLine();
			pc.insertEmployee(name,age,height,weight,salary,dept);
			System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char input = sc.next().charAt(0);
			if(input!='n'&& input!='N') {
				eCount = pc.personCount()[1];
				if(eCount == 10) {
					break;
				}
			}else {
				break;
			}
		}
	}
	public void printEmployee(){
	// pc의 printEmployee() 메소드의 반환 값을 이용하여 사원 객체 배열에 저장된
	// 모든 데이터 출력
	}
	}