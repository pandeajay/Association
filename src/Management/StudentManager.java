package Management;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Student;

public class StudentManager {

	static StudentManager studentManager;

	// Map will help in quick lookup and other management
	private Map<String, Student> students = new HashMap<String, Student>();

	// only one instance for student management
	public static StudentManager getInstance() {
		if (studentManager == null) {
			studentManager = new StudentManager();
		}
		return studentManager;
	}

	// registers student
	public void registerStudent(Student student) throws Exception {
		if (students.containsKey(student.getRollNumber())) {
			throw new Exception(" Student " + student.getRollNumber() + " is already present");
		}
		students.put(student.getRollNumber(), student);
	}

	public boolean isStudentRegistered(String rollNumber) {
		return students.containsKey(rollNumber);
	}

	public Student getStudent(String rollNumber) {
		return students.get(rollNumber);
	}

	public List<Student> getAllStudent() {
		List<Student> allStudent = new ArrayList<Student>();
		allStudent.addAll(students.values());
		return allStudent;

	}
	
	public List<String> getAllStudentIDs() {
		List<String> allStudent = new ArrayList<String>();
		allStudent.addAll(students.keySet());
		return allStudent;

	}

}
