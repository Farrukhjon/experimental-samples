package recursion;

import org.farrukh.examples.algorithms.recursion.binaryRecursion.Fibonacci;
import org.farrukh.examples.algorithms.util.Stopwatch;

public class MeasuringFibonacci {

	public static void main(String[] args) {
		
		Stopwatch stopwatch1 = new Stopwatch();
		long value1 = Fibonacci.fiboRec(45);
		System.out.println("elapsed time for recursive fibonachi is: " + stopwatch1.elapsedTime() + " sec.");
		System.out.println("fibonachi from 45 is: " + value1);
		
		Stopwatch stopwatch2 = new Stopwatch();
		long value2 = Fibonacci.fiboIter(45);
		System.out.println("elapsed time for iterative fibonachi is: " + stopwatch2.elapsedTime() + " sec.");
		System.out.println("fibonachi from 45 is: " + value2);
	}

}
