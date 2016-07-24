package model;

public class Pair {
	
	String object1;
	String object2;
	
	public String getObject1() {
		return object1;
	}
	public void setObject1(String object1) {
		this.object1 = object1;
	}
	public String getObject2() {
		return object2;
	}
	public void setObject2(String object2) {
		this.object2 = object2;
	}
	
	public Pair(String object1, String object2) {
		super();
		this.object1 = object1;
		this.object2 = object2;
	}

}
