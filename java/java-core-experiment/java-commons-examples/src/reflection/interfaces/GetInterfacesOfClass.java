package reflection.interfaces;

import java.util.LinkedList;

public class GetInterfacesOfClass {

	public static void main(String[] args) {
		Class<?> c = LinkedList.class;
		Class<?>[] interfaces = c.getInterfaces();
		for (Class<?> CInterfaces : interfaces) {
			System.out.println(CInterfaces.getName());
		}
	}
}
