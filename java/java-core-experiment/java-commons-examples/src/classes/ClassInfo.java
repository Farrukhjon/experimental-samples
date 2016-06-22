package classes;

import java.util.HashMap;
import java.util.Map;

public class ClassInfo {

	private static class Info {
	}

	public static void main(String[] args) {
		Map<String, String> map = getClassInfo(Info.class);
		for (String s : map.keySet()) {
			System.out.print(s + " ");
			System.out.println(map.get(s));
		}
	}

	private static Map<String, String> getClassInfo(Class<?> cl) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", cl.getName());
		map.put("simpleName", cl.getSimpleName());
		return map;
	}
}
