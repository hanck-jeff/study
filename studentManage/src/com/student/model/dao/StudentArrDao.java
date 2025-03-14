package com.student.model.dao;

import com.student.model.vo.Student;

public class StudentArrDao {
	private static StudentArrDao arrDao;
	private StudentArrDao() {}
	public static StudentArrDao studentArrDao() {
		if(arrDao==null) arrDao = new StudentArrDao();
		return arrDao;
	}
	
	private Student[] sArr = new Student[5]; //필드가 세개면 세개 저장가능

	
	public boolean saveStudent(Student newStudent) {	
		for(int i=0;i<sArr.length ;i++) {
			if(sArr[i] == null) {
				sArr[i] = newStudent;
				return true;
			}
		}
		return false;
	}

	public boolean saveStudent2(Student newStudent) {
		System.out.println(newStudent);
		for(Student s : sArr) { // 직접대입이 아닌 지역변수에 저장을 해버려서 안되는것... 접근자 .을 사용해서 수정해야함
			if(s == null) {
				s = newStudent;
				System.out.println(s);
				return true;
			}
			
		}
		return false;
	}
	
	public String searchStudent() {
		String search = "";
		for(Student s : sArr) {
			if(s!=null) search += s.infoStudent() + "\n";
		}
		if(!search.equals("")) search = infoHeader() + search;
		return search;
	}
	

	public Student[] searchStudent2() { // 배열로 리턴하는 법
		int count = 0;
		for(Student s : sArr) {
			if(s!=null) count ++;
		}
		Student[] result = new Student[count];
		for(Student s : sArr) {
			if(s!=null) count ++;
		}
		
		return result;
	}
	

	public String searchStudentByNo(int no) {
		String search = "";
		for(Student s : sArr) {
			if(s!=null && s.getStudentNo() == no) search += s.infoStudent() + "\n";	
		}
		if(!search.equals("")) search = infoHeader() + search;
		return search; 	
	}
	public String searchStudentByGrade(int grade) {
		String search = "";
		for(Student s : sArr) {
			if(s!=null && s.getGrade() == grade) search += s.infoStudent() + "\n";	
		}
		if(!search.equals("")) search = infoHeader() + search;
		return search; 	 	
	}
	
	public String searchStudentByName(String name) {
		String search = "";
		for(Student s : sArr) {
			if(s!=null && s.getName().equals(name)) search += s.infoStudent() + "\n";	
		}
		if(!search.equals("")) search = infoHeader() + search;
		return search; 	
	}

	public Student updateStudentByNo(int no) {
		Student result = new Student();
		for(Student s : sArr) {
			if(s!=null && s.getStudentNo() == no) {
				result = s;
				return result;
			}
		}
		return null;
	}
	
	public boolean deleteStudentByNo(int no) {
		for(int i=0;i<sArr.length ;i++) {
			if(sArr[i] != null && sArr[i].getStudentNo() == no) {
				sArr[i] = null;
				return true;
			}
		}
		return false;
		
	}
	
	private void changeData(Student ori, Student upd) {
		ori.setAddress(upd.getAddress());
		ori.setPhone(upd.getPhone());
		ori.setGrade(upd.getGrade());
		ori.setClassRoom(upd.getClassRoom());
	}
	
	public String infoHeader() {
		return "번호"+"\t"+
				"이름"+"\t"+
				"학년"+"\t"+
				"반"+"\t"+
				"주소"+"\t"+
				"휴대폰번호"+"\t"+
				"성별"+"\t"+
				"키"+"\t"+
				"몸무게"+"\n";		   
	}
	
	
}