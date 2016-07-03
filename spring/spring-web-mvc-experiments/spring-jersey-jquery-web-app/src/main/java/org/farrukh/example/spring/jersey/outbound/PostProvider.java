/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey.outbound;

import org.farrukh.example.spring.jersey.domain.Post;

import java.util.List;

/**
 * Responsible for interacting with 3d party post service.
 */
public interface PostProvider {

    /**
     * Retrieves all posts from remote post service.
     * @return List of posts.
     */
    List<Post> retrievePosts();

    /**
     * Retrieves a post by given id.
     * @param id a post id.
     * @return post.
     */
    Post retrievePost(long id);
}
