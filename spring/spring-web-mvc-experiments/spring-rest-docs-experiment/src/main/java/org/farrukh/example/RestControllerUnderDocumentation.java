/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <firedandy@gmail.com>, May 2016.
 *
 */

package org.farrukh.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class RestControllerUnderDocumentation {

    @RequestMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return new Book(id, "My awesome book");
    }

}
