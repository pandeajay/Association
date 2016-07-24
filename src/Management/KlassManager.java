package Management;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Klass;

public class KlassManager {
	private static KlassManager klassManager;
	private Map<String, Klass> klasses = new HashMap<String, Klass>();

	public void addKlass(Klass klass) throws Exception {
		if (klasses.containsKey(klass.getKlassId())) {
			throw new Exception("Klass " + klass.getKlassId() + " already exists");
		}
		klasses.put(klass.getKlassId(), klass);
	}

	public static KlassManager getInstance() {
		if (klassManager == null) {
			klassManager = new KlassManager();
		}
		return klassManager;
	}

	public List<String> getAllClasses() {
		List<String> allKlasses = new ArrayList<String>();
		allKlasses.addAll(klasses.keySet());
		return allKlasses;
	}

	public Klass getKlass(String klassId) {
		return klasses.get(klassId);
	}

	public boolean isKlassRegistreed(String klassId) {
		return klasses.containsKey(klassId);
	}
}
