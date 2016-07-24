package model;
import java.util.BitSet;
import java.util.List;

public class Student {

	// set bit as per the class registered
	private BitSet registredKlasses;
	
	// unique id of a student
	private String rollNumber;

	public Student(String rollNumber) {
		registredKlasses = new BitSet();
		registredKlasses.clear();
		this.rollNumber = rollNumber;
	}

	// register for a class
	public void registerForKlass(Klass klass) {
		registredKlasses.set(klass.getIndex() - 1);
	}
	
	// register for a class
	public void registerForKlass(String klass) {
		registredKlasses.set(Integer.parseInt(klass.substring(1, klass.length())));
	}

	
	//check if student is registered for classes specified
	public boolean isRegisteredForKlasses(List<String> klassList) {
		boolean isRegistered = true;
		for (String klass : klassList) {
			if (!registredKlasses.get(Integer.parseInt(klass.substring(1, klass.length())))) {
				isRegistered = false;
				break;
			}
		}
		return isRegistered;
	}

	public String getRollNumber() {
		return rollNumber;
	}

}
