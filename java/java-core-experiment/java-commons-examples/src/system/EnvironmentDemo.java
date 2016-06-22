package system;

import java.util.Map;

public class EnvironmentDemo {

	public static void main(String[] args) {
		Map<String, String> environment  = System.getenv();
		for(String envKey: environment.keySet()){
			System.out.printf("%s=%s%n",envKey, environment.get(envKey));
		}
		System.out.println(System.getenv("ProgramFiles"));
	}
}
