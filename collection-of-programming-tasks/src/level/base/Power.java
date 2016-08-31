/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package level.base;

import static java.lang.Math.pow;

public class Power {

    public static void main(String[] args) {
        double result = R(2, 100);
        System.out.printf("Result:" + result);
    }

    static double R(double t, double l) {
        return 3 * pow(t, 2) + 3 * pow(l, 5) + 4.9;
    }


}
