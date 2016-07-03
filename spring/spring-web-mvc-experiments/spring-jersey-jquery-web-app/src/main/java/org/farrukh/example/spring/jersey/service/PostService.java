/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey.service;

import org.farrukh.example.spring.jersey.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getPosts();

    /**
     * It try to retrieve a post from database and if the post is there returns it.
     * If there is no any post in the database it will ask for post provider.
     * @param id the post identifier.
     * @return the post.
     */
    Optional<Post> getPost(final long id);

}
