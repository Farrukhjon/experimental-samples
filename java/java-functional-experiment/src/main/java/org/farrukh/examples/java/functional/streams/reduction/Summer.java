package org.farrukh.examples.java.functional.streams.reduction;

import java.util.stream.IntStream;

public class Summer {

    public int sumByIteration(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    public int sumIntStreamSum(int[] numbers) {
        return IntStream
                .of(numbers)
                .sum();
    }

    public int sumStreamReduce(int[] numbers) {
        return IntStream
                .of(numbers)
                .reduce(0, (a, b) -> a + b); //IntBinaryOperator
    }

    public int sumStreamReduceRefMethod(int[] numbers) {
        return IntStream
                .of(numbers)
                .reduce(0, Integer::sum);
    }
}
