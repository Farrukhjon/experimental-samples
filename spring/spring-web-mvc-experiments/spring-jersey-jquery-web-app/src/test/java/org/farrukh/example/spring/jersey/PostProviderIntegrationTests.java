/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey;

import org.farrukh.example.spring.jersey.domain.Post;
import org.farrukh.example.spring.jersey.outbound.PostProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest
public class PostProviderIntegrationTests {

    @Autowired
    private PostProvider postProvider;

    @Test
    public void shouldRetrievePosts() {
        List<Post> posts = postProvider.retrievePosts();
        Assert.assertNotNull(posts);
    }

    @Test
    public void shouldRetrievePostById() {
        long postId = 1;
        long expectedPostId = postId;
        Post post = postProvider.retrievePost(postId);
        Assert.assertNotNull(post);
        Assert.assertEquals(expectedPostId, post.getId());
    }

}
