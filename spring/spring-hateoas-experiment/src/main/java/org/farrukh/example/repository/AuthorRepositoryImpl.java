/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <firedandy@gmail.com>, May 2016.
 *
 */

package org.farrukh.example.repository;

import org.farrukh.example.domain.model.Address;
import org.farrukh.example.domain.model.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class AuthorRepositoryImpl implements AuthorRepository {

    private final BookRepository bookRepository;

    private List<Author> authors = new ArrayList<>();

    public AuthorRepositoryImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        authors = Arrays.asList(
                new Author(randomId(), "Ali", "Valizoda", new Address()),
                new Author(randomId(), "Sami", "Olimzoda", new Address()),
                new Author(randomId(), "Shodi", "Hodizoda", new Address()),
                new Author(randomId(), "Gani", "Komilzoda", new Address()),
                new Author(randomId(), "Umri", "Kumrizoda", new Address()),
                new Author(randomId(), "Salim", "Gani", new Address()));
    }

    private String randomId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public List<Author> findAllAuthorsByBookId(final String bookId) {
        return bookRepository.findAll().stream()
                             .filter(book -> Objects.equals(book.getId(), bookId))
                             .findFirst()
                             .get()
                             .getAuthors();
    }

    @Override
    public Author findAuthorByBookId(final String bookId, final String id) {
        return bookRepository.findAll().stream()
                             .filter(book -> Objects.equals(book.getId(), bookId))
                             .findFirst().get().getAuthors()
                             .stream()
                             .filter(author -> Objects.equals(author.getId(), id))
                             .findFirst()
                             .get();
    }

    @Override
    public Author findOne(final String id) {
        return authors.stream()
                      .filter(author -> Objects.equals(author.getId(), id))
                      .findFirst().get();
    }

}
