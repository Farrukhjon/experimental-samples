package classes.classLoader;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassLoaderTest {
	public static void main(String args[]) {
		try {
			// printing ClassLoader of this class
			System.out.println("ClassLoaderTest.getClass().getClassLoader() : " + ClassLoaderTest.class.getClassLoader());

			// trying to explicitly load this class again using Extension class
			// loader
			Class.forName("language.ClassLoaderTest", true, ClassLoaderTest.class.getClassLoader().getParent());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
