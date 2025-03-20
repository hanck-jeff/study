package practice3.model.vo;

public abstract class Animal {
	
	private String name;
	private String kinds;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String name, String kind) {
		super();
		this.name = name;
		this.kinds = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kinds;
	}

	public void setKind(String kinds) {
		this.kinds = kinds;
	}

	@Override
	public String toString() {
		return "저의 이름은 " + name + "이고, 종류는 " + kinds + "입니다.";
	}
	
	abstract void speak();
	

}
