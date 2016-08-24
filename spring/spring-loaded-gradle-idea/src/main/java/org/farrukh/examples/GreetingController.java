/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "Hello My World!";
    }

    @RequestMapping("/some")
    public String someResponse() {
        return "Some data";
    }

    @RequestMapping("/other")
    public String otherResponse() {
        return "Other data dsds";
    }

}
