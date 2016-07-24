package model;
import java.util.ArrayList;
import java.util.List;

public class Klass {
	private String klassId;
	List<String> studentList;

	public Klass(String klassId) {
		this.klassId = klassId;
		studentList = new ArrayList<String>();
	}

	public int getIndex() {
		return Integer.parseInt(klassId.substring(1, klassId.length()));
	}

	public String getKlassId() {
		return klassId;
	}

	public void registerStudent(String studentId) {
		studentList.add(studentId);

	}
}
