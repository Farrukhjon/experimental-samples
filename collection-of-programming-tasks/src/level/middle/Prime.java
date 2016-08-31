/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package level.middle;

public class Prime {

    public static void main(String[] args) {
        int k = 1;
        int n = 100;

        print_primes(k, n);
    }

    private static void print_primes(final int k, final int n) {
        for (int i = k; i <= n; i++) {
            if (isPrime(i)){
                System.out.printf(" %s ", i);
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n > 1) {
            int m = n / 2;
            for (int i = 2; i < m; i++) {
                if (n % i == 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

}
