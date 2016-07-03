/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey.config;

import org.farrukh.example.spring.jersey.exception.PostNotFoundExceptionMapper;
import org.farrukh.example.spring.jersey.inbound.PostController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(PostController.class);
        register(PostNotFoundExceptionMapper.class);

        // In order to serve static content, we need set this property.
        property(ServletProperties.FILTER_FORWARD_ON_404, true);

    }

}
