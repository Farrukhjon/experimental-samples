/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <firedandy@gmail.com>, May 2016.
 *
 */

package org.farrukh.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/*
To override the resources automatically exported using manual controllers the controllers written have to consider certain aspects to make sure,
they're not picked up by the standard Spring MVC handler mapping:
use @BasePathAwareController instead of @Controller or @RestController
not use @RequestMapping on the type level
see: https://jira.spring.io/browse/DATAREST-535
 */

@RepositoryRestController
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


}
