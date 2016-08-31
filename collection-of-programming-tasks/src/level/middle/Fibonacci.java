/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package level.middle;

import java.util.function.Function;

public class Fibonacci {

    public static void main(String[] args) {
        int k = 1;
        int n = 10;
        System.out.printf("\nFibonacci number from %s to %s, recursive approach", k, n);
        print_fac_from_to(k, n, Fibonacci::fibonacci_recursive);

        System.out.printf("\nFibonacci number from %s to %s, iterative approach", k, n);
        print_fac_from_to(k, n, Fibonacci::fibonacci_iterative);
    }

    private static long fibonacci_recursive(final int n) {
        if (n < 3)
            return 1;
        else
            return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
    }

    private static long fibonacci_iterative(final int n) {
        long fn = 0;
        long f1 = 1;
        long f2;
        for (int i = 1; i <= n; i++) {
            f2 = f1;
            f1 = fn;
            fn = f1 + f2;
        }
        return fn;
    }

    private static void print_fac_from_to(final int k, final int n, Function<Integer, Long> factorial) {
        for (int i = k; i <= n; i++) {
            long result = factorial.apply(i);
            System.out.printf("\nFibonacci number of %s is: %s", i, result);
        }
    }

}
