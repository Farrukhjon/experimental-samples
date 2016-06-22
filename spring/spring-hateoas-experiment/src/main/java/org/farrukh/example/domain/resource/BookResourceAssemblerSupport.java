/*
 * Copyright (c) 2015. Farrukhjon D. Sattorov firedandy@gmail.com.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.farrukh.example.domain.resource;

import org.farrukh.example.controller.BookController;
import org.farrukh.example.domain.model.Author;
import org.farrukh.example.domain.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BookResourceAssemblerSupport extends ResourceAssemblerSupport<Book, BookResource> {

    private final EntityLinks entityLinks;

    @Autowired
    public BookResourceAssemblerSupport(final EntityLinks entityLinks) {
        super(BookController.class, BookResource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public BookResource toResource(final Book book) {
        BookResource bookResource = createResourceWithId(book.getId(), book);
        bookResource.setBook(book);
        return bookResource;
    }

}
