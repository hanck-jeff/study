package practice3.controller;

import practice3.model.vo.Animal;
import practice3.model.vo.Cat;
import practice3.model.vo.Dog;

public class AnimalManager {
	
	static String[] names = {"나비","여름이","덕만이","춘식","상철이","흰둥이","까미","철민이","삐삐","유월이"};
	static String[] dogKind = {"진돗개","말티즈","시츄","허스키","삽살개"};
	static String[] catKind = {"코숏","샴","뱅갈","페르시안","스핑크스"};
	static String[] location = {"서울","대전","대구","부산","광주","울산","인천","여수","목포","김포"};
	static String[] color = {"흰색","회색","갈색","치즈","고등어","삼색"};
	
	
	public static void main(String[] args) {
		Animal[] animals = new Animal[5];
		for(Animal a: animals) {
			
			int randomNumber = (int)(Math.random() * 10) + 1;
			if(randomNumber%2==1) {
				a = new Dog(names[(int)(Math.random() * 9)],dogKind[(int)(Math.random() * 5)],(int)(Math.random() * 15)+1);
			}else {
				a = new Cat(names[(int)(Math.random() * 9)],catKind[(int)(Math.random() * 5)],location[(int)(Math.random() * 9)],color[(int)(Math.random() * 6)]);
			}
			speak(a);
		}
		
	}
	
	public static void speak(Animal a) {
		if (a instanceof Dog) {
			((Dog)a).speak();
		}else {
			((Cat)a).speak();
		}
		
	}
	

}
