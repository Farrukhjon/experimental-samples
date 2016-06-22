/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <firedandy@gmail.com>, May 2016.
 *
 */

package org.farrukh.example.domain.resource;

import lombok.Data;
import org.farrukh.example.domain.model.Book;
import org.springframework.hateoas.ResourceSupport;

@Data
public class BookResource extends ResourceSupport {

    private Book book;

}
