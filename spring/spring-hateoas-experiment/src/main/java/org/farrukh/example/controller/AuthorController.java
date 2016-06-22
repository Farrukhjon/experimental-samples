/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <firedandy@gmail.com>, May 2016.
 *
 */

package org.farrukh.example.controller;

import org.farrukh.example.domain.model.Author;
import org.farrukh.example.domain.resource.AuthorResource;
import org.farrukh.example.repository.AuthorRepository;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@ExposesResourceFor(Author.class)
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<AuthorResource> getAuthorById(@PathVariable String id) {
        Author author = authorRepository.findOne(id);
        AuthorResource authorResource = new AuthorResource();
        authorResource.setAuthor(author);
        return ResponseEntity.ok(authorResource);
    }

}
