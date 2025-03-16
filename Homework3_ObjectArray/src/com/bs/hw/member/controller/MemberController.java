package com.bs.hw.member.controller;

import com.bs.hw.member.model.vo.Member;

public class MemberController {
	
	public final int SIZE = 10;
	
	private Member[] member = new Member[SIZE];
	
	
	public int existMemberNum() {
		int count = 0;
		for(Member m : member) {
			if(m != null) {
				count ++;
			}
		}
		return count;
	}
	
	public Boolean checkId(String inputId) {
		for(Member m : member) {
			if(m != null && m.getId().equals(inputId)) {
				return false;		
			}
		}
		return true;
	}
	
	public void insertMember(String id,String name,String password,String email,char gender,int age)  {
		Member newMember = new Member(id,name,password,email,gender,age);
		
		for(int i=0;i<member.length ;i++) {
			if(member[i] == null) {
				member[i] = newMember;
				break;
			}
		}
		
	}
	
	public String searchId(String id){
		String result = "";
		for(Member m : member) {
			if(m!=null && m.getId().equals(id)) {
				result += m.inform();
			}
		}
		return result;
	}
	
	public Member[] searchName(String name)  {
		int count = 0;
		for(Member m : member) {
			if(m!=null && m.getName().equals(name)) {
				count++;
			}
		}
		Member[] memberResult = new Member[count];
		int i = 0;
		for(Member m : member) {
			if(m!=null && m.getName().equals(name)) {
				memberResult[i] = m;
				i++;
			}
		}
		return memberResult;
	}
	
	public Member[] searchEmail(String email)  {
		int count = 0;
		for(Member m : member) {
			if(m!=null && m.getEmail().equals(email)) {
				count++;
			}
		}
		Member[] memberResult = new Member[count];
		int i = 0;
		for(Member m : member) {
			if(m!=null && m.getEmail().equals(email)) {
				memberResult[i] = m;
				i++;
			}
		}
		return memberResult;
	}
	
	public Boolean updatePassword(String id,String password) {
		for(int i=0; i<member.length; i++) {
			if(member[i]!=null && member[i].getId().equals(id)) {
				member[i].setPassword(password);
				return true;
			}
		}
		return false;
	}
	
	public Boolean updateName(String id,String name) {
		for(int i=0; i<member.length; i++) {
			if(member[i]!=null && member[i].getId().equals(id)) {
				member[i].setName(name);
				return true;
			}
		}
		return false;
	}
	
	public Boolean updateEmail(String id,String email) {
		for(int i=0; i<member.length; i++) {
			if(member[i]!=null && member[i].getId().equals(id)) {
				member[i].setEmail(email);
				return true;
			}
		}
		return false;
	}
	
	public Boolean delete(String id) {
		for(int i=0; i<member.length; i++) {
			if(member[i]!=null && member[i].getId().equals(id)) {
				member[i]=null;
				return true;
			}
		}
		return false;
		
	}
	
	public void delete()  {
		member = new Member[SIZE];
	}
	
	public Member[] printAll()  {
		return this.member;
	}
	
	public void insertDummy() {
		member = new Member[]{
			new Member("aaaaa", "박신우", "aa", "aaa@aaa.aaa", 'F', 33),
			new Member("bbbbb", "강고결", "bb", "bbb@bbb.bbb", 'm', 34),
			new Member("ccccc", "남나눔", "cc", "ccc@ccc.ccc", 'M', 28),
			new Member("ddddd", "도대담", "dd", "ddd@ddd.ddd", 'M', 35),
			new Member("eeeee", "류라라", "ee", "eee@eee.eee", 'f', 17),
			new Member("fffff", "문미미", "ff", "fff@fff.fff", 'F', 20),
			new Member("ggggg", "박보배", "gg", "ggg@ggg.ggg", 'm', 26),
			new Member("hhhhh", "송성실", "hh", "hhh@hhh.hhh", 'm', 41),
			new Member("iiiii", "윤예의", "ii", "iii@iii.iii", 'F', 28),
			new Member("jjjjj", "정재주", "jj", "jjj@jjj.jjj", 'M', 23)
		};
	}
	
	

}
