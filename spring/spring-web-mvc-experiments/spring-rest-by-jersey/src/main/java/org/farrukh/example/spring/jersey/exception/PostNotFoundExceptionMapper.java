/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PostNotFoundExceptionMapper implements ExceptionMapper<PostNotFoundException> {

    @Override
    public Response toResponse(final PostNotFoundException error) {
        return Response.status(error.getHttpStatus())
                       .type(MediaType.APPLICATION_JSON)
                       .entity((new ErrorResponse(error.getCode(), error.getMessage())))
                       .build();
    }
}
