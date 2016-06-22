package math;

public class Max {
	public static void main(String[] args) {
		// Даны числа a, b, c
		int a=11, b=20, c=30;
		max2(max1(a, b), c);
	}
	// Первый этап
	static int max1(int a, int b){
		if(a > b)
		return a;
		else if(a < b)
			return b;
		else return 0;
	}
	//Второй этап
	static void max2(int max, int c){
		if(max > c){
			System.out.println(max);
		}else if(max < c){
			System.out.println(c);
		}else System.out.println("Все числа равны");
	}
}
