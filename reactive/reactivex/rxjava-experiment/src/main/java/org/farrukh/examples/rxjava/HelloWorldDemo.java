/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.rxjava;

import rx.Observable;

public class HelloWorldDemo {

    public static void main(String[] args) {
        Observable.from(new Integer[]{0, 1, 2, 3, 4, 5, 6})
                  .subscribe(System.out::println);
    }

}
