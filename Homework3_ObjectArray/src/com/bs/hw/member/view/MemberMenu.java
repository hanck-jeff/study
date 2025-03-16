package com.bs.hw.member.view;

import java.util.Scanner;

import com.bs.hw.member.controller.MemberController;
import com.bs.hw.member.model.vo.Member;


public class MemberMenu{
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	// 멤버 필드
	public void mainMenu() {
		
		while(true) {
			System.out.println("최대 등록 가능한 회원 수는 10명입니다.");
			int memberCount = mc.existMemberNum();
			System.out.println("현재 등록된 회원 수는 "+memberCount+"명입니다.");
				
			if (memberCount !=10) {
				System.out.println("1. 새 회원 등록");
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.println("0. 더미회원 입력");
				System.out.println("메뉴 번호 :");	
			}else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.println("메뉴 번호 :");
			}
			int input = sc.nextInt();
			switch(input) {
			case 1 : 
				if(memberCount!=10) {
					insertMember(); break;
				}
				else {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
				}
			case 2 : searchMember(); break;
			case 3 : updateMember(); break;
			case 4 : deleteMember(); break;
			case 5 : printAll(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); return;
			case 0 : insertDummy(); break;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}	
		}
		
	}
	public void insertMember(){
		String id, name, password, email;
		char gender;
		int age;
		boolean dupId = false;
		sc.nextLine();
		do {

			System.out.print("아이디 :");
			id = sc.next();
			dupId = mc.checkId(id);
			if(!dupId) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}	
		}while(!dupId);
		sc.nextLine();
		System.out.print("이름 :");
		name = sc.nextLine();
		System.out.print("비밀번호 :");
		password = sc.nextLine();
		System.out.print("이메일 :");
		email = sc.nextLine();
		
		boolean genderCheck = false;
		do {
			System.out.print("성별(M/F) :");
			gender = sc.next().charAt(0);
			if(gender == 'm'||gender == 'M'||gender == 'f'||gender == 'F') {
				genderCheck = true;
			}else {
				System.out.println("성별을 다시 입력하세요.");
			}
		}
		while(!genderCheck);
		
		System.out.print("나이 :");
		age = sc.nextInt();
		mc.insertMember(id, name, password, email, gender, age);
		
	}
	public void searchMember(){
		while(true) {
			System.out.println("1. 아이디로 검색하기");
			System.out.println("2. 이름으로 검색하기");
			System.out.println("3. 이메일로 검색하기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.println("메뉴 번호 :");
			int input = sc.nextInt();
			switch(input) {
			case 1 : searchId(); return;
			case 2 : searchName(); return;
			case 3 : searchEmail(); return;
			case 9 : System.out.println("메인메뉴로 돌아갑니다.");return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}
		}
	}
	public void searchId(){
		sc.nextLine();
		System.out.print("검색할 아이디 :");
		String input = sc.nextLine();
		String result = mc.searchId(input);
		if(!result.equals("")) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(result);	
		}else {
			System.out.println("검색 결과가 없습니다.");
		}
		
	}
	public void searchName(){
		sc.nextLine();
		System.out.print("검색할 이름 :");
		String input = sc.nextLine();
		Member[] result = mc.searchName(input);
		if(result.length != 0) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member m: result) {
				System.out.println(m.inform());	
			}
		}else {
			System.out.println("검색 결과가 없습니다.");
		}
		
	}
	public void searchEmail(){
		sc.nextLine();
		System.out.print("검색할 이메일 :");
		String input = sc.nextLine();
		Member[] result = mc.searchEmail(input);
		if(result.length != 0) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member m: result) {
				System.out.println(m.inform());	
			}
		}else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	public void updateMember(){
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println("메뉴 번호 :");
		int input = sc.nextInt();
		switch(input) {
		case 1 : updatePassword(); break;
		case 2 : updateName(); break;
		case 3 : updateEmail(); break;
		case 9 : System.out.println("메인메뉴로 돌아갑니다.");return;
		default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
		}
	}
	public void updatePassword(){
	// 수정할 회원 id와 비밀번호를 사용자에게 입력 받고 입력 받은 데이터를
	// mc의 updatePassword() 메소드의 매개변수로 넘김, 반환 값에 따라
	// 검색결과 없으면 “존재하지 않는 아이디입니다.” 출력, mainMenu()로 감
	// 검색 결과가 있으면 “수정이 성공적으로 되었습니다.” 출력 후
	// mainMenu()로 돌아감
		sc.nextLine();
		System.out.print("수정할 회원의 아이디 :");
		String inputId = sc.nextLine();

		System.out.print("수정할 회원의 비밀번호 :");
		String inputPw = sc.nextLine();
		boolean result = mc.updatePassword(inputId,inputPw);
		
		if(result) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	public void updateName(){
	// 수정할 회원 id와 이름을 사용자에게 입력 받고 입력 받은 데이터를
	// mc의 updateName() 메소드의 매개변수로 넘김, 반환 값에 따라
	// 검색결과 없으면 “존재하지 않는 아이디입니다.” 출력, mainMenu()로 감
	// 검색 결과가 있으면 “수정이 성공적으로 되었습니다.” 출력 후
	// mainMenu()로 돌아감
		sc.nextLine();
		System.out.print("수정할 회원의 아이디 :");
		String inputId = sc.nextLine();

		System.out.print("수정할 회원의 이름 :");
		String inputName = sc.nextLine();
		boolean result = mc.updateName(inputId,inputName);
		
		if(result) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		
	}
	public void updateEmail(){
	// 수정할 회원 id와 이메일을 사용자에게 입력 받고 입력 받은 데이터를
	// mc의 updateEmail() 메소드의 매개변수로 넘김, 반환 값에 따라
	// 검색결과 없으면 “존재하지 않는 아이디입니다.” 출력, mainMenu()로 감
	// 검색 결과가 있으면 “수정이 성공적으로 되었습니다.” 출력 후
	// mainMenu()로 돌아감
		sc.nextLine();
		System.out.print("수정할 회원의 아이디 :");
		String inputId = sc.nextLine();

		System.out.print("수정할 회원의 이름 :");
		String inputEmail = sc.nextLine();
		boolean result = mc.updateName(inputId,inputEmail);
		
		if(result) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}		
	}
	public void deleteMember(){
//	1. 특정 회원 삭제하기 è deleteOne()
//	2. 모든 회원 삭제하기 è deleteAll()
//	9. 메인으로 돌아기기
	// 메뉴 번호에 따라 각 메소드로 이동되며 9번을 입력했을 경우
	// “메인으로 돌아갑니다.” 출력 후 mainMenu()로 돌아감
	// 메뉴 번호를 잘못 입력했을 경우 “잘못 입력하셨습니다.” 출력 후
	// mainMenu()로 돌아감
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println("메뉴 번호 :");
		int input = sc.nextInt();
		switch(input) {
		case 1 : deleteOne(); break;
		case 2 : deleteAll(); break;
		case 9 : System.out.println("메인메뉴로 돌아갑니다.");return;
		default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
		}
	}
	public void deleteOne(){
	// 삭제할 회원 id를 사용자에게 입력 받고 정말 삭제할 것인지 사용자에게
	// 물어본 뒤, Y나 y를 사용자가 입력할 경우 입력 받은 id를
	// mc의 delete() 메소드의 매개변수로 넘김, 반환 값에 따라
	// 검색결과 없으면 “존재하지 않는 아이디입니다.” 출력, mainMenu()로 감
	// 검색 결과가 있으면 “성공적으로 삭제하였습니다.” 출력 후
	// mainMenu()로 돌아감
		sc.nextLine();
		System.out.print("삭제할 회원의 아이디 :");
		String inputId = sc.nextLine();
		System.out.print("정말 삭제하시겠습니까? (Y/N) :");
		String inputYn = sc.next();
		if(inputYn.equals("y") || inputYn.equals("Y")) {
			boolean result = mc.delete(inputId);
			if(!result) {
				System.out.println("성공적으로 삭제하였습니다.");
			}else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}  
				
	}
	public void deleteAll(){
		// 정말 삭제할 것인지 사용자에게 물어본 뒤, Y나 y를 사용자가 입력할 경우
		// 	mc의 delete() 메소드 호출,
		//	“성공적으로 삭제하였습니다.” 출력 후
		// mainMenu()로 돌아감
		sc.nextLine();
		System.out.print("정말 모든 회원을 삭제하시겠습니까? (Y/N) :");
		String inputYn = sc.next();
		if(inputYn.equals("y") || inputYn.equals("Y")) {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}
	public void printAll(){
		// mc의 printAll() 메소드의 반환 값을 가지고 저장된 회원을 출력하는데
		// 저장된 회원의 수가 0명이면 “저장된 회원이 없습니다.” 출력,
		// 0명이 아니면 저장된 모든 회원의 정보 출력
		Member[] member = mc.printAll();
		int nullCount = 0;
		for(Member m: member) {
			if(m != null) {
				System.out.println(m.inform());	
			}else {
				nullCount ++;
			}
		}
		if(nullCount == mc.SIZE) {
			System.out.println("저장된 회원이 없습니다.");
		}
		
	}
	
	public void insertDummy() {
		mc.insertDummy();
	}
}
