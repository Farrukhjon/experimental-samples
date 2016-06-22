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

package org.farrukh.example.repository;

import org.farrukh.example.domain.model.Address;
import org.farrukh.example.domain.model.Author;
import org.farrukh.example.domain.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private final List<Book> books = new ArrayList<>();

    public InMemoryBookRepository() {

        this.books.add(new Book(randomId(), "Java", authors1));
        this.books.add(new Book(randomId(), "JavaScript", authors2));
        this.books.add(new Book(randomId(), "HTML5 and CSS3", authors3));
    }

    private String randomId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public List<Book> findAll() {
        return this.books;
    }

    @Override
    public Book findOne(final String id) {
        return books.stream()
                    .filter(book -> Objects.equals(book.getId(), id))
                    .findFirst().get();
    }


}
