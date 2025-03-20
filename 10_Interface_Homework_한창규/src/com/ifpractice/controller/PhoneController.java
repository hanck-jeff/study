package com.ifpractice.controller;

import com.ifpractice.model.vo.GalaxyNote9;
import com.ifpractice.model.vo.Phone;
import com.ifpractice.model.vo.V40;

public class PhoneController {
//	 -result:String[] = new String[2];
//	 + method() : String[]
	private String[] result = new String[2];
	public String[] method() {
		
		Phone[] phones = new Phone[] {new GalaxyNote9(), new V40()};
		int i = 0;
		for(Phone p : phones) {
			if(p instanceof GalaxyNote9) {
				result[i] = ((GalaxyNote9)p).printInformation();
			}else {
				result[i] = ((V40)p).printInformation();
			}
			i++;
		}
		
		return result;
		
	}
}
