package Management;
import java.util.ArrayList;
import java.util.List;

import model.Pair;

public class QueryManager {

	private static QueryManager queryManager;
	StudentManager studentManager = StudentManager.getInstance();
	KlassManager klassManager = KlassManager.getInstance();

	public static QueryManager getInstance() {
		if (queryManager == null) {
			queryManager = new QueryManager();
		}
		return queryManager;
	}

	// find students which are common to specified classes
	public List<String> findCommonStudentToKlass(List<String> klasses) {
		List<String> commonStudent = new ArrayList<String>();
		List<String> allStudents = studentManager.getAllStudentIDs();
		for (String student : allStudents) {
			if (studentManager.getStudent(student).isRegisteredForKlasses(klasses)) {
				commonStudent.add(student);
			}
		}
		return findPairs(commonStudent);
	}

	// find student common to all possible pair of classes
	public void findCommonStudentToAllPairsOfKlasses() {
		List<Pair> klassPairs = findAllKlassPairs();
		for (Pair klassPair : klassPairs) {

			List<String> commonStudent = new ArrayList<String>();
			List<String> allStudents = studentManager.getAllStudentIDs();
			for (String student : allStudents) {
				List<String> klasses = new ArrayList<String>();
				klasses.add(klassPair.getObject1());
				klasses.add(klassPair.getObject2());
				if (studentManager.getStudent(student).isRegisteredForKlasses(klasses)) {
					commonStudent.add(student);
				}
			}

			// print the results for pair
			System.out.println(" For " + klassPair.getObject1() + "-" + klassPair.getObject2() + " : {"
					+ findPairs(commonStudent) + "}");
			System.out.println("");
		}

	}

	// prepare student pairs
	private List<String> findPairs(List<String> collection) {
		List<String> pairs = new ArrayList<String>();
		for (String record1 : collection) {
			for (String record2 : collection) {
				if (record1.equals(record2)) {
					continue;
				}
				if (collection.indexOf(record2) < collection.indexOf(record1)) {
					continue;
				}
				pairs.add("(" + record1 + "," + record2 + ")");
			}
		}
		return pairs;
	}

	// prepare all class pairs
	private List<Pair> findAllKlassPairs() {
		List<Pair> pairs = new ArrayList<Pair>();

		List<String> allKlasses = klassManager.getAllClasses();
		for (String klass1 : allKlasses) {

			for (String klass2 : allKlasses) {
				// avoid duplicate
				if (klass1.equals(klass2)) {
					continue;
				}

				// avoid duplicate
				if (allKlasses.indexOf(klass2) < allKlasses.indexOf(klass1)) {
					// ensure that no pair repeats
					continue;
				}

				pairs.add(new Pair(klass1, klass2));
			}
		}
		return pairs;
	}

	// register student to specified classes
	public void registerStudentToKlass(String klassId, List<String> students) throws Exception {
		if (klassManager.isKlassRegistreed(klassId)) {
			for (String student : students) {
				if (StudentManager.getInstance().isStudentRegistered(student)) {
					klassManager.getKlass(klassId).registerStudent(student);
					StudentManager.getInstance().getStudent(student).registerForKlass(klassId);
				}
			}
		} else {
			throw new Exception("Klass " + klassId + " was not found");
		}
	}
}
