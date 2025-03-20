package com.bs.practice.point.view;

import java.util.Scanner;

public class PointMenu{
	
		// 필드
	Scanner sc = new Scanner(System.in);
	public void mainMenu() {
		while(true) {
			
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.println("메뉴 번호 :");
		
			int input = sc.nextInt();
			switch(input) {
			case 1 : circleMenu(); break;
			case 2 : retangleMenu(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}	
		}
		
	}
			
	public void circleMenu(){
//		===== 원 메뉴 =====
//		1. 원 둘레 è calcCircum()
//		2. 원 넓이 è calcCircleArea()
//		9. 메인으로
//		메뉴 번호 :
		while(true) {
			
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.println("메뉴 번호 :");
			int input = sc.nextInt();
			switch(input) {
			case 1 : calcCircum(); return;
			case 2 : calcCircleArea(); return;
			case 9 : System.out.println("메인메뉴로 돌아갑니다.");return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}	
		}
	}
		public void retangleMenu() {
//		===== 메뉴 =====
//		1. 사각형 둘레 è calcPerimeter()
//		2. 사각형 넓이 è calcRectArea()
//		3. 메인으로
//		메뉴 번호 :
			while(true) {
				
				System.out.println("1. 원 둘레");
				System.out.println("2. 원 넓이");
				System.out.println("9. 메인으로");
				System.out.println("메뉴 번호 :");
				int input = sc.nextInt();
				switch(input) {
				case 1 : calcPerimeter(); return;
				case 2 : calcArea(); return;
				case 9 : System.out.println("메인메뉴로 돌아갑니다.");return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
				}	
			}
			
		}
		public void calcCircum(){
//		x 좌표 :
//		y 좌표 :
//		반지름 :
		// 데이터를 CircleController(cc)의 calcCircum()의 매개변수로 보내 반환 값 출력
			sc.nextLine();
			System.out.print("x 좌표 :");
			int inputX = sc.nextInt();
			System.out.print("x 좌표 :");
			int inputY = sc.nextInt();
			System.out.print("반지름 :");
			int inputR = sc.nextInt();
		}
		public void calcCircleArea(){
//		x 좌표 :
//		y 좌표 :
//		반지름 :
		// 데이터를 CircleController(cc)의 calcArea()의 매개변수로 보내 반환 값 출력
			sc.nextLine();
			System.out.print("x 좌표 :");
			int inputX = sc.nextInt();
			System.out.print("x 좌표 :");
			int inputY = sc.nextInt();
			System.out.print("반지름 :");
			int inputR = sc.nextInt();
			
		}
		public void calcPerimeter(){
//		x 좌표 :
//		y 좌표 :
//		높이 :
//		너비 :
		// 데이터를 RectangleController(rc) calcPerimeter()의 매개변수로 보내 반환값 출력
			sc.nextLine();
			System.out.print("x 좌표 :");
			int inputX = sc.nextInt();
			System.out.print("x 좌표 :");
			int inputY = sc.nextInt();
			System.out.print("높이 :");
			int inputH = sc.nextInt();
			System.out.print("너비 :");
			int inputW = sc.nextInt();
			
		}
		public void calcArea(){ //calcPerimeter
//		x 좌표 :
//		y 좌표 :
//		높이 :
//		너비 :
		// 데이터를 RectangleController(rc) calcArea()의 매개변수로 보내 반환값 출력
			sc.nextLine();
			System.out.print("x 좌표 :");
			int inputX = sc.nextInt();
			System.out.print("x 좌표 :");
			int inputY = sc.nextInt();
			System.out.print("높이 :");
			int inputH = sc.nextInt();
			System.out.print("너비 :");
			int inputW = sc.nextInt();
		}
}

