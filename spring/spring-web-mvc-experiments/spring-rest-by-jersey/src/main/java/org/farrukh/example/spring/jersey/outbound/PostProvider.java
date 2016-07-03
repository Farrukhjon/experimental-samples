/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey.outbound;

import org.farrukh.example.spring.jersey.domain.Post;

import java.util.List;

public interface PostProvider {

    List<Post> retrievePosts();

    Post retrievePost(long id);
}
