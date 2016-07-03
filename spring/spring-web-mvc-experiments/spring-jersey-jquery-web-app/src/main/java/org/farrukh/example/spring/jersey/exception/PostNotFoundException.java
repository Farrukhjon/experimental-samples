/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey.exception;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends RuntimeException {

    /**
     * Additional error code that matter for feedback handling.
     */
    private static final int POST_ERROR_CODE = 1000;

    public PostNotFoundException(final long postId) {
        super("Post with id: " + postId + " not found");
    }

    public int getCode() {
        return POST_ERROR_CODE;
    }

    public int getHttpStatus() {
        return HttpStatus.NOT_FOUND.value();
    }

}
