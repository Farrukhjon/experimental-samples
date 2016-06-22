package classes.classLoader;

import java.lang.reflect.Field;

public class LoadClassExplicitly {

	public int	data	= 10;

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class clazz = null;
		try {
			clazz = Class.forName("classLoader.LoadClassExplicitly");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field f = clazz.getField("data");
	}

}
