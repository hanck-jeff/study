package com.student.model.dao;

import com.student.model.vo.Student;

//학생을 저장 관리하는 역할
public class StudentDao {
	private Student s,s1,s2; //필드가 세개면 세개 저장가능 ㅋ
	
	public boolean saveStudent(Student newStudent) {
//		if(this.s.getStudentNo()!=0)this.s = newStudent; 
		// 초기화가 된 상태가 아니기 때문에 // nullPointException
		if(s==null) { this.s = newStudent; }
		else if(s1==null) { this.s1 = newStudent; }
		else if(s2==null) {this.s2 = newStudent; }
		else { return false; }
		return true;
		
		
	}
	
	public String searchStudent() {
		String search = "";
		if(s!=null) search += s.infoStudent() + "\n";
		if(s1!=null) search += s1.infoStudent() + "\n";
		if(s2!=null) search += s2.infoStudent() + "\n";
		if(!search.equals("")) search = infoHeader() + search;
		
		return search;
	}
	
	public String searchUpdateStudent() {
		String search = "";
		
		if(s!=null) search += s.infoStudent() + "\n";
		if(s1!=null) search += s1.infoStudent() + "\n";
		if(s2!=null) search += s2.infoStudent() + "\n";
		if(!search.equals("")) search = infoHeader() + search;
		
		return search; 	
	}
	

	public String searchStudentByNo(int no) {
		String search = "";
		if(s!=null && s.getStudentNo() == no) search += s.infoStudent() + "\n";
		if(s1!=null && s1.getStudentNo() == no) search += s1.infoStudent() + "\n";
		if(s2!=null && s2.getStudentNo() == no) search += s2.infoStudent() + "\n";
		if(!search.equals("")) search = infoHeader() + search;
		return search; 	
	}
	

	public Student updateStudentByNo(int no) {
		Student result;
		if(s!=null && s.getStudentNo() == no) result = s;
		else if(s1!=null && s1.getStudentNo() == no) result = s1;
		else if(s2!=null && s2.getStudentNo() == no) result = s2;
		else return null;
		return result;
	}
	
	public boolean deleteStudentByNo(int no) {
		Student result;
		if(s!=null && s.getStudentNo() == no) s = null;
		else if(s1!=null && s1.getStudentNo() == no) s1 = null;
		else if(s2!=null && s2.getStudentNo() == no) s2 = null;
		else return false;
		return true;
	}

	public String searchStudentByGrade(int grade) {
		String search = "";
		if(s!=null && s.getGrade() == grade) search += s.infoStudent() + "\n";
		if(s1!=null && s1.getGrade() == grade) search += s1.infoStudent() + "\n";
		if(s2!=null && s2.getGrade() == grade) search += s2.infoStudent() + "\n";
		if(!search.equals("")) search = infoHeader() + search;
		return search; 	 	
	}
	
	public String searchStudentByName(String name) {
		String search = "";
		if(s!=null && s.getName().equals(name)) search += s.infoStudent() + "\n";
		if(s1!=null && s1.getName().equals(name)) search += s1.infoStudent() + "\n";
		if(s2!=null && s2.getName().equals(name)) search += s2.infoStudent() + "\n";
		if(!search.equals("")) search = infoHeader() + search;
		return search; 	
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
