package reflection.method;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetReturnTypeFromMember {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		GetReturnTypeFromMember rt = new GetReturnTypeFromMember();
		System.out.println(rt.returnType());
	}

	public List<Integer> getAll() {
		return new ArrayList<Integer>();
	}

	public String returnType() throws SecurityException, NoSuchMethodException {
		Class typeArgClass = null;
		Method m = this.getClass().getMethod("getAll");
		ParameterizedType pt = (ParameterizedType) m.getGenericReturnType();
		for (Type typeArgument : pt.getActualTypeArguments()) {
			typeArgClass = (Class) typeArgument;
		}
		return typeArgClass.getSimpleName();
	}

}
