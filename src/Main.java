import java.util.ArrayList;
import java.util.List;

import Management.KlassManager;
import Management.QueryManager;
import Management.StudentManager;
import model.Klass;
import model.Student;

public class Main {
	static KlassManager klassManager = KlassManager.getInstance();
	static StudentManager studentManager = StudentManager.getInstance();
	static QueryManager queryManager = QueryManager.getInstance();

	public static void main(String[] args) {
		//do setup		
		setup();

		System.out.println();
		System.out.println("Details for common students to all class pairs are following :");
		System.out.println();

		//run query
		queryManager.findCommonStudentToAllPairsOfKlasses();

	}
	
	// set up with basic data present
	private static void setup(){
		addKlasses();
		addStudents();

		List<String> students = new ArrayList<String>();
		students.add("S1");
		students.add("S2");
		students.add("S4");
		students.add("S5");
		try {
			queryManager.registerStudentToKlass("C1", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		students.clear();
		students.add("S1");
		students.add("S2");
		students.add("S3");
		try {
			queryManager.registerStudentToKlass("C2", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		students.clear();
		students.add("S1");
		students.add("S3");
		students.add("S4");
		students.add("S5");
		try {
			queryManager.registerStudentToKlass("C3", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		students.clear();
		students.add("S4");
		students.add("S5");
		try {
			queryManager.registerStudentToKlass("C4", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		students.clear();
		students.add("S4");
		students.add("S3");
		try {
			queryManager.registerStudentToKlass("C5", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addKlasses() {
		for (int i = 1; i < 6; i++) {
			Klass klass = new Klass("C" + i);
			try {
				klassManager.addKlass(klass);
				System.out.println("Class " + klass.getKlassId() + " added successfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void addStudents() {
		for (int i = 1; i < 6; i++) {
			Student student = new Student("S" + i);
			try {
				studentManager.registerStudent(student);
				System.out.println("Studdent " + student.getRollNumber() + " added sucessfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
