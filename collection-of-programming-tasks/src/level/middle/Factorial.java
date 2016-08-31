/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package level.middle;

import java.util.function.Function;

public class Factorial {

    public static void main(String[] args) {
        int k = 0;
        int n = 10;
        System.out.printf("Factorial number from %s to %s, recursive approach:", k, n);
        print_fac_from_to(k, n, Factorial::factorial_recursive);
        System.out.printf("\nFactorial number from %s to %s, iterative approach:", k, n);
        print_fac_from_to(k, n, Factorial::factorial_iterative);
    }

    private static long factorial_recursive(final int n) {
        if (n < 1)
            return 1;
        else
            return n * factorial_recursive(n - 1);
    }

    private static long factorial_iterative(final int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static void print_fac_from_to(final int k, final int n, final Function<Integer, Long> factorial) {
        for (int i = k; i <= n; i++) {
            long result = factorial.apply(i);
            System.out.printf("\nFactorial from %s is %s", i, result);
        }
    }

}
