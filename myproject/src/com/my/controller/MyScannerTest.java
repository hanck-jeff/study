package com.my.controller;

import java.util.Scanner;

public class MyScannerTest {
	public static void main(String[] args) {
		//이름 , 나이 , 성별 , 학년 , 반, 번호, 키, 주소, 이메일
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("입력한 값은 "+name);

		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println("입력한 값은 "+age);
		
		System.out.println("성별(남/여)을 입력하세요 : ");
		char gender = sc.next().charAt(0);
		System.out.println("입력한 값은 "+gender);
		
		System.out.println("학년을 입력하세요 : ");
		int grade = sc.nextInt();
		System.out.println("입력한 값은 "+grade);
		
		System.out.println("반을 입력하세요 : ");
		int classNumber = sc.nextInt();
		System.out.println("입력한 값은 "+classNumber);
		
		System.out.println("번호을 입력하세요 : ");
		int number = sc.nextInt();
		System.out.println("입력한 값은 "+number);
		
		System.out.println("키를 입력하세요 : ");
		double height = sc.nextDouble();
		System.out.println("입력한 값은 "+height);
		
		System.out.println("주소를 입력하세요 : ");
		sc.nextLine(); //개행쓰레기값을 없애기 위한 nextLine
		String address = sc.nextLine();
		System.out.println("입력한 값은 "+address);
		
		System.out.println("이메일 주소를 입력하세요 : ");
//		sc.nextLine(); //개행쓰레기값을 없애기 위한 nextLine
		String email = sc.nextLine();
		System.out.println("입력한 값은 "+email);
		
		String format = ("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t");
		System.out.printf(format,name,age,gender,grade,classNumber,number,height,address,email);
		
	}
}
